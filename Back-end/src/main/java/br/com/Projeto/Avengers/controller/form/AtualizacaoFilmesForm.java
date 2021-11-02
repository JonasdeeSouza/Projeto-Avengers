package br.com.Projeto.Avengers.controller.form;

import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.repository.FilmesRepository;

public class AtualizacaoFilmesForm {

	private String nomeFilme;
	private int ano;
	
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

	public Filmes atualizar(Long id, FilmesRepository filmesRepository) {
		Filmes filme = filmesRepository.getOne(id);
		filme.setNomeFilme(this.nomeFilme);
		filme.setAno(this.ano);
		return filme;
	}
	
}
