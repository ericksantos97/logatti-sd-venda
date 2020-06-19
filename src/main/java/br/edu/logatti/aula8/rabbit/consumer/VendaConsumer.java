package br.edu.logatti.aula8.rabbit.consumer;

import br.edu.logatti.aula8.model.vo.VendaVO;
import br.edu.logatti.aula8.service.VendaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class VendaConsumer implements Serializable {

    private static final long serialVersionUID = -529821617399440761L;

    @Autowired
    private VendaService vendaService;

    @RabbitListener(queues = {"${queue.venda.name}"})
    public void receive(@Payload final VendaVO request) {
        vendaService.save(request);
    }
}