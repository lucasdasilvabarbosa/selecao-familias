package br.selecao.familias.regras.desqualificacao;

import br.selecao.familias.resources.dto.DadosAnalise;
import br.selecao.familias.resources.dto.FamiliaDTO;
import br.selecao.familias.resources.dto.StatusDTO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
Analise de status
  ```json
// Status
[
  { "id": "0", "Cadastro válido" }, // Somente famílias neste status poderão ser selecionadas
  { "id": "1", "Já possui uma casa" },
  { "id": "2", "Selecionada em outro processo de seleção" },
  { "id": "3", "Cadastro incompleto" }
]
```
  Motivos desqualificação
- Família já possui uma casa;
- Família já está concorrendo em outro processo de seleção;
- Família está com o cadastro incompleto.
 */
public class Desqualificacao001Teste {

    Desqualificacao001 desqualificacao001;
    DadosAnalise dadosAnalise;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        desqualificacao001 = new Desqualificacao001();
    }

    @Test
    public void familiaSemImpedimente() {
        dadosAnalise = new DadosAnalise();
        FamiliaDTO familiaDTO = new FamiliaDTO();
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(0);
        familiaDTO.setStatus(statusDTO);
        dadosAnalise.setFamiliaDTO(familiaDTO);
        desqualificacao001.executa(dadosAnalise);
        assertTrue(dadosAnalise.getDesqualificacao() == null);
    }

    @Test
    public void familiaComImpedimente() {
        dadosAnalise = new DadosAnalise();
        FamiliaDTO familiaDTO = new FamiliaDTO();
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(1);
        familiaDTO.setStatus(statusDTO);
        dadosAnalise.setFamiliaDTO(familiaDTO);
        desqualificacao001.executa(dadosAnalise);
        assertTrue(dadosAnalise.getDesqualificacao() != null && dadosAnalise.getDesqualificacao().size() > 0);
    }

    // pode expandir para testes individuais dos status com a mensagem esperada
}
