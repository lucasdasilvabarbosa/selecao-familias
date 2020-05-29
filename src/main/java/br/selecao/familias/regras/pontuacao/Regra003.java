package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.util.SomasUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

/*
- Renda total da família de 1501 à 2000 reais - valendo 1 ponto;
 */
@RequestScoped
public class Regra003 {

    private static int valorRegra = 1;

    public void prepara(@Observes DadosAnalise dadosAnalise) {
        int retornoRegra = executa(SomasUtil.rendaTotal(dadosAnalise.getFamiliaDTO().getRendas()));
        if (retornoRegra > 0) {
            dadosAnalise.setPontos(SomasUtil.somaPontos(dadosAnalise.getPontos(), retornoRegra));
            dadosAnalise.setQuantiadeRegrasAtendidas(dadosAnalise.getQuantiadeRegrasAtendidas() + 1);
        }
    }

    public int executa(int rendaTotal) {
        if (rendaTotal > 1500 && rendaTotal < 2001) {
            return valorRegra;
        } else {
            return 0;
        }
    }
}
