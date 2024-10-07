package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.models.Turma;
import com.example.educaecoapi.repository.ProfessorRepository;
import com.example.educaecoapi.services.ProfessorService;
import com.example.educaecoapi.services.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    // Endpoint para buscar professor por ID
    @GetMapping("/professor/{professorId}")
    @Operation(summary = "Busca turma por ID de professor", description = "Retorna uma lista de turmas que correspondem ao ID de professor informado.")
    public List<Turma> buscarTurmaPorId(@PathVariable Long professorId) {
        return turmaService.buscarPorIdProfessor(professorId);
    }

}

