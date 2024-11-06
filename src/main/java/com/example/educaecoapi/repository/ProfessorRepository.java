package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
    Professor findByEmail(String email);
    Professor findByEmailAndSenha(String email, String senha);
}

