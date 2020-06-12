package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.Venda;
import br.edu.logatti.aula8.model.request.VendaRequest;
import br.edu.logatti.aula8.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.VENDA_API)
public class VendaController {

    @Autowired
    private VendaService service;

    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody final VendaRequest request) {
        return ResponseEntity.ok().body(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Venda> update(@RequestBody final VendaRequest request) {
        return ResponseEntity.ok().body(service.save(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}