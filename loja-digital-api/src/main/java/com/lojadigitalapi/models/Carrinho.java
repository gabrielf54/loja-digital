package com.lojadigitalapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Carrinho {

    @OneToOne
    private Cliente cliente;

    @ManyToMany
    private List<Produto> produtos;

    @ElementCollection
    private List<Produto> quantidadeProdutos;

}