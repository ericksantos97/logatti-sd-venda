package br.edu.logatti.aula8.controller;

import br.edu.logatti.aula8.constant.Constant;
import br.edu.logatti.aula8.model.entity.Venda;
import br.edu.logatti.aula8.model.vo.VendaVO;
import br.edu.logatti.aula8.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = Constant.VENDA_API)
public class VendaController {

    private final VendaService service;

    @PostMapping
    public ResponseEntity save(@RequestBody final VendaVO request) {
        service.sendRabbit(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Venda> update(@RequestBody final VendaVO request) {
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