package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Escola;
import com.example.educaecoapi.repository.EscolaRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {

    @Autowired
    private EscolaRepository escolaRepository;

    // Endpoint para buscar escola por ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca escola por ID", description = "Retorna uma escola que correspondem ao ID informado.")
    public ResponseEntity<Escola> getEscolaById(@PathVariable Long id) {
        Optional<Escola> escola = escolaRepository.findById(id);
        if (escola.isPresent()) {
            return ResponseEntity.ok(escola.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

