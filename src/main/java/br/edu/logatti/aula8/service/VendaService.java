package br.edu.logatti.aula8.service;

import br.edu.logatti.aula8.exception.ResourceNotFoundException;
import br.edu.logatti.aula8.model.Venda;
import br.edu.logatti.aula8.model.request.VendaRequest;
import br.edu.logatti.aula8.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ClienteService clienteService;

    public Venda save(final VendaRequest request) {
        Venda venda = new Venda();
        venda.set_id(request.get_id());
        venda.setDescricao(request.getDescricao());
        venda.setProduto(produtoService.findById(request.getProdutoId()).get());
        venda.setCliente(clienteService.findById(request.getClienteId()).get());
        venda.setData(LocalDate.now());
        return repository.save(venda);
    }

    public List<Venda> findAll() {
        return repository.findAll();
    }

    public Optional<Venda> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Venda.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}