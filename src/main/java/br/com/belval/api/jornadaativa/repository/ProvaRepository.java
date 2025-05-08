package br.com.belval.api.jornadaativa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.jornadaativa.model.Prova;

public interface ProvaRepository extends CrudRepository<Prova, Integer> {
	
	
	List<Prova> findByLocalContainingIgnoreCase(String local);
}
