package br.com.Projeto.Avengers.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.Projeto.Avengers.orm.Filmes;

public class FilmesDto {

	private Long id;
	private String nomeFilme;
	private int ano;
	
	public FilmesDto(Filmes filme) {
		this.nomeFilme = filme.getNomeFilme();
		this.ano = filme.getAno();
		this.id = filme.getId();
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

	public static List<FilmesDto> converter(List<Filmes> filme) {
		return filme.stream().map(FilmesDto::new).collect(Collectors.toList());
	}

}
