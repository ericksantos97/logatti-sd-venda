package br.edu.logatti.aula8.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompraVO implements Serializable {

    private static final long serialVersionUID = -8269687861669915577L;

    private String _id;
    private String descricao;
    private String produtoId;
    private String fornecedorId;

}