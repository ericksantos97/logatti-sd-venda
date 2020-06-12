package br.edu.logatti.aula8.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Getter
@Setter
public class Compra implements Serializable {

    private static final long serialVersionUID = 8175078993704463794L;

    @Id
    private String _id;
    private String descricao;
    private Produto produto;
    private Fornecedor fornecedor;

}