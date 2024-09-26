package com.example.educaecoapi.services;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            return optionalAluno.get();
        } else {
            return null;
        }
    }

    public List<Aluno> buscarPorTurma(Long idTurma) {
        return alunoRepository.findByTurma_Id(idTurma);
    }

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeLikeIgnoreCase(nome);
    }

    public  Aluno buscarAlunoPorEmail(String email) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoRepository.findByEmail(email));
        if (optionalAluno.isPresent()) {
            return optionalAluno.get();
        } else {
            return null;
        }
    }
}