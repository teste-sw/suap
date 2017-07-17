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
      - Requisição HTTP
        - Cabeçalho:
        - Corpo: __indiferente__
      - Resposta HTTP
        - Estado : 401
        - Corpo : ```{"estado": 401, "mensagem": "Necessário fazer autenticação"}```
    - classe inválida : vazio
      - Requisição HTTP
        - Cabeçalho:
        - Corpo: __indiferente__
      - Resposta HTTP
        - Estado : 401
        - Corpo : ```{"estado": 401, "mensagem": "Necessário fazer autenticação"}```
  - matrícula do aluno : Mensagem HTTP
    - Condições : não pode ser vazia
    - classe válida
      - matrícula com estado matricula, trancado
      - Matrícula corresponde ao CPF usado na autenticação
        - Requisição HTTP
          - Cabeçalho:
          - Corpo:
        - Resposta HTTP
          - Estado : 201
          - Corpo : ```{"estado": 201, "mensagem": "Inscrição realizada com sucesso"}```
    - classe inválida
      - Matrícula **NÃO** corresponde ao CPF usado na autenticação
        - Resposta HTTP
          - Estado : 401
          - Corpo : ```{"estado": 401, "mensagem": "Matrícula não pertence ao usuário"}```
      - matrícula com estado evadido, jubilado, outros
        - Resposta HTTP
          - Estado : 401
          - Corpo : ```{"estado": 401, "mensagem": "Matrícula não permite inscrever em disciplina"}```
      - matrícula vazia
        - Resposta HTTP
          - Estado : 401
          - Corpo : ```{"estado": 401, "mensagem": "Matrícula não informada"}```
  - período de referência do aluno : SUAP
    - classes válidas
      - período maior que 1 e menor que máximo do curso
      - período das disciplinas = período do aluno
      - período das disciplinas <= período do aluno + 2
    - classes inválidas
      - período do aluno <= 1 ou > que máximo do curso
      - período das disciplinas > período do aluno + 2
      - período nulo da disciplina
  - IRA : SAUP automaticamente
    - classes válidas
      - IRA > 0
    - classes inválidas
      - IRA <= 0
  - período de referência das disciplinas : SUAP
    - classes válidas
      - período de referência das disciplinas > 0 e <= número de períodos do curso
      - período nulo para disciplinas optativas
    - classes inválidas
      - período de referência das disciplinas <= 0 e > número de períodos do curso
  - lista de disciplinas requeridas para inscrição: HTTP
    - classes válidas: número de disciplina > 0
    - classes inválidas
  - número mínimo e máximo de disciplinas permitidas : SUAP automaticamente
    - classes válidas
      - número de disciplinas >= 3 e <= número de disciplinas do período do aluno + 2
      - ver art. 212, pargráfo único número de disciplinas e carga-horária do aluno cumprida
    - classes inválidas
  - lista de pré-requisitos da lista de disciplinas : SUAP automaticamente
    - classes válidas
      - pré-requisitos atendidos
    - classes inválidas
      - falta cumprir algum pré-requisito
  - lista de co-requisitos da lista de disciplinas : SUAP automaticamente
    - classes válidas
      - pós-requisitos das disciplinas cumpridos
    - classes inválidas
      - algum pós-requisitos das disciplinas não cumpridos


**Condição do aluno para executar os testes válidos**
```json
"Curso": {
  "codigo": "404",
  "periodo_maximo": 6,
  "matriz": []
}

"Disciplinas": [

]

"Campus": {
  "codigo": "01",
  "cursos": ["404"]
}

"Pessoa": {
  "cpf": "51653517182",
  "matriculas": [20172014040001]
}

"Aluno": {
  "matricula": 20172014040001,
  "estado": "Matriculado",
  "periodo": 3,
  "ira": 7
}

"Histórico": [
  {"disciplina": "TEC.0002", "estado": "aprovado"},
  {"disciplina": "TEC.0001", "estado": "aprovado"},
  {"disciplina": "TEC.0006", "estado": "aprovado"},
  {"disciplina": "TEC.0007", "estado": "aprovado"},
  {"disciplina": "TEC.0031", "estado": "aprovado"},
  {"disciplina": "TEC.0008", "estado": "aprovado"},
  {"disciplina": "TEC.0013", "estado": "aprovado"},
  {"disciplina": "TEC.0015", "estado": "aprovado"},
  {"disciplina": "TEC.0017", "estado": "aprovado"},
  {"disciplina": "TEC.0003", "estado": "aprovado"},
  {"disciplina": "TEC.0018", "estado": "aprovado"},
  {"disciplina": "TEC.0014", "estado": "aprovado"},
  {"disciplina": "TEC.0016", "estado": "aprovado"}
]

"Disciplinas_Requisitadas" : [
  {"disciplina": "TEC.0021", "periodo": 3,
    "prerequisitos": ["TEC.0014"],
    "corequisito": []},
  {"disciplina": "TEC.0022", "periodo": 3,
    "prerequisitos": [],
    "corequisito": []},
  {"disciplina": "TEC.0019", "periodo": 3,
    "prerequisitos": ["TEC.0014"],
    "corequisito": []},
  {"disciplina": "TEC.0020", "periodo": 3,
    "prerequisitos": ["TEC.0015"],
    "corequisito": []},
  {"disciplina": "TEC.0035", "periodo": 3,
    "prerequisitos": [],
    "corequisito": []},
  {"disciplina": "TEC.0032", "periodo": 3,
    "prerequisitos": [],
    "corequisito": ["TEC.0021", "TEC.0022", "TEC.0019"]},
  {"disciplina": "TEC.0075", "periodo": null,
    "prerequisitos": ["TEC.0014"],
    "corequisito": []},
  {"disciplina": "TEC.0005", "periodo": 4,
    "prerequisitos": [],
    "corequisito": []},
  {"disciplina": "TEC.0010", "periodo": 5,
    "prerequisitos": [],
    "corequisito": []}
]

```

**Mensagem HTTP váliada**
- Cabeçalho

- Corpo
```json
{
    "aluno": 20172014040001,
    "disciplinas": [
      "TEC.0015", "TEC.0017",
      "TEC.0003", "TEC.0018",
      "TEC.0014", "TEC.0016",
      "TEC.0022",
      "TEC.0005"
    ]
}
```
