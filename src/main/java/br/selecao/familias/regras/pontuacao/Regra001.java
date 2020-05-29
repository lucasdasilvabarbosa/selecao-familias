package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.util.SomasUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

/*
    Regra001 - Renda total da família até 900 reais - valendo 5 pontos;
 */
@RequestScoped
public class Regra001 {

    private static int valorRegra = 5;

    public void prepara(@Observes DadosAnalise dadosAnalise) {
         int retornoRegra = executa(SomasUtil.rendaTotal(dadosAnalise.getFamiliaDTO().getRendas()));
        if (retornoRegra > 0) {
            dadosAnalise.setPontos(SomasUtil.somaPontos(dadosAnalise.getPontos(), retornoRegra));
            dadosAnalise.setQuantiadeRegrasAtendidas(dadosAnalise.getQuantiadeRegrasAtendidas() + 1);
        }
    }

    public int executa(int rendaTotal) {
        if (rendaTotal <= 900) {
            return valorRegra;
        } else {
            return 0;
        }
    }

}
