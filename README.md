# GATS EducaEco API

Esta API é utilizada para gerenciar recursos do App EducaEco e do site do GATS, com funcionalidades específicas para professores e alunos. 

No app:
- **Alunos**: podem visualizar o ranking de sua turma por XP e fazer as atividades atribuidas pelo professor.
- **Professores**: podem criar e atribuir quizzes e atividades práticas para suas turmas, além de acompanhar o desempenho dos alunos com base no XP para identificar quem está mais engajado.

## Tecnologias Utilizadas
- **Java** com Spring Boot
- **Banco de Dados** PostgreSQL

## Requisitos
- **Java** 17+
- **PostgreSQL** 13+
- **Maven** 3.6.3+

## Endpoints

### AdminController

- **`GET /api/admin/selecionar`**  
  Retorna uma lista de admins.  
  **Status**: 200 - Lista retornada com sucesso | 500 - Erro interno.

### AlunoController

- **`GET /api/alunos/selecionar`**  
  Retorna uma lista de todos os alunos.  
  **Status**: 200 - Lista retornada com sucesso | 500 - Erro interno.

- **`GET /api/alunos/{id}`**  
  Retorna um aluno específico com base no ID.  
  **Parâmetros**: `id` (Long) - ID do aluno  
  **Status**: 200 - Aluno encontrado | 404 - Aluno não encontrado

- **`GET /api/alunos/turma/{idTurma}`**  
  Retorna todos os alunos de uma determinada turma.  
  **Parâmetros**: `idTurma` (Long) - ID da turma  
  **Status**: 200 - Lista de alunos retornada | 404 - Turma não encontrada

- **`GET /api/alunos/nome/{nome}`**  
  Retorna uma lista de alunos com o nome especificado.  
  **Parâmetros**: `nome` (String) - Nome do aluno  
  **Status**: 200 - Lista de alunos retornada | 404 - Aluno não encontrado

- **`GET /api/alunos/email/{email}`**  
  Retorna um aluno com o email especificado.  
  **Parâmetros**: `email` (String) - Email do aluno  
  **Status**: 200 - Aluno encontrado | 404 - Aluno não encontrado

- **`PUT /api/alunos/atualizar-senha`**  
  Atualiza a senha do aluno com base no email.  
  **Parâmetros**: `email` (String), `novaSenha` (String)  
  **Status**: 200 - Senha atualizada com sucesso | 404 - Aluno não encontrado

- **`PUT /api/alunos/atualizar-xp`**  
  Atualiza o XP do aluno com base no email.  
  **Parâmetros**: `email` (String), `somaXp` (Integer)  
  **Status**: 200 - XP atualizado com sucesso | 404 - Aluno não encontrado

### ProfessorController

- **`GET /api/professores/{id}`**  
  Retorna um professor com o ID especificado.  
  **Parâmetros**: `id` (Long) - ID do professor  
  **Status**: 200 - Professor encontrado | 404 - Professor não encontrado

- **`GET /api/professores/email/{email}`**  
  Retorna um professor com o email especificado.  
  **Parâmetros**: `email` (String) - Email do professor  
  **Status**: 200 - Professor encontrado | 404 - Professor não encontrado

### TurmaController

- **`GET /api/turmas/professor/{professorId}`**  
  Retorna uma lista de turmas relacionadas a um professor.  
  **Parâmetros**: `professorId` (Long) - ID do professor  
  **Status**: 200 - Lista de turmas retornada | 404 - Turma não encontrada

## Criadores
- **Ryan Lucca Gomes**
- **Samuel Pedroso Xavier**

## Como Contribuir

1. Faça o fork deste repositório.
2. Crie uma nova branch: `git checkout -b feature/nova-feature`.
3. Realize as alterações e faça o commit: `git commit -m 'Adiciona nova feature'`.
4. Envie para o repositório remoto: `git push origin feature/nova-feature`.
5. Abra um Pull Request.

## Licença

Este projeto é licenciado sob os termos da licença MIT. Consulte o arquivo `LICENSE` para mais informações.
