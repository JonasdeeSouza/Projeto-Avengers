package br.com.Projeto.Avengers.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.Projeto.Avengers.controller.dto.HeroisDto;
import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.orm.Herois;
import br.com.Projeto.Avengers.repository.FilmesRepository;
import br.com.Projeto.Avengers.repository.HeroisRepository;

@RestController
public class HeroisEFilmesController {

	@Autowired
	private HeroisRepository heroisRepository;
	
	@Autowired
	private FilmesRepository filmesRepository;

	//MOSTRA A LISTA DE HERÓIS CADASTRADOS.
	
	@RequestMapping(value="/HeroisEFilmes", method = RequestMethod.GET)
	@Transactional
	public List<HeroisDto>lista(String Heroi) {
		List<Herois> herois = heroisRepository.findAll();
		return HeroisDto.converter(herois);
	}	

	//CADASTRA UMA NOVA LIGAÇÃO ENTRE HERÓI E FILME.
	
	@RequestMapping(value="/HeroisEFilmes/{idHeroi}/{idFilme}", method = RequestMethod.POST)
	@Transactional
	public void cadastrar(@PathVariable Long idHeroi, @PathVariable Long idFilme) {
		Herois h1 = heroisRepository.findById(idHeroi).get();
		Filmes filme = filmesRepository.findById(idFilme).get();
		h1.getFilme().add(filme);
		heroisRepository.save(h1);
	}

	//APAGA A LIGAÇÃO DO HERÓI COM O FILME.

	@RequestMapping(value="/HeroisEFilmes/{idHeroi}/{idFilme}", method = RequestMethod.DELETE)
	@Transactional
	public void remover(@PathVariable Long idHeroi, @PathVariable Long idFilme) {
		Herois h1 = heroisRepository.findById(idHeroi).get();
		Filmes filme = filmesRepository.findById(idFilme).get();
		h1.getFilme().remove(filme);
		heroisRepository.saveAndFlush(h1);
	}
}
