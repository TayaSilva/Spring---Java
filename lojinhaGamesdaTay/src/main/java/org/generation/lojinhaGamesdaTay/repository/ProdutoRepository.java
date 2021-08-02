package org.generation.lojinhaGamesdaTay.repository;


import org.generation.lojinhaGamesdaTay.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
