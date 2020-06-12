package br.edu.logatti.aula8.model.request;

import java.io.Serializable;

public class CompraRequest implements Serializable {

    private static final long serialVersionUID = -8269687861669915577L;

    private String _id;
    private String descricao;
    private String produtoId;
    private String fornecedorId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
}