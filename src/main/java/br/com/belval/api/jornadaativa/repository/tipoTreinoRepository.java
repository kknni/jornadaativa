package br.com.belval.api.jornadaativa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.jornadaativa.model.tipoTreino;

public interface tipoTreinoRepository extends CrudRepository<tipoTreino, Integer> {
	

	List<tipoTreino> findByresistenciaContainingIgnoreCase(String resistencia);

	List<tipoTreino> findBycaminhadaContainingIgnoreCase(String caminhada);
}
