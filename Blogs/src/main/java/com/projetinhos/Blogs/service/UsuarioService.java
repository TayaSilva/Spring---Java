package com.projetinhos.Blogs.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetinhos.Blogs.model.UserLoguin;
import com.projetinhos.Blogs.model.Usuario;
import com.projetinhos.Blogs.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> CadastrarUsuario(Usuario usuario){
		Optional<Usuario> objetoUsuario = repository.findByUsuario(usuario.getUsuario());
		if (objetoUsuario.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			
			return Optional.ofNullable(repository.save(usuario));
		}
	}
	
	public Optional<UserLoguin> Logar(Optional<UserLoguin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic" + new String(encodeAuth);
				
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				
				return user;
			}
		}
			return null;
	
		}
	
}


