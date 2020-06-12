package br.edu.logatti.aula8.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Getter
@Setter
public class Cliente implements Serializable {

    private static final long serialVersionUID = 5633078074869730452L;

    @Id
    private String _id;
    private String nome;
    private String telefone;
    private String cpf;

}