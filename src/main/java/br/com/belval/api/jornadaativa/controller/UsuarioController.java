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

import br.com.belval.api.jornadaativa.model.Usuario;
import br.com.belval.api.jornadaativa.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> obterUsuario() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> buscarPorid(
			@PathVariable(value = "id") Integer id){
		
		Optional<Usuario> usuario = repository.findById(id);
			 
		if (usuario.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(usuario.get());
			
		}
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Usuario não encontrado!");
	}
	
	
	// curl POST http://localhost:8080/usuarios -H "Content-Type: application/json; Charset=utf-8" -d @novo-usuario.json
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> criaUsuario(
			@RequestBody Usuario usuario){
	
		
		System.out.println("Usuario criado..." + usuario.toString());
		repository.save(usuario);
		
		return  ResponseEntity
				.status(HttpStatus.CREATED)
				.body(usuario);
	}
	
	// curl -X PUT http://localhost:8080/usuarios/{1} -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-usuario.json
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> atualizarUsuario(
			@PathVariable Integer id,
			@RequestBody Usuario prod){
		
		Optional<Usuario> usuario = repository.findById(id);
		
		if (usuario.isEmpty()) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		prod.setId(id);
		repository.save(prod);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Usuario atualizado com sucesso!");
	}
	
	//curl -X DELETE http://localhost:8080/usuarios/{1}/deletar -H "Content-Type: application/json; Charset=utf-8" -d @atualizar-usuario.json
	@DeleteMapping("/usuarios/id/deletar")
	public ResponseEntity<Object> deletarProva(
			@PathVariable Integer id){
		
		Optional<Usuario> usuarioOptional = repository.findById(id);
		
		if (usuarioOptional.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrada!");
		}
		
		Usuario usuario = usuarioOptional.get();
		repository.delete(usuario);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Usuario deletado com sucesso!");
	}
}
