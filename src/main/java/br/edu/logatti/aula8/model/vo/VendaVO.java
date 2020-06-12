package br.edu.logatti.aula8.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VendaVO implements Serializable {

    private static final long serialVersionUID = -6228186081463203785L;

    private String _id;
    private String descricao;
    private String produtoId;
    private String clienteId;

}