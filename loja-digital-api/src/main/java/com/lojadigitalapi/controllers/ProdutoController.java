package com.lojadigitalapi.controllers;

import com.lojadigitalapi.models.Produto;
import com.lojadigitalapi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // Substitua pela porta do seu frontend Angular, se diferente
@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> getProdutos() {
        return produtoService.getAll();
    }

    @GetMapping("/produtos/{id}")
    public Optional<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping("/produtos/{id}")
    public Produto saveProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/produtos/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.update(id, produto);
    }

    @DeleteMapping("/produtos/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
    }

}
