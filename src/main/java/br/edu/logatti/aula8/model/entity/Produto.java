package br.edu.logatti.aula8.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Getter
@Setter
public class Produto implements Serializable {

    private static final long serialVersionUID = -2988156750546242324L;

    @Id
    private String _id;
    private String nome;

}