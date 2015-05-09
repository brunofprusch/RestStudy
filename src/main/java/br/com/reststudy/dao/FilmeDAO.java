package br.com.reststudy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.reststudy.dto.FilmeDTO;
import br.com.reststudy.model.Filme;

public class FilmeDAO {
	
	private static FilmeDAO instance;
	
	public static FilmeDAO getInstance(){
		if(instance == null){
			instance = new FilmeDAO();
		}
		return instance;
	}
	
	
	public static EntityManager createEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("reststudy");
		EntityManager em = factory.createEntityManager();
		return em;
	}
	
	public List<FilmeDTO> listAll(EntityManager em){
		
		List<Filme> listFilmes = new ArrayList<Filme>();
		
		try{
			
			TypedQuery<Filme> query = em.createQuery("select f from Filme f ", Filme.class);
			
			listFilmes = query.getResultList();
			
		}catch(NoResultException nre){
			System.out.println("Nenhum filme cadastrado na tabela");
		}
		
		return FilmeDTO.listFilmeToListFilmeDTO(listFilmes);
	}
	
	public FilmeDTO load(EntityManager em, Long id){
		
		Filme filme = new Filme();
		
		try{
			
			filme = em.find(Filme.class, id);
		
		}catch(Exception e){
			System.out.println("Erro ao buscar o Filme de id = " + id);
		}
		
		return FilmeDTO.filmeToFilmeDTO(filme);
	}
	
}
