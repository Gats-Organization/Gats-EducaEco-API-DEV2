package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
    List<Turma> findByProfessor_Id(Long idProfessor);
}

