package org.generation.lojinhaGamesdaTay.controller;

import java.util.List;
import java.util.Optional;

import org.generation.lojinhaGamesdaTay.model.CategoriaModel;
import org.generation.lojinhaGamesdaTay.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socorro")
@CrossOrigin("*") //pode ser consumido de qualquer origem
public class CategoriaController {
	
	@Autowired 
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel>  GetByIdCategoria(@PathVariable long id){
		
		return repository.findById(id) 
			.map(resp   ->  ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build()); 

	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	@PostMapping 
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel descricao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	}
	
	@PutMapping 
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel descricao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(descricao));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarById (@PathVariable long id) {
		Optional<CategoriaModel> UsuarioExistente = repository.findById(id);
		
		if (UsuarioExistente.isPresent()){
			repository.deleteById(id);
			return ResponseEntity.ok().body("Usuario deletado more");
		}
		else {
		}
		return null;
		
	}	
}