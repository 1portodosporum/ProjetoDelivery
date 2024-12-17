package com.generation.projetoDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projetoDelivery.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByCategoriaContainingIgnoreCase(@Param("categoria")String categoria);

}
