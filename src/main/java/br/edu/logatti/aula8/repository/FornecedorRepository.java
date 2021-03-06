package br.edu.logatti.aula8.repository;

import br.edu.logatti.aula8.model.entity.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
}