package br.edu.logatti.aula8.rabbit.producer;

import br.edu.logatti.aula8.model.vo.CompraVO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CompraProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("compraQueue")
    @Autowired
    private Queue queue;

    public void send(final CompraVO request) {
        rabbitTemplate.convertAndSend(queue.getName(), request);
    }
}