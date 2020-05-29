package br.selecao.familias.util;

import br.selecao.familias.resources.dto.RendaDTO;

import java.util.List;

public class SomasUtil {

    public static int rendaTotal(List<RendaDTO> redas) {
        if (redas == null) {
            return 0;
        } else {
            int total = 0;
            total += redas.stream().mapToInt(r -> r.getValor()).sum();
            return total;
        }
    }

    public static int somaPontos(int pontos, int valorRegra) {
        return pontos + valorRegra;
    }
}
