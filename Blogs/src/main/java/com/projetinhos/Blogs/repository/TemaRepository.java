
package com.projetinhos.Blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetinhos.Blogs.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
	

}
