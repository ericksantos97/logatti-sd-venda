package br.edu.logatti.aula8.repository;

import br.edu.logatti.aula8.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
}