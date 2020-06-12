package br.edu.logatti.aula8.model.request;

import java.io.Serializable;

public class VendaRequest implements Serializable {

    private static final long serialVersionUID = -6228186081463203785L;

    private String _id;
    private String descricao;
    private String produtoId;
    private String clienteId;

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

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}