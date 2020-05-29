package br.selecao.familias.regras.pontuacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
- Pretendente com idade de 30 à 44 anos - valendo 2 pontos;
 */
public class Regra005Test {

    Regra005 regra005;
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
        regra005 = new Regra005();
    }

    //validando retorno para teste positivo da regra
    @Test
    public void maiorQue30() {
        int retorno = regra005.executa(31);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menorQue30() {
        int retorno = regra005.executa(29);
        assertTrue(retorno == retornoNegativo);
    }
}
