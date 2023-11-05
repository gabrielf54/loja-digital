package com.lojadigitalapi.controllers;

import com.lojadigitalapi.models.Cliente;
import com.lojadigitalapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteService.getAll();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("clientes/{id}")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
