package com.projetinhos.Blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetinhos.Blogs.model.Postagens;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long> {
		public List<Postagens> findAllByTituloContainingIgnoreCase (String titulo);
		
		//Containing é igual o like
		//Ignore case vai padronizar tudo 
}
