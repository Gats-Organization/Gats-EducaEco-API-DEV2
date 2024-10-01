package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Aluno;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAll();
    // Métodos customizados podem ser adicionados aqui se necessário
    List<Aluno> findByTurma_Id(Long idTurma, Sort sort);
    List<Aluno> findByNomeLikeIgnoreCase(String nome);
    Aluno findByEmail(String email);
}

