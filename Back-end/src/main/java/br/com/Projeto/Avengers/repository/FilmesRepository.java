package br.com.Projeto.Avengers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Projeto.Avengers.orm.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long>{

	List<Filmes> findBynomeFilme (String nomeFilme);
}
