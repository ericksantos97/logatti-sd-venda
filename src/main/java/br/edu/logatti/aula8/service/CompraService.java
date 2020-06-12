package br.edu.logatti.aula8.service;

import br.edu.logatti.aula8.exception.ResourceNotFoundException;
import br.edu.logatti.aula8.model.Compra;
import br.edu.logatti.aula8.model.request.CompraRequest;
import br.edu.logatti.aula8.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private FornecedorService fornecedorService;

    public Compra save(final CompraRequest request) {
        Compra compra = new Compra();
        compra.set_id(request.get_id());
        compra.setDescricao(request.getDescricao());
        compra.setProduto(produtoService.findById(request.getProdutoId()).get());
        compra.setFornecedor(fornecedorService.findById(request.getFornecedorId()).get());
        return repository.save(compra);
    }

    public List<Compra> findAll() {
        return repository.findAll();
    }

    public Optional<Compra> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Compra.class.getSimpleName())));

    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}