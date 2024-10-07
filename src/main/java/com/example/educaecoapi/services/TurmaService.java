package com.example.educaecoapi.services;

import com.example.educaecoapi.models.Turma;
import com.example.educaecoapi.repository.ProfessorRepository;
import com.example.educaecoapi.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    public List<Turma> buscarPorIdProfessor(Long professorId) {
        return turmaRepository.findByProfessor_Id(professorId);
    }
}
