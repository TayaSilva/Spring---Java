package com.projetinhos.Blogs.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetinhos.Blogs.model.UserLoguin;
import com.projetinhos.Blogs.model.Usuario;
import com.projetinhos.Blogs.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping("/logar")
	public ResponseEntity<UserLoguin> Autentication(@RequestBody Optional<UserLoguin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> Post(@Valid @RequestBody Usuario usuario ){ //valid (analisar )
		Optional<Usuario> objetoCreado = usuarioService.CadastrarUsuario(usuario);
		if (objetoCreado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario Existente!");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(objetoCreado.get());
		}
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
