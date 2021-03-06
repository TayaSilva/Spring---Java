package com.generation.Farmacita.Controller;

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

import com.generation.Farmacita.Model.ProdutoModel;
import com.generation.Farmacita.Repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pp")
public class ProdutoController {

	
		
		@Autowired 
		private ProdutoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<ProdutoModel>> GetAll(){
			
			return ResponseEntity.ok(repository.findAll());
		
		}
		@GetMapping("/id")
		public ResponseEntity<ProdutoModel>  getById(@PathVariable long id){
			return repository.findById(id). map (resp  -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		
		
		@PostMapping
		public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel preco){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(preco));
		}
		
		
		@PutMapping
		public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel produtoModel){
			return ResponseEntity.ok(repository.save(produtoModel));
	}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deletarById (@PathVariable long id) {
			Optional<ProdutoModel> UsuarioExistente = repository.findById(id);
			
			if (UsuarioExistente.isPresent()){
				repository.deleteById(id);
				return ResponseEntity.ok().body("Usuario deletado more");
			}
			else {
				return null;
			}
			
			
		
		}
	
}

	
