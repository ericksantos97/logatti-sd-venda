package br.edu.logatti.aula8.service;

import br.edu.logatti.aula8.exception.ResourceNotFoundException;
import br.edu.logatti.aula8.model.Fornecedor;
import br.edu.logatti.aula8.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor save(final Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Optional<Fornecedor> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Fornecedor.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}