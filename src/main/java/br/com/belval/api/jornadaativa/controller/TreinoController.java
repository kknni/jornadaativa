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

import br.com.belval.api.jornadaativa.model.Treino;
import br.com.belval.api.jornadaativa.repository.TreinoRepository;



@RestController
public class TreinoController {
	@Autowired
	private TreinoRepository repository;
	
	@GetMapping ("/treinos")
	public ResponseEntity<Iterable<Treino>> obterTreino() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/treinos/{id}")
	public ResponseEntity<Object> buscarPorid(
			@PathVariable ( value = "id") Integer id) {
		
		Optional<Treino> treino = repository.findById(id);
		
		if (treino.isPresent()) {
			return ResponseEntity
				    .status(HttpStatus.OK)
				    .body(treino.get());
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Treino não encontrado!");
		
	}
	
	//curl -X POST http://localhost:8080/treinos	-H "Content-Type: application/json; Charset=utf-8" -d @novotreino.json
	@PostMapping("/treinos")
	public ResponseEntity<Treino> criarTreino(
			@RequestBody Treino treino) {
		System.out.println("Treino criado ..." + treino.toString());
		repository.save(treino);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(treino);
	}
	
	//curl -X PUT http://localhost:8080/treinos/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizartreino.json
	@PutMapping("/treinos/{id}")
	public ResponseEntity<Object> atualizarTreino(
			@PathVariable Integer id,
			@RequestBody Treino prod){
		
		Optional<Treino> treino = repository.findById(id);
		
		if (treino.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Treino não encontrado!");
		}
		
		prod.setId(id);
		repository.save(prod);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Treino atualizado com sucesso!");
	}
	
// curl -X DELETE http://localhost:8080/treinos/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualizartreino.json
	@DeleteMapping("/treinos/{id}")
	public ResponseEntity<Object> deletarTreino(
			@PathVariable Integer id){
		
		Optional<Treino> treinoOptional = repository.findById(id);
		
		if (treinoOptional.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Treino não encontrada!");
		}
		
		Treino treino = treinoOptional.get();
		repository.delete(treino);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Treino deletado com sucesso!");
	}

}
