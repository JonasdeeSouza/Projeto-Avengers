package br.com.Projeto.Avengers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Projeto.Avengers.orm.Herois;

public interface HeroisRepository extends JpaRepository<Herois, Long>{

	List<Herois> findByNome(String id);

	void saveAndFlush(Optional<Herois> h1);
}
