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

    @ManyToMany
    private List<Produto> produtos;

    @ElementCollection
    private List<Produto> quantidadeProdutos;

    private String statusDoPedido;

}
