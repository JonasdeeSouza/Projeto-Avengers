package br.com.Projeto.Avengers.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.OneToMany;

import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.orm.Herois;

public class HeroisDto {

	private Long id;
	private String nome;
	private String codinome;
	@OneToMany
	private List<Filmes> filme;
	
	public HeroisDto(Herois h1) {
		this.id = h1.getId();
		this.codinome = h1.getCodinome();
		this.nome = h1.getNome();
		this.filme = h1.getFilme();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCodinome() {
		return codinome;
	}
	
	public List<Filmes> getFilme() {
		return filme;
	}

	public static List<HeroisDto> converter(List<Herois> Herois) {
		return Herois.stream().map(HeroisDto::new).collect(Collectors.toList());
	}
}
