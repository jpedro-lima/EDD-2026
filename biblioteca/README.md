### Autor

RA: 1430482523031  
Nome: João Pedro Correia de Lima

### Como executar

- O console está em `Main.java` (classe `BibliotecaDigital` integrando catálogo, acervo e empréstimos).
- Foram criados Testers para cada estrutura (tente usá-los):
  - `TesteListaDupla` — inserção/remoção nas duas pontas, busca por ISBN e listagem nos dois sentidos.
  - `TesteFila` — FIFO, exceção de fila vazia e a **mesma** `Fila<T>` usada com `Usuario`, `String` e `Integer` (prova dos genéricos).
  - `TesteHash` — colisões e encadeamento externo no `exibeMap`, `get`/`containsKey`/`containsValue` e chave repetida (novo valor inserido à frente).
  - `TesteGestor` — empréstimo, geração de fila, devolução com atendimento automático do próximo (FIFO) e fila esvaziando.

### Funções extras

- `estaVazia()` em `ListaDupla` — auxiliar usado nos testes e na integração.
- `exibeValores()` em `NossoHash` — listagem limpa só dos valores (sem as posições vazias), usada pelo `Catalogo.exibirCatalogo()`; complementa o `exibeMap()`, que mostra a estrutura interna (posições e cadeias de colisão).
- `GestorEmprestimos` recebe o `Catalogo` no construtor para resolver _ISBN → Livro_ (necessário porque os métodos do enunciado recebem só o ISBN).
