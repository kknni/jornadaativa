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
import br.com.belval.api.jornadaativa.repository.ProvaRepository;

@RestController
public class ProvaController {
	
	@Autowired
	private ProvaRepository repository;
	
	@GetMapping("/provas")
	public ResponseEntity<Iterable<Prova>> obterProva() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/provas/{id}")
	public ResponseEntity<Object> buscarPorId(
			@PathVariable( value = "id") Integer id){
		
		Optional<Prova> prova = repository.findById(id);
		
		if (prova.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(prova.get());
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Prova não encontrada!");
	}
	
	
	//curl POST 	 -H "Content-Type: application/json; Charset=utf-8" -d @nova-prova.json 
	
	@PostMapping("/provas")
	public ResponseEntity<Prova> criarProva(
			@RequestBody Prova prova) {
		
		
		System.out.println("Prova criada ..." + prova.toString());
		repository.save(prova);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(prova);
	}
	
	//curl -X PUT http://localhost:8080/provas/1 -H "Content-Type: application/json; Charset=utf-8" -d @atualiza-prova.json
	@PutMapping("/provas/{id}")
	public ResponseEntity<Object> atualizarProva(
			@PathVariable Integer id,
			@RequestBody Prova prod){
		
		Optional<Prova> prova = repository.findById(id);
		
		if (prova.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Prova não encontrada!");
		}
		
		prod.setId(id);
		repository.save(prod);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Produto atualizado com sucesso!");
	}
	
	//curl -X  http://localhost:8080/provas/1/deletar -H "Content-Type: application/json; Charset=utf-8" -d @deleta-prova.json
	@DeleteMapping("/provas/{id}/deletar")
	public ResponseEntity<Object> deletarProva(
			@PathVariable Integer id){
		
		Optional<Prova> provaOptional = repository.findById(id);
		
		if (provaOptional.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Prova não encontrada!");
		}
		
		Prova prova = provaOptional.get();
		repository.delete(prova);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Prova deletado com sucesso!");
	}

}
