package br.com.reststudy.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.reststudy.dao.FilmeDAO;
import br.com.reststudy.dto.FilmeDTO;

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
		
		return filmeDTO;
	}	
}
