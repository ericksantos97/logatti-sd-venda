package br.edu.logatti.aula8.rabbit.consumer;

import br.edu.logatti.aula8.model.vo.CompraVO;
import br.edu.logatti.aula8.service.CompraService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CompraConsumer {

    @Autowired
    private CompraService compraService;

    @RabbitListener(queues = {"${queue.compra.name}"})
    public void receive(@Payload final CompraVO request) {
        compraService.save(request);
    }
}