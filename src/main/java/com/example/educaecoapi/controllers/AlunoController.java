package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.services.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "500", description = "Erro interno no servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    public List<Aluno> buscarTodosAlunos() {
        return alunoService.buscarTodosAlunos();
    }

    // Endpoint para buscar aluno por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca alunos por ID", description = "Retorna um aluno que correspondem ao ID informado.")
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Aluno encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "id", description = "ID do aluno", required = true, example = "8")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
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
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Turma não encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "idTurma", description = "ID da turma", required = true, example = "3")
    public ResponseEntity<List<Aluno>> buscarAlunosPorTurma(@PathVariable Long idTurma) {
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
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "nome", description = "Nome do aluno", required = true, example = "Davison Silva")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome) {
        List<Aluno> alunos = alunoService.buscarPorNome(nome);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para buscar alunos por email
    @GetMapping("/email/{email}")
    @Operation(summary = "Busca aluno por email", description = "Retorna um aluno que corresponde ao email informado.")
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Aluno encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "email", description = "Email do aluno", required = true, example = "aluno@gats.com")
    public ResponseEntity<Aluno> buscarAlunosPorEmail(@PathVariable String email) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.buscarAlunoPorEmail(email));
        if (optionalAluno.isPresent()) {
            return ResponseEntity.ok(optionalAluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para trocar a senha do aluno por email
    @PutMapping("/atualizar-senha")
    @Operation(summary = "Atualiza senha do aluno por email", description = "Retorna uma mensagem de sucesso ou falha.")
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Senha atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameters({
            @Parameter(name = "email", description = "Email do aluno", required = true, example = "nome_aluno@example.com"),
            @Parameter(name = "novaSenha", description = "Nova senha do aluno", required = true, example = "nova_senha_aluno")
    })
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
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "XP atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameters({
            @Parameter(name = "email", description = "Email do aluno", required = true, example = "nome_aluno@gats.com"),
            @Parameter(name = "somaXp", description = "XP a ser somado ao XP atual", required = true, example = "10")
    })
    public ResponseEntity<String> atualizarXp(@RequestParam String email, @RequestParam int somaXp) {
        boolean atualizado = alunoService.atualizarXpPorEmail(email, somaXp);

        if (atualizado) {
            return ResponseEntity.ok("XP atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

}

