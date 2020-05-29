package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.util.SomasUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

//- - Renda total da família de 901 à 1500 reais - valendo 3 pontos;
@RequestScoped
public class Regra002 {

    private static int valorRegra = 3;

    public void prepara(@Observes DadosAnalise dadosAnalise) {
        int retornoRegra = executa(SomasUtil.rendaTotal(dadosAnalise.getFamiliaDTO().getRendas()));
        if (retornoRegra > 0) {
            dadosAnalise.setPontos(SomasUtil.somaPontos(dadosAnalise.getPontos(), retornoRegra));
            dadosAnalise.setQuantiadeRegrasAtendidas(dadosAnalise.getQuantiadeRegrasAtendidas() + 1);
        }
    }

    public int executa(int rendaTotal) {
        if (rendaTotal > 900 && rendaTotal < 1501) {
            return valorRegra;
        } else {
            return 0;
        }
    }

}
