package br.com.Projeto.Avengers.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Filme")
public class Filmes {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFilme;
	private int ano;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public Filmes() {
		
	}
	
	public Filmes(Long id, String nomeFilme, int ano) {
		this.id = id;
		this.nomeFilme = nomeFilme;
		this.ano = ano;
	}

}



