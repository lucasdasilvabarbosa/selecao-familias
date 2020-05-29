package br.selecao.familias.resources.dto;

import br.selecao.familias.resources.dto.FamiliaDTO;

import java.util.ArrayList;
import java.util.List;

public class DadosAnalise {

    private FamiliaDTO familiaDTO;
    private Integer pontos;
    private int quantiadeRegrasAtendidas;
    private List<String> desqualificacao;

    public DadosAnalise() {
    }

    public DadosAnalise(FamiliaDTO familiaDTO) {
        this.familiaDTO = familiaDTO;
        this.pontos = 0;
    }

    public FamiliaDTO getFamiliaDTO() {
        return familiaDTO;
    }

    public void setFamiliaDTO(FamiliaDTO familiaDTO) {
        this.familiaDTO = familiaDTO;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public int getQuantiadeRegrasAtendidas() {
        return quantiadeRegrasAtendidas;
    }

    public void setQuantiadeRegrasAtendidas(int quantiadeRegrasAtendidas) {
        this.quantiadeRegrasAtendidas = quantiadeRegrasAtendidas;
    }

    public List<String> getDesqualificacao() {
        return desqualificacao;
    }

    public void setDesqualificacao(List<String> desqualificacao) {
        this.desqualificacao = desqualificacao;
    }

    public void addDesqualificacao(String motivo) {
        if (this.desqualificacao == null) {
            this.desqualificacao = new ArrayList<>();
        }
        desqualificacao.add(motivo);
    }
}
