package br.edu.logatti.aula8.service;

import br.edu.logatti.aula8.exception.ResourceNotFoundException;
import br.edu.logatti.aula8.model.entity.Compra;
import br.edu.logatti.aula8.model.vo.CompraVO;
import br.edu.logatti.aula8.rabbit.producer.CompraProducer;
import br.edu.logatti.aula8.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository repository;
    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;
    private final CompraProducer compraProducer;

    public void sendRabbit(final CompraVO compraRequest) {
        compraProducer.send(compraRequest);
    }


    public Compra save(final CompraVO request) {
        Compra compra = new Compra();
        compra.setId(request.getId());
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