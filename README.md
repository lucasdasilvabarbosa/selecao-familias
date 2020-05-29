## Aplicação case Seleção de Familias

 Aplicação criada com o desafio de oferecer uma alternativa para solução criada atualmente, com objetivo de oferecer um 
 código que ofereça uma facil interpletação e um desempenho satisfatorio.
  
## Desing Patters Observer
  A motivação que me levou a escolher esse patters e que permite separa com facilidade camada de coleta de dados, ou
  construção do dado a ser validado, e de validação dos dados coletados. Permitindo de forma objetiva chamar todos os 
  testes passando apenas o objeto observado.
  
  Outra vantagem é que oferece ao projeto uma forma simples de criar classes com responsabilidades unica, colocando cada
  regra dentro de uma unica classe, facilita a leitura e manutenção do código, tanto nas regras, quanto na 
  adição de novas regras.
   
## Construção

 Optei contrução de uma api REST, pois, domino na criação deste tipo de aplicação, e também por possibilitar implantação
 e interface de comunicação simples de utilizar. A maneira que gosto separar as camadas em pacotes de validação, service,
 model facilita a leitura do código.
 
 
## Considerações Finais

 O case apresentado nao está amarrado necessariamente a linguagem, podendo ser desenvolvido em outras linguagens também.
 Para ganho de desempenho também pode se abortar técnicas de paralelismo na execução das regras, que variando a linguagem
 e domínio do time, pode apresentar ganhos significativos no desempenho do processamento.

