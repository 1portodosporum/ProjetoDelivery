package com.generation.projetoDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.projetoDelivery.model.Produto;
import com.generation.projetoDelivery.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutosSaudaveis() {
        return produtoRepository.findBySaudavelTrue();
    }
}