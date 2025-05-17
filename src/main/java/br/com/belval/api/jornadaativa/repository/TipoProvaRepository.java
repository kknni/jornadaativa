package br.com.belval.api.jornadaativa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.api.jornadaativa.model.TipoProva;

 
public interface TipoProvaRepository extends CrudRepository <TipoProva, Integer>  {
	List<TipoProva> findByLocalContainingIgnoreCase(String local);
 
}
 
