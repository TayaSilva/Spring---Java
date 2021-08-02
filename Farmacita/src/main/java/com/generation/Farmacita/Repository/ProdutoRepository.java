package com.generation.Farmacita.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Farmacita.Model.ProdutoModel;



public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{


	public List<ProdutoModel> findAllByMarcaContainingIgnoreCase(String marca);
}
