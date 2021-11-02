package br.com.Projeto.Avengers.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Herois")
public class Herois {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String codinome;
	
	@ManyToMany
	private List<Filmes> filme;
	
	public Herois() {
	}
	
	public Herois(Long id, String nome, String codinome) {
		this.id = id;
		this.nome = nome;
		this.codinome = codinome;
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
	
	public String getCodinome() {
		return codinome;
	}
	
	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}

	public List<Filmes> getFilme() {
		return filme;
	}

	public void setFilme(List<Filmes> filme) {
		this.filme = filme;
	}
}
