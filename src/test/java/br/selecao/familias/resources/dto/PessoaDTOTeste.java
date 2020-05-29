package br.selecao.familias.resources.dto;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

public class PessoaDTOTeste {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testarIdade() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        Calendar onzeAnos = Calendar.getInstance();
        onzeAnos.add(Calendar.YEAR, -11);
        pessoaDTO.setDataDeNascimento(onzeAnos.getTime());
        int idade = pessoaDTO.getIdade();
        assertTrue(idade == 11);
    }

}
