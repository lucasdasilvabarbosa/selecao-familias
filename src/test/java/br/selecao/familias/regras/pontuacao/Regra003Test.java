package br.selecao.familias.regras.pontuacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
- Renda total da família de 1501 à 2000 reais - valendo 1 ponto;
 */
public class Regra003Test {

    Regra003 regra003;
    int retornoPositivo = 1;
    int retornoNegativo = 0;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        regra003 = new Regra003();
    }

    //validando retorno para teste positivo da regra
    @Test
    public void maiorQue1501() {
        int retorno = regra003.executa(1550);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menorQue901() {
        int retorno = regra003.executa(1500);
        assertTrue(retorno == retornoNegativo);
    }
}
