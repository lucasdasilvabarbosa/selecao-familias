package br.selecao.familias.resources.dto;

import java.util.List;

public class RendaDTO {
    private String idPessoa;
    private int valor;

    public RendaDTO() {
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
