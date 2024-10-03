package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.services.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/selecionar")
    @Operation(summary = "Busca alunos", description = "Retorna uma lista de alunos.")
    public List<Aluno> buscarTodosAlunos() {
        return alunoService.buscarTodosAlunos();
    }

    // Endpoint para buscar aluno por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca alunos por ID", description = "Retorna um aluno que correspondem ao ID informado.")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.buscarPorId(id));
        if (optionalAluno.isPresent()) {
            return ResponseEntity.ok(optionalAluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar todos os alunos de uma determinada turma
    @GetMapping("/turma/{idTurma}")
    @Operation(summary = "Busca alunos por turma", description = "Retorna uma lista de alunos que correspondem a turma informada.")
    public ResponseEntity<List<Aluno>> getAlunosByTurma(@PathVariable Long idTurma) {
        List<Aluno> alunos = alunoService.buscarPorTurma(idTurma);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar alunos por nome
    @GetMapping("/nome/{nome}")
    @Operation(summary = "Busca alunos por nome", description = "Retorna uma lista de alunos que correspondem ao nome informado.")
    public ResponseEntity<List<Aluno>> getAlunosByNome(@PathVariable String nome) {
        List<Aluno> alunos = alunoService.buscarPorNome(nome);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para buscar alunos por email
    @GetMapping("/email/{email}")
    @Operation(summary = "Busca alunos por email", description = "Retorna uma lista de alunos que correspondem ao email informado.")
    public ResponseEntity<List<Aluno>> getAlunosByEmail(@PathVariable String email) {
        Aluno aluno = alunoService.buscarAlunoPorEmail(email);
        if (aluno != null) {
            return ResponseEntity.ok(List.of(aluno));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para trocar a senha do aluno por email
    @PutMapping("/atualizar-senha")
    @Operation(summary = "Atualiza senha do aluno por email", description = "Retorna uma mensagem de sucesso ou falha.")
    public ResponseEntity<String> atualizarSenha(@RequestParam String email, @RequestParam String novaSenha) {
        boolean atualizado = alunoService.atualizarSenhaPorEmail(email, novaSenha);

        if (atualizado) {
            return ResponseEntity.ok("Senha atualizada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

    // Endpoint para atualizar o XP do aluno por email
    @PutMapping("/atualizar-xp")
    @Operation(summary = "Atualiza XP do aluno por email", description = "Retorna uma mensagem de sucesso ou falha.")
    public ResponseEntity<String> atualizarXp(@RequestParam String email, @RequestParam int somaXp) {
        boolean atualizado = alunoService.atualizarXpPorEmail(email, somaXp);

        if (atualizado) {
            return ResponseEntity.ok("XP atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

}

