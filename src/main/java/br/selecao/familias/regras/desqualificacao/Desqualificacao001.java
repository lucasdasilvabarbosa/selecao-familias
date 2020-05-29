package br.selecao.familias.regras.desqualificacao;

import br.selecao.familias.resources.dto.DadosAnalise;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

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
@RequestScoped
public class Desqualificacao001 {

    public void prepara(@Observes DadosAnalise dadosAnalise) {
        executa(dadosAnalise);
    }

    public void executa(DadosAnalise dadosAnalise) {
        switch (dadosAnalise.getFamiliaDTO().getStatus().getId()) {
            case 1:
                dadosAnalise.addDesqualificacao("Família já possui uma casa");
            case 2:
                dadosAnalise.addDesqualificacao("Família já está concorrendo em outro processo de seleção");
            case 3:
                dadosAnalise.addDesqualificacao("amília está com o cadastro incompleto.");
        }
    }
}
