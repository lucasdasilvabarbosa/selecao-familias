package br.selecao.familias.service;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.resources.dto.FamiliaContemplada;
import br.selecao.familias.resources.dto.FamiliaDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@LocalBean
@Stateless
public class FamiliaService {

    @Inject
    @Any
    Event<DadosAnalise> regraPontuacao;

    public List<FamiliaContemplada> aplicarPontuacao(List<FamiliaDTO> familias) {
        List<DadosAnalise> dadosAnalises = new ArrayList<>();
        familias.stream().forEach(f -> {
            DadosAnalise dadosAnalise = new DadosAnalise(f);
            regraPontuacao.fire(dadosAnalise);
            dadosAnalises.add(dadosAnalise);
        });

        List<DadosAnalise> analises = dadosAnalises
                                                       .stream()
                                                       .filter(d -> d.getDesqualificacao() == null || d.getDesqualificacao().isEmpty())
                                                       .collect(Collectors.toList());

        List<FamiliaContemplada> contempladas = new ArrayList<>();
        analises.stream()
                .sorted((a1, a2) -> a2.getPontos().compareTo(a1.getPontos()))
                .forEach((a) -> {
                    contempladas.add(new FamiliaContemplada(a));
                });
        return contempladas;
    }
}
