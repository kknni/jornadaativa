package br.com.belval.api.jornadaativa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.jornadaativa.model.Prova;
import br.com.belval.api.jornadaativa.model.TipoProva;
import br.com.belval.api.jornadaativa.repository.TipoProvaRepository;

@RestController
public class TipoProvaController {

	@Autowired
	private TipoProvaRepository repository;

	@GetMapping("/tipoprovas")
	public ResponseEntity<Iterable<TipoProva>> obterTipoProva() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());

	}

	@GetMapping("/tipoprovas/{id}")
	public ResponseEntity<Object> buscarPorid(
			@PathVariable(value = "id") Integer id){

		Optional<TipoProva> tipoProva = repository.findById(id);

		if (tipoProva.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(tipoProva.get());
		}

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Prova não encontrada");

	}
	
	//curl -X POST http://localhost:8080/tipoprovas -H "Content-Type: application/json; Charset=utf-8" -d @novo-tipoprova.json 


	@PostMapping("/tipoprovas")
	public ResponseEntity<TipoProva> criarTipoProva(
			@RequestBody TipoProva tipoProva) {
		
		System.out.println("TipoProva criado..." + tipoProva.toString());
		repository.save(tipoProva);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(tipoProva);

	}
	
	//curl -X PUT http://localhost:8080/tipoprovas/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-tipoprova.json


	@PutMapping("/tipoprovas/{id}")
	public ResponseEntity<Object> atualizarTipoProva(
			@PathVariable Integer id,
			@RequestBody TipoProva prod) {

		Optional<TipoProva> tipoProva = repository.findById(id);

		if (tipoProva.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Tipo Prova não encontrada");

		}

		prod.setId(id);
		repository.save(prod);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Tipo Prova atualizado com sucesso!");

	}
	
	//curl -X DELETE  http://localhost:8080/tipoprova/{id}/deletar -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-tipoprova.json


	@DeleteMapping("/tipoprova/{id}/deletar")
	public ResponseEntity<Object> deletarTipoProva(
			@PathVariable Integer id) {

		Optional<TipoProva> tipoProvaOptional = repository.findById(id);

		if (tipoProvaOptional.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Tipo Prova não encontrada");

		}
		
		TipoProva tipoprova = tipoProvaOptional.get();
		repository.delete(tipoprova);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Tipo Prova deletada com sucesso!");

	}

}
