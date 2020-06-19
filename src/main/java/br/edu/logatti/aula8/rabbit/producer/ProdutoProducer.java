package br.edu.logatti.aula8.rabbit.producer;

import br.edu.logatti.aula8.model.entity.Produto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("produtoQueue")
    @Autowired
    private Queue queue;

    public void send(final Produto produto) {
        rabbitTemplate.convertAndSend(queue.getName(), produto);
    }
}