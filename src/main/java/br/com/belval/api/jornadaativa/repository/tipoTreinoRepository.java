package br.com.belval.api.jornadaativa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.jornadaativa.model.tipoTreino;

public interface tipoTreinoRepository extends CrudRepository<tipoTreino, Integer> {
	

	List<tipoTreino> findByLocalContainingIgnoreCase(String local);

	Optional<tipoTreino> findBycaminhada(Integer caminhada);
}
