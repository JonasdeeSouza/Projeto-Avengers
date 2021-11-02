package br.com.Projeto.Avengers.controller.form;

import java.util.List;

import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.orm.Herois;
import br.com.Projeto.Avengers.repository.HeroisRepository;

public class HeroisForm {

	private Long id;
	private String nome;
	private String codinome;
	private List<Filmes> filme;
	
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
	
	public String getCodinome() {
		return codinome;
	}
	
	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}
	
	public Herois converter(HeroisRepository heroisRepository) {
		return new Herois(id, nome, codinome);
	}
	
	public List<Filmes> getFilme() {
		return filme;
	}
	
	public void setFilme(List<Filmes> filme) {
		this.filme = filme;
	}
	
}
