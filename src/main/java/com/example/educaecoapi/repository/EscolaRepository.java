package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
}

