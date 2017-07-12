# projeto exemplo da disciplina de teste : suap

## Plano de teste

**Template**
- URL
- Variável de entrada
- Condições
- Classe válidas e inválidas
- Resultado esperado

**/api/[matricula_do_aluno]/disciplinas/inscricao**
- Variável de entrada: __nem todas as variáveis irão na mensagem HTTP__
  - token de autenticação : Mensagem HTTP
    - Condições : não pode ser vazia
    - classe válida : ativo
    - classe inválida : valor expirado
      - Resposta HTTP
        - Estado : 401
        - Corpo : ```{"estado": 401, "mensagem": "Necessário fazer autenticação"}```
    - classe inválida : vazio
      - Resposta HTTP
        - Estado : 401
        - Corpo : ```{"estado": 401, "mensagem": "Necessário fazer autenticação"}```
  - matrícula do aluno : Mensagem HTTP
    - Condições : não pode ser vazia
    - classe válida
      - matrícula com estado matricula, trancado
      - Matrícula corresponde ao CPF usado na autenticação
    - classe inválida : matrícula com estado evadido, jubilado, outros
  - período de referência do aluno : Mensagem HTTP
  - IRA : SAUP automaticamente
  - período de referência das disciplinas SUAP automaticamente
  - lista de disciplinas : SUAP automaticamente
  - número mínimo e máximo de disciplinas permitidas : SUAP automaticamente
  - lista de pré-requisitos da lista de disciplinas : SUAP automaticamente
  - lista de co-requisitos da lista de disciplinas : SUAP automaticamente

- Condições
- Classe válidas e inválidas
- Resultado esperado
