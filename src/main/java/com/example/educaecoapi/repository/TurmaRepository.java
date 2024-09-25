package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
}

