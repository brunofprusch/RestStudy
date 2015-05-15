package br.com.reststudy.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.reststudy.model.Filme;

@XmlRootElement
public class FilmeDTO {

	private Long id;
	private String nome;
	private String pais;
	private int ano;
	private String genero;
	private int nota;
	private String pathImagem;
	
	
	public static List<FilmeDTO> listFilmeToListFilmeDTO(List<Filme> listFilme){
		
		List<FilmeDTO> listDTO = new ArrayList<FilmeDTO>();
		
		if(listFilme.size() > 0){
			
			for(Filme filme : listFilme){
				FilmeDTO filmeDTO = new FilmeDTO();
				filmeDTO.setId(filme.getId());
				filmeDTO.setNome(filme.getNome());
				filmeDTO.setAno(filme.getAno());
				filmeDTO.setPais(filme.getPais());
				filmeDTO.setGenero(filme.getGenero());
				filmeDTO.setNota(filme.getNota());
				filmeDTO.setPathImagem(filme.getPathImagem());
				
				listDTO.add(filmeDTO);
			}	
		}
		return listDTO;
	}
	
	public static FilmeDTO filmeToFilmeDTO(Filme filme){
		
		FilmeDTO filmeDTO = new FilmeDTO();
		filmeDTO.setId(filme.getId());
		filmeDTO.setNome(filme.getNome());
		filmeDTO.setPais(filme.getPais());
		filmeDTO.setAno(filme.getAno());
		filmeDTO.setGenero(filme.getGenero());
		filmeDTO.setNota(filme.getNota());
		filmeDTO.setPathImagem(filme.getPathImagem());
		
		return filmeDTO;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getPathImagem() {
		return pathImagem;
	}
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}
}
