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

import br.com.Projeto.Avengers.controller.dto.DetalhesDoHeroisDto;
import br.com.Projeto.Avengers.controller.dto.HeroisDto;
import br.com.Projeto.Avengers.controller.form.AtualizacaoHeroisForm;
import br.com.Projeto.Avengers.controller.form.HeroisForm;
import br.com.Projeto.Avengers.orm.Herois;
import br.com.Projeto.Avengers.repository.HeroisRepository;

@RestController
@RequestMapping("/Herois")
public class HeroisController {

	@Autowired
	private HeroisRepository heroisRepository;
	
	//MOSTRA A LISTA DE HERÓIS CADASTRADOS.
	
	@GetMapping
	public List<HeroisDto>lista(String Heroi, String nome) {
		if (Heroi == null) {
			List<Herois> Herois = heroisRepository.findAll();
			return HeroisDto.converter(Herois);
		} else {
			List<Herois> Herois = heroisRepository.findByNome(nome);
			return HeroisDto.converter(Herois);
		}
	}

	//CADASTRA OS HERÓIS.
	
	@PostMapping
	public ResponseEntity<HeroisDto> cadastrar(@RequestBody HeroisForm form, UriComponentsBuilder uriBuilder) {
		Herois h1 = form.converter(heroisRepository);
		heroisRepository.saveAndFlush(h1);
		
		URI uri = uriBuilder.path("/Herois/{id}").buildAndExpand(h1.getId()).toUri();
		return ResponseEntity.created(uri).body(new HeroisDto(h1));
	}
	
	//DETALHA UM HERÓI.
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoHeroisDto> detalhar(@PathVariable Long id) {
		Optional<Herois> h1 = heroisRepository.findById(id);
		if (h1.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoHeroisDto(h1.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//ATUALIZA UM HERÓI.
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<HeroisDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoHeroisForm form){
		Optional<Herois> optional = heroisRepository.findById(id);
		if (optional.isPresent()) {
			Herois h1 = form.atualizar(id, heroisRepository);
			return ResponseEntity.ok(new HeroisDto(h1));
		}
		return ResponseEntity.notFound().build();
	}
	
	//APAGA UM HERÓI.
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Herois> optional = heroisRepository.findById(id);
		if (optional.isPresent()) {
			heroisRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
