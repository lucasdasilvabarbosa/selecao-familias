package br.selecao.familias.regras.pontuacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.resources.dto.FamiliaDTO;
import br.selecao.familias.resources.dto.PessoaDTO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/*
- Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos.
 */
public class Regra008Test {

    Regra008 regra008;
    int retornoPositivo = 2;
    int retornoNegativo = 0;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        regra008 = new Regra008();
    }

    @Test
    public void testarFiltroDepentende() {
        PessoaDTO depenteMenor = new PessoaDTO();
        depenteMenor.setTipo("Dependente");
        SimpleDateFormat nascimento = new SimpleDateFormat("dd/MM/yyyy");
        try {
            depenteMenor.setDataDeNascimento(nascimento.parse("28/12/2010"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DadosAnalise dadosAnalise = new DadosAnalise();
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setPessoas(new ArrayList<>());
        familiaDTO.getPessoas().add(depenteMenor);
        dadosAnalise.setFamiliaDTO(familiaDTO);
        List<PessoaDTO> dependentes = regra008.filtraDependentesMenores18(dadosAnalise);
        assertTrue(dependentes.size() > 0);
    }

    //validando retorno para teste positivo da regra
    @Test
    public void menosQue3() {
        int retorno = regra008.executa(2);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menosQue1() {
        int retorno = regra008.executa(0);
        assertTrue(retorno == retornoNegativo);
    }
}
