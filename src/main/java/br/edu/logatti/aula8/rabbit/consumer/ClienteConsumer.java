package br.edu.logatti.aula8.rabbit.consumer;

import br.edu.logatti.aula8.model.entity.Cliente;
import br.edu.logatti.aula8.service.ClienteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

    @Autowired
    private ClienteService clienteService;

    @RabbitListener(queues = {"${queue.cliente.name}"})
    public void receive(@Payload final Cliente cliente) {
        clienteService.save(cliente);
    }
}