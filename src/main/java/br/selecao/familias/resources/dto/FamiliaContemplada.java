package br.selecao.familias.resources.dto;

import java.util.Date;

public class FamiliaContemplada {

    private String idFamilia;
    private int criteriosAtendidos;
    private int pontuacaoTotal;
    private Date dataAnalise;

    public FamiliaContemplada() {
    }

    public FamiliaContemplada(DadosAnalise dadosAnalise) {
        this.idFamilia = dadosAnalise.getFamiliaDTO().getId();
        this.criteriosAtendidos = dadosAnalise.getQuantiadeRegrasAtendidas();
        this.pontuacaoTotal = dadosAnalise.getPontos();
        this.dataAnalise = new Date();
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public int getCriteriosAtendidos() {
        return criteriosAtendidos;
    }

    public void setCriteriosAtendidos(int criteriosAtendidos) {
        this.criteriosAtendidos = criteriosAtendidos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }
}
