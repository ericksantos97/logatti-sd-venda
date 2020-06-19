package br.edu.logatti.aula8.rabbit.producer;

import br.edu.logatti.aula8.model.entity.Cliente;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClienteProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("clienteQueue")
    @Autowired
    private Queue queue;

    public void send(final Cliente cliente) {
        rabbitTemplate.convertAndSend(queue.getName(), cliente);
    }
}