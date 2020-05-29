package br.selecao.familias.regras.pontuacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

//- - Renda total da família de 901 à 1500 reais - valendo 3 pontos;
public class Regra002Test {

    Regra002 regra002;
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
        regra002 = new Regra002();
    }

    //validando retorno para teste positivo da regra
    @Test
    public void maiorQue901() {
        int retorno = regra002.executa(950);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void menorQue901() {
        int retorno = regra002.executa(850);
        assertTrue(retorno == retornoNegativo);
    }

}
