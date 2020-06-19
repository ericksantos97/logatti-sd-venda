package br.edu.logatti.aula8.rabbit.producer;

import br.edu.logatti.aula8.model.entity.Fornecedor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FornecedorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("fornecedorQueue")
    @Autowired
    private Queue queue;

    public void send(final Fornecedor fornecedor) {
        rabbitTemplate.convertAndSend(queue.getName(), fornecedor);
    }
}