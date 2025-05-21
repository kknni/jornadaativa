package br.com.belval.api.jornadaativa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.belval.api.jornadaativa.model.tipoTreino;
import br.com.belval.api.jornadaativa.repository.tipoTreinoRepository;

@RestController
public class tipotreinoController {

	@Autowired
	private tipoTreinoRepository repository;
	
	@GetMapping("/tipoTreino")
	public ResponseEntity<Iterable<tipoTreino>> obtertipoTreino(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/tipotreino/{idtipoTreino}")
	public ResponseEntity<Object> buscarPoridtipoTreino(
			@PathVariable(value = "caminhada") Integer idtipoTreino){
		
		Optional<tipoTreino> tipoTreino = repository.findById(idtipoTreino);
		
		if (tipoTreino.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(tipoTreino.get());
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("tipoTreino não encontrada");
	}
	
	//curl POST 	 -H "Content-Type: application/json; Charset=utf-8" -d @novaTipoTreino.json 
	@PostMapping("/tipoTreino")
	public ResponseEntity<tipoTreino> criartipoTreino(
			@RequestBody tipoTreino tipoTreino){
		
		System.out.println("tipoTreino ..." + tipoTreino.toString());
		repository.save(tipoTreino);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(tipoTreino);
	}
	
	//curl -X PUT http://localhost:8080/provas/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizarTipoTreino.json
	
	@PostMapping("/tipoTreino/{idtipoTreino}")
	public ResponseEntity<Object> atualizartipoTreino(
			@PathVariable Integer idtipoTreino,
			@RequestBody tipoTreino prod){
		
		Optional<tipoTreino> tipoTreino = repository.findById(idtipoTreino);
		
		if (tipoTreino.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("tipoTreino não encontrado!");
		}
		
		prod.setidtipoTreino(idtipoTreino);
		repository.save(prod);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("produo atualizado com sucesso!");
	}
	
	//curl -X  http://localhost:8080/provas/{id}/deletar -H "Content-Type: application/json; Charset=utf-8" -d @deletarTipoTreino.json
	@DeleteMapping("/tipotreino/{idtipoTreino}/deletar")
	public ResponseEntity<Object> deletartipoTreino(
			@PathVariable Integer idtipoTreino){
		
		Optional<tipoTreino> tipoTreinoOptinal = repository.findById(idtipoTreino);
		
		if (tipoTreinoOptinal.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("tipoTreino não encontrado!");
	}
		
		tipoTreino tipoTreino = tipoTreinoOptinal.get();
		repository.delete(tipoTreino);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("tipoTreino deletado com sucesso!");
	}
	
}
