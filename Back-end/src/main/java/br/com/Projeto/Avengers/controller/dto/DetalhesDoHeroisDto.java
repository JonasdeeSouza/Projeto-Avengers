package br.com.Projeto.Avengers.controller.dto;

import br.com.Projeto.Avengers.orm.Herois;

public class DetalhesDoHeroisDto {

	private long id;
	private String nome;
	private String codinome;
		
	public DetalhesDoHeroisDto(Herois h1) {
		this.codinome = h1.getCodinome();
		this.nome = h1.getNome();
		this.id = h1.getId();
	}

	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public String getCodinome() {
		return codinome;
	}
	
}






