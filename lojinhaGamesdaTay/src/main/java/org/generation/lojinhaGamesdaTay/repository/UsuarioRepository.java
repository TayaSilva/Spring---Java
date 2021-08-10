package org.generation.lojinhaGamesdaTay.repository;

import java.util.Optional;

import org.generation.lojinhaGamesdaTay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

	public Optional<Usuario> findByEmail (String email);

	public Optional<Usuario> findByUsuario(long id_usuario);
	}

