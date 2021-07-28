package com.projetinhos.Blogs.controller;

import java.util.List;

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

import com.projetinhos.Blogs.model.Postagens;
import com.projetinhos.Blogs.repository.PostagensRepository;

@RestController
@RequestMapping("/postagem") //definir a rota (url)
@CrossOrigin("*") //pode ser consumido de qualquer origem
public class PostagensController {
	
	@Autowired 
	private PostagensRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens>  GetById(@PathVariable long id){
		
		return repository.findById(id) // Vai ser acessado esse metodo que vai capiturar a variavel e retornar a interface
				.map(resp   ->  ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build()); //findbyid pode devolver objeto postagens ou notfuld caso não exista ou tenha erro 
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	
	@PostMapping // Quando o objeto for grande a gente passa pelo corpo da requisição
	public ResponseEntity<Postagens> post (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	
	
	
	@PutMapping 
	public ResponseEntity<Postagens> put (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	//template literal
	@DeleteMapping("/{id}")//sem return pq é void e não precisa voltar nada
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
		
	}
	
	
	
}




