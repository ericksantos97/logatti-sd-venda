package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.entity.Fornecedor;
import br.edu.logatti.aula8.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = Constant.FORNECEDOR_API)
public class FornecedorController {

    private final FornecedorService service;

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody final Fornecedor fornecedor) {
        return ResponseEntity.ok().body(service.save(fornecedor));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Fornecedor> update(@RequestBody final Fornecedor fornecedor) {
        return ResponseEntity.ok().body(service.save(fornecedor));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Fornecedor>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}