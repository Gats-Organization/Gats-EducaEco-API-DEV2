package com.example.educaecoapi.services;

import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.repository.AlunoRepository;
import org.springframework.data.domain.Sort;
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
        return alunoRepository.findByTurma_Id(idTurma, Sort.by(Sort.Order.desc("xp")));
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

    public boolean atualizarSenhaPorEmail(String email, String novaSenha) {
        Optional<Aluno> alunoOptional = Optional.ofNullable(alunoRepository.findByEmail(email));

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setSenha(novaSenha);
            alunoRepository.save(aluno);
            return true;
        }

        return false;
    }

    public boolean atualizarXpPorEmail(String email, int somaXp) {
        Optional<Aluno> alunoOptional = Optional.ofNullable(alunoRepository.findByEmail(email));

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setXp(aluno.getXp() + somaXp);
            alunoRepository.save(aluno);
            return true;
        }

        return false;
    }
}