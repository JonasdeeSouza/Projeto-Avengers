package br.com.Projeto.Avengers.controller.dto;

import br.com.Projeto.Avengers.orm.Filmes;

public class DetalhesDoFilmesDto {

	private Long id;
	private String nomeFilme;
	private int ano;
	
	public DetalhesDoFilmesDto(Filmes filme) {
		this.id = filme.getId();
		this.nomeFilme = filme.getNomeFilme();
		this.ano = filme.getAno();
	}
	public Long getId() {
		return id;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public int getAno() {
		return ano;
	}
	
	
	
}
