package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.Produto;
import br.edu.logatti.aula8.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.PRODUTO_API)
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody final Produto produto) {
        return ResponseEntity.ok().body(service.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody final Produto produto) {
        return ResponseEntity.ok().body(service.save(produto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}