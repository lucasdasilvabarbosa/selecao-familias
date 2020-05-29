package br.selecao.familias.regras.pontuacao;

import org.junit.*;
import static org.junit.Assert.*;

/*
    Regra001Test - Renda total da família até 900 reais - valendo 5 pontos;
 */
public class Regra001Test {

    Regra001 regra001;
    int retornoPositivo = 5;
    int retornoNegativo = 0;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        regra001 = new Regra001();
    }

    @After
    public void tearDown() {
    }

    //validando retorno para teste positivo da regra
    @Test
    public void testeAte900() {
        int retorno = regra001.executa(850);
        assertTrue(retorno == retornoPositivo);
    }

    //validando para teste negativo da regra
    @Test
    public void testeMaior900() {
        int retorno = regra001.executa(950);
        assertTrue(retorno == retornoNegativo);
    }


}
