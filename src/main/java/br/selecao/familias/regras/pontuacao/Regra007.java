package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.resources.dto.PessoaDTO;
import br.selecao.familias.util.SomasUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import java.util.List;
import java.util.stream.Collectors;

/*
   - Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam)
    - valendo 3 pontos;
 */
@RequestScoped
public class Regra007 {

    private static int valorRegra = 3;

    public void prepara(@Observes DadosAnalise dadosAnalise) {
        List<PessoaDTO> dependetes = this.filtraDependentesMenores18(dadosAnalise);
        if (dependetes.size() > 0) {
            int retornoRegra = executa(dependetes.size());
            if (retornoRegra > 0) {
                dadosAnalise.setPontos(SomasUtil.somaPontos(dadosAnalise.getPontos(), retornoRegra));
                dadosAnalise.setQuantiadeRegrasAtendidas(dadosAnalise.getQuantiadeRegrasAtendidas() + 1);
            }
        } else {
            System.out.println("nenhum dependete cadastrado");
        }
    }

    public List<PessoaDTO> filtraDependentesMenores18(DadosAnalise dadosAnalise) {
       return dadosAnalise.getFamiliaDTO()
                .getPessoas()
                .stream()
                .filter(p -> p.getTipo().equals("Dependente") && p.getIdade() < 18).collect(Collectors.toList());
    }

    public int executa(int dependetes) {
        if (dependetes >= 3) {
            return valorRegra;
        } else {
            return 0;
        }
    }
}
