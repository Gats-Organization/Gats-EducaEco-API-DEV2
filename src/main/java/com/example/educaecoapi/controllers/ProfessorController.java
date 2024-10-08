package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca professor por ID", description = "Retorna um professor que corresponde ao ID informado.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Professor encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Professor.class))),
            @ApiResponse (responseCode = "404", description = "Professor não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "id", description = "ID do professor", required = true, example = "8")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Busca professor por email e senha", description = "Retorna um professor que corresponde ao email e senha informados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Professor encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Professor.class))),
            @ApiResponse (responseCode = "404", description = "Professor não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    @Parameter(name = "email", description = "Email do professor", required = true, example = "nome_professor@gats.com")
    public ResponseEntity<Professor> buscarPorEmail(@PathVariable String email) {
        return professorService.buscarPorEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

