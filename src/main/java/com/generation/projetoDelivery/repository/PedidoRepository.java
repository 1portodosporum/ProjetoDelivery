package com.generation.projetoDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projetoDelivery.model.Produto;

public interface PedidoRepository extends JpaRepository<Produto, Long>{

    public List<Produto> findAllByStatusContainingIgnoreCase(String status);
}
