package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca professor por ID", description = "Retorna um professor que corresponde ao ID informado.")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}/senha/{senha}")
    @Operation(summary = "Busca professor por email e senha", description = "Retorna um professor que corresponde ao email e senha informados.")
    public ResponseEntity<Professor> buscarPorEmailSenha(@PathVariable String email, @PathVariable String senha) {
        return professorService.buscarPorEmailAndSenha(email, senha)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

