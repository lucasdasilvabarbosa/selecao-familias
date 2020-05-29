package br.selecao.familias.regras.pontuacao;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
   - Pretendente com idade abaixo de 30 anos - valendo 1 ponto;
 */
public class Regra006Test {

    Regra006 regra006;
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
        regra006 = new Regra006();
    }

    //validando retorno para teste positivo da regra
    @Test
    public void menorQue30() {
        int retorno = regra006.executa(25);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void maiorQue30() {
        int retorno = regra006.executa(35);
        assertTrue(retorno == retornoNegativo);
    }
}
