package com.example.educaecoapi.services;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.models.Professor;
import com.example.educaecoapi.repository.AlunoRepository;
import com.example.educaecoapi.repository.ProfessorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Optional<Professor> buscarPorEmail(String email) {
        return Optional.ofNullable(professorRepository.findByEmail(email));
    }

    public Optional<Professor> buscarPorEmailESenha(String email, String senha) {
        return Optional.ofNullable(professorRepository.findByEmailAndSenha(email, senha));
    }
}
