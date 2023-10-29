package com.lojadigitalapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Carrinho carrinho;

    @ManyToMany
    private List<Produto> produtos;

    private String statusDoPedido;

    @ManyToOne
    private Cliente cliente;
}
