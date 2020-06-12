package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.Cliente;
import br.edu.logatti.aula8.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.CLIENTE_API)
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody final Cliente cliente) {
        return ResponseEntity.ok().body(service.save(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody final Cliente cliente) {
        return ResponseEntity.ok().body(service.save(cliente));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}