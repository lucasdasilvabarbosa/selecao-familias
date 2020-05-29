package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.resources.dto.PessoaDTO;
import br.selecao.familias.util.SomasUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import java.util.List;
import java.util.stream.Collectors;

/*
   - Pretendente com idade abaixo de 30 anos - valendo 1 ponto;
 */
@RequestScoped
public class Regra006 {

    private static int valorRegra = 1;

    public void prepara(@Observes DadosAnalise dadosAnalise) {
        List<PessoaDTO> pretendente = dadosAnalise.getFamiliaDTO()
                .getPessoas()
                .stream()
                .filter(p -> p.getTipo().equals("Pretendente")).collect(Collectors.toList());
        if (pretendente.size() > 0) {
            int retornoRegra = executa(pretendente.get(0).getIdade());
            if (retornoRegra > 0) {
                dadosAnalise.setPontos(SomasUtil.somaPontos(dadosAnalise.getPontos(), retornoRegra));
                dadosAnalise.setQuantiadeRegrasAtendidas(dadosAnalise.getQuantiadeRegrasAtendidas() + 1);
            }
        } else {
            System.out.println("nenhum pretendente cadastrado");
        }
    }

    public int executa(int idadePretende) {
        if (idadePretende < 30) {
            return valorRegra;
        } else {
            return 0;
        }
    }
}
