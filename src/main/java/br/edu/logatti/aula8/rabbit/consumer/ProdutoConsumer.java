package br.edu.logatti.aula8.rabbit.consumer;

import br.edu.logatti.aula8.model.entity.Produto;
import br.edu.logatti.aula8.service.ProdutoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    @Autowired
    private ProdutoService produtoService;

    @RabbitListener(queues = {"${queue.produto.name}"})
    public void receive(@Payload final Produto produto) {
        produtoService.save(produto);
    }
}
