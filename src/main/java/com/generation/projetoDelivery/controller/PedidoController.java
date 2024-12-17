package com.generation.projetoDelivery.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetoDelivery.model.Pedido;
import com.generation.projetoDelivery.repository.PedidoRepository;
import com.generation.projetoDelivery.service.PedidoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Long id){
        return pedidoRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pedido>> getByTitulo(@PathVariable String status) {
        return ResponseEntity.ok(pedidoRepository.findAllByStatusContainingIgnoreCase(status));
    }

    // @GetMapping("/valortotal")
    // public ResponseEntity<List<Map<String, Object>>> getValorTotal(){
    //     return ResponseEntity.ok(pedidoService.listarPedidos());
    // }
    

    @PostMapping
    public ResponseEntity<Pedido> post(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoRepository.save(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> put(@Valid @RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK)
        .body(pedidoRepository.save(pedido));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pedidoRepository.deleteById(id);
    }
}
