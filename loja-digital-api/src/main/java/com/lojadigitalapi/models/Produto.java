package com.lojadigitalapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @Column(nullable = false)
    private Integer quantidadeEmEstoque;
    @ManyToOne
    private Carrinho carrinho;
}