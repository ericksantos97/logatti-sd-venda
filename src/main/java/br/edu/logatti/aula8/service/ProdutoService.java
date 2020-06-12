package br.edu.logatti.aula8.service;

import br.edu.logatti.aula8.exception.ResourceNotFoundException;
import br.edu.logatti.aula8.model.Produto;
import br.edu.logatti.aula8.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(final Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Optional<Produto> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Produto.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}