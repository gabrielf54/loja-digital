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

    private String statusDoPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
