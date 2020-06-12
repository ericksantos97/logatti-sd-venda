package br.edu.logatti.aula8.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document
@Getter
@Setter
public class Venda implements Serializable {

    private static final long serialVersionUID = -5656398723290810962L;

    @Id
    private String _id;
    private String descricao;
    private LocalDate data;
    private Produto produto;
    private Cliente cliente;

}