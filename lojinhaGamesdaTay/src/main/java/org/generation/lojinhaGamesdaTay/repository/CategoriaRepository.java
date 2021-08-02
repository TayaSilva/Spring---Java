package org.generation.lojinhaGamesdaTay.repository;

import java.util.List;

import org.generation.lojinhaGamesdaTay.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long>{

	public List<CategoriaModel> findAllByNomeContainingIgnoreCase (String nome);

}
