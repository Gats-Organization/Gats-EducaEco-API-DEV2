package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.models.Turma;
import com.example.educaecoapi.repository.ProfessorRepository;
import com.example.educaecoapi.services.ProfessorService;
import com.example.educaecoapi.services.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    // Endpoint para buscar professor por ID
    @GetMapping("/professor/{professorId}")
    @Operation(summary = "Busca turma por ID de professor", description = "Retorna uma lista de turmas que correspondem ao ID de professor informado.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Turma encontrada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Turma.class))),
            @ApiResponse (responseCode = "404", description = "Turma não encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "professorId", description = "ID do professor", required = true, example = "3")
    public List<Turma> buscarTurmaPorId(@PathVariable Long professorId) {
        return turmaService.buscarPorIdProfessor(professorId);
    }

}

