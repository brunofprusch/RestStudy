package br.com.reststudy.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import antlr.StringUtils;
import br.com.reststudy.dao.FilmeDAO;
import br.com.reststudy.dto.FilmeDTO;
import br.com.reststudy.model.Filme;

@Path("/filme")
public class FilmeService {

	
	@GET
	@Path("/filmes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FilmeDTO> listAll() {
		
		EntityManager em = FilmeDAO.getInstance().createEntityManager();
		
		List<FilmeDTO> list = new ArrayList<FilmeDTO>();
		
		list = FilmeDAO.getInstance().listAll(em);
		
		return list;
	}
	
	
	@GET
	@Path("/filme")
	@Produces(MediaType.APPLICATION_JSON)
	public FilmeDTO loadFilme(@QueryParam("id") Long id) {
		
		EntityManager em = FilmeDAO.getInstance().createEntityManager();
		
		FilmeDTO filmeDTO = FilmeDAO.getInstance().load(em, id);
		
		if(filmeDTO.getId() != null){
			return filmeDTO;
		}
		
		throw new WebApplicationException(Status.NOT_FOUND);
		
		
	}
	
	
	@POST
	@Path("/create")
	public Response createFilme(FilmeDTO filmeDTO){
		
		EntityManager em = FilmeDAO.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		Filme filme = new Filme();
		filme.setNome(filmeDTO.getNome());
		filme.setNota(filmeDTO.getNota());
		filme.setPais(filmeDTO.getPais());
		filme.setGenero(filmeDTO.getGenero());
		filme.setAno(filmeDTO.getAno());
		filme.setPathImagem(filmeDTO.getPathImagem());
		
		FilmeDAO.getInstance().save(em, filme);
		
		em.getTransaction().commit();
		
		URI uri = UriBuilder.fromPath("/filme/filme?id=" + filme.getId()).build(filme.getId());
		
		return Response.created(uri).entity(filme).build();
	}
	
}
