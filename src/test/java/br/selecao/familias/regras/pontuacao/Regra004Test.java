package br.selecao.familias.regras.pontuacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
- Pretendente com idade igual ou acima de 45 anos - valendo 3 pontos;
 */
public class Regra004Test {

    Regra004 regra004;
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
        regra004 = new Regra004();
    }

    //validando retorno para teste positivo da regra
    @Test
    public void maiorQue45() {
        int retorno = regra004.executa(50);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menorQue45() {
        int retorno = regra004.executa(44);
        assertTrue(retorno == retornoNegativo);
    }
}
