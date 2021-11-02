package br.com.Projeto.Avengers.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Projeto.Avengers.controller.dto.DetalhesDoFilmesDto;
import br.com.Projeto.Avengers.controller.dto.FilmesDto;
import br.com.Projeto.Avengers.controller.form.AtualizacaoFilmesForm;
import br.com.Projeto.Avengers.controller.form.FilmesForm;
import br.com.Projeto.Avengers.orm.Filmes;
import br.com.Projeto.Avengers.repository.FilmesRepository;

@RestController
@RequestMapping("/Filmes")
public class FilmesController {

	@Autowired
	private FilmesRepository filmesRepository;
	
	//MOSTRA A LISTA DE FILMES CADASTRADOS.
	
	@GetMapping
	public List<FilmesDto> lista(String nomeFilme) {
		if (nomeFilme == null) {
			List<Filmes> filme = filmesRepository.findAll();
			return FilmesDto.converter(filme);
		} else {
			List<Filmes> filme = filmesRepository.findBynomeFilme(nomeFilme);
			return FilmesDto.converter(filme);
		}
	}
	
	//CADASTRA OS FILMES.
	
	@PostMapping
	public ResponseEntity<FilmesDto> cadastrar(@RequestBody FilmesForm form, UriComponentsBuilder uriBuilder) {
		Filmes filme = form.converter(filmesRepository);
		filmesRepository.saveAndFlush(filme);
		
		URI uri = uriBuilder.path("/Filmes/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).body(new FilmesDto(filme));
	}
	
	//DETALHA UM FILME.
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoFilmesDto> detalhar(@PathVariable Long id) {
		Optional<Filmes> filme = filmesRepository.findById(id);
		if (filme.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoFilmesDto(filme.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//ATUALIZA UM FIME.
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FilmesDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoFilmesForm form){
		Optional<Filmes> optional = filmesRepository.findById(id);
		if (optional.isPresent()) {
			Filmes filme = form.atualizar(id, filmesRepository);
			return ResponseEntity.ok(new FilmesDto(filme));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//APAGA UM FILME.
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Filmes> optional = filmesRepository.findById(id);
		if (optional.isPresent()) {
			filmesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}