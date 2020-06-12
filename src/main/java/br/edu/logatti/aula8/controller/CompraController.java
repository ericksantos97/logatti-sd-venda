package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.entity.Compra;
import br.edu.logatti.aula8.model.vo.CompraVO;
import br.edu.logatti.aula8.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = Constant.COMPRA_API)
public class CompraController {

    private final CompraService service;

    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody final CompraVO request) {
        return ResponseEntity.ok().body(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Compra>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Compra> update(@RequestBody final CompraVO request) {
        return ResponseEntity.ok().body(service.save(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Compra>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}