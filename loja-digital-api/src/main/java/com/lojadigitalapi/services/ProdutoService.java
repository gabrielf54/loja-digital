package com.lojadigitalapi.services;

import com.lojadigitalapi.models.Produto;
import com.lojadigitalapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Long id ,Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
