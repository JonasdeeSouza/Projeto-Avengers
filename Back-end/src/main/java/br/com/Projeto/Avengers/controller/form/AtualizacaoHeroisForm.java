package br.com.Projeto.Avengers.controller.form;

import br.com.Projeto.Avengers.orm.Herois;
import br.com.Projeto.Avengers.repository.HeroisRepository;

public class AtualizacaoHeroisForm {

	private String nome;
	private String codinome;
	
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
	
	public Herois atualizar(Long id, HeroisRepository heroisRepository) {
		Herois h1 = heroisRepository.getOne(id);
		h1.setNome(this.nome);
		h1.setCodinome(this.codinome);
		return h1;
	}
	
}
