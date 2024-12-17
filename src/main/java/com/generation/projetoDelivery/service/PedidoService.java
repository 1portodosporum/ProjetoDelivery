package com.generation.projetoDelivery.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.projetoDelivery.model.Pedido;
import com.generation.projetoDelivery.model.Produto;
import com.generation.projetoDelivery.repository.PedidoRepository;
import com.generation.projetoDelivery.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public double calcularValorTotal(Pedido pedido) {
        double valorTotal = 0;
        valorTotal = pedido.getQuantidade() * pedido.getProduto().getPreco();
        return valorTotal;
    }

    // Atualiza o preco_total no pedido antes de salvar
    public Pedido calcularEAtualizarPrecoTotal(Pedido pedido) {
        // Buscar o produto completo pelo ID
        Produto produto = produtoRepository.findById(pedido.getProduto().getId())
                                           .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        
        // Setar o produto completo no pedido
        pedido.setProduto(produto);
        
        // Calcular o preco_total
        double valorTotal = calcularValorTotal(pedido);
        pedido.setPreco_total((float) valorTotal);

        return pedido;
    }

    public List<Map<String, Object>> listarPedidos() {
        return pedidoRepository.findAll().stream().map(pedido -> {
            Map<String, Object> response = new HashMap<>();
            response.put("Pedido:", pedido);
            response.put("Valor Total:", calcularValorTotal(pedido));
            return response;
        }).collect(Collectors.toList());
    }
}