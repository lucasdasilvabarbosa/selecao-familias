package br.selecao.familias.resources.dto;

import java.util.List;

public class FamiliaDTO {
    private String id;
    private List<PessoaDTO> pessoas;
    private List<RendaDTO> rendas;
    private StatusDTO status;

    public FamiliaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public List<RendaDTO> getRendas() {
        return rendas;
    }

    public void setRendas(List<RendaDTO> rendas) {
        this.rendas = rendas;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}
