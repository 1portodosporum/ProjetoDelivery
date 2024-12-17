package com.generation.projetoDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projetoDelivery.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public List<Pedido> findAllByStatusContainingIgnoreCase(String status);
}
