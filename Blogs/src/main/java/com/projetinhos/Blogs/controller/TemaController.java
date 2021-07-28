
package com.projetinhos.Blogs.controller;

import java.util.List;
import java.util.Optional;

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

import com.projetinhos.Blogs.model.Tema;
import com.projetinhos.Blogs.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

	@Autowired //ejetar o serviço 
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Tema>  getById(@PathVariable long id){
		return repository.findById(id). map (resp  -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/nome{nome}")
	public ResponseEntity<List<Tema>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return ResponseEntity.ok(repository.save(tema));
}
	/*
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarById (@PathVariable long id) {
		Optional<Tema> UsuarioExistente = repository.findById(id);
		
		if (UsuarioExistente.isPresent()){
			repository.deleteById(id);
			return ResponseEntity.ok().body("Usuario deletado more");
		}
		else {
		}
		
		
		
		
		
		
	
	
	
	
	
	}
	
}

