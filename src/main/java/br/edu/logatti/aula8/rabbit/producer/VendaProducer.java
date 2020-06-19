package br.edu.logatti.aula8.rabbit.producer;

import br.edu.logatti.aula8.model.vo.VendaVO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VendaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("vendaQueue")
    @Autowired
    private Queue queue;

    public void send(final VendaVO request) {
        rabbitTemplate.convertAndSend(queue.getName(), request);
    }
}