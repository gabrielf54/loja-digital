package com.lojadigitalapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "carrinho")
    private List<ItemCarrinho> itensCarrinho;

}