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
   - Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam)
    - valendo 3 pontos;
 */
public class Regra007Test {

    Regra007 regra007;
    int retornoPositivo = 3;
    int retornoNegativo = 0;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        regra007 = new Regra007();
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
        List<PessoaDTO> dependentes = regra007.filtraDependentesMenores18(dadosAnalise);
        assertTrue(dependentes.size() > 0);
    }

    //validando retorno para teste positivo da regra
    @Test
    public void maisQue3() {
        int retorno = regra007.executa(4);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menosQue3() {
        int retorno = regra007.executa(2);
        assertTrue(retorno == retornoNegativo);
    }
}
