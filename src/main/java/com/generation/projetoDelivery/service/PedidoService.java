package com.generation.projetoDelivery.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.generation.projetoDelivery.model.Pedido;
// import com.generation.projetoDelivery.model.Produto;
import com.generation.projetoDelivery.repository.PedidoRepository;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public double calcularValorTotal(Pedido pedido) {
        double valorTotal = 0;
        
        valorTotal = pedido.getQuantidade() * pedido.getProduto().getPreco();
        return valorTotal;
    }

    public List<Map<String, Object>> listarPedidos() {
        return pedidoRepository.findAll().stream().map(pedido -> {
            Map<String, Object> response = new HashMap<>();
            response.put("Valor Total:", calcularValorTotal(pedido));
            return response;
        }).collect(Collectors.toList());
    }

}