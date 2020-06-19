package br.edu.logatti.aula8.rabbit.consumer;

import br.edu.logatti.aula8.model.entity.Fornecedor;
import br.edu.logatti.aula8.service.FornecedorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FornecedorConsumer {

    @Autowired
    private FornecedorService fornecedorService;

    @RabbitListener(queues = {"${queue.fornecedor.name}"})
    public void receive(@Payload final Fornecedor fornecedor) {
        fornecedorService.save(fornecedor);
    }
}