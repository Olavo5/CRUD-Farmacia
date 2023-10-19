package com.example.farmacia.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table(name = "tb_produto")
@Entity
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(min = 5, max = 100, message = "deve ter no mínimo 5 e no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória")
    @Size(min = 5, max = 200, message = "deve ter no mínimo 5 e no máximo 100 caracteres")
    private String descricao;

    @NotNull(message = "A qauntidade é obrigatória")
    private Integer quantidade;

    @NotNull(message = "O preco do produto é obrigatório")
    private Double preco;

    @NotNull(message = "An expiration date is required!")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate validade;


    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;


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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPrice(Double preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}