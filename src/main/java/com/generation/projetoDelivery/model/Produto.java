package com.generation.projetoDelivery.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size (min = 3, max = 60, message = "Esse campo deve conter o minimo de 3 e máxima 60 caracteres")
	private String nome;
	
	@Size (min = 3, max = 100, message = "Esse campo deve conter o minimo de 3 e máxima 60 caracteres")
	private String descricao;
	
	@NotNull
	private float preco;
	
	private boolean saudavel;
	
	@NotNull
	@Size (min = 3, max = 80, message = "Esse campo deve conter o minimo de 3 e máxima 60 caracteres")
	private String categoria;
	
	@OneToMany
	@JsonIgnoreProperties("produto")
	private List<Pedido> pedido;
	
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isSaudavel() {
		return saudavel;
	}

	public void setSaudavel(boolean saudavel) {
		this.saudavel = saudavel;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
	
}
