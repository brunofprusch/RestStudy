package br.com.reststudy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filme {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String pais;
	private int ano;
	private String genero;
	private int nota;
	private String pathImagem;

	public Filme() {
	}

	public Filme(Long id, String nome, String pais, int ano, String genero,
			int nota, String pathImage) {
		this.setId(id);
		this.setNome(nome);
		this.setPais(pais);
		this.setAno(ano);
		this.setGenero(genero);
		this.setNota(nota);
		this.setPathImagem(pathImage);
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
