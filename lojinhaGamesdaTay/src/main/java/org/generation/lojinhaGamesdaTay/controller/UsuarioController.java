package org.generation.lojinhaGamesdaTay.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.generation.lojinhaGamesdaTay.model.Usuario;
import org.generation.lojinhaGamesdaTay.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	

	@Autowired
	private UsuarioDTO usuarioService;
	
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioDTO> Autentication(@RequestBody Optional<UsuarioDTO> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> Post(@Valid @RequestBody org.generation.lojinhaGamesdaTay.model.Usuario usuario ){ //valid (analisar )
		Optional<Usuario> objetoCreado = usuarioService.CadastrarUsuario(usuario);
		if (objetoCreado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario Existente!");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(objetoCreado.get());
		}
		
		
	}
	
}
