package br.com.Projeto.Avengers.controller.form;

import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.repository.FilmesRepository;

public class FilmesForm {

	private Long id;
	private String nomeFilme;
	private int ano;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Filmes converter(FilmesRepository filmesRepository) {
		return new Filmes(id, nomeFilme, ano);
	}
	
}
