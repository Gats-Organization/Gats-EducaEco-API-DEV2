package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.repository.ProfessorRepository;
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
    private ProfessorRepository professorRepository;

    // Endpoint para buscar professor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return ResponseEntity.ok(professor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

