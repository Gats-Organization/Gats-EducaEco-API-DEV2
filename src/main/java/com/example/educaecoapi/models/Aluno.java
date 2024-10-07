package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Aluno", example = "1")
    private Long id;

    @Column(nullable = false, length = 20)
    @Schema(description = "Nome do Aluno", example = "Davison")
    private String nome;

    @Column(nullable = false, length = 20)
    @Schema(description = "Sobrenome do Aluno", example = "Silva")
    private String sobrenome;

    @Column(nullable = false, length = 50)
    @Schema(description = "Email do Aluno", example = "davison.silva@gats.com")
    private String email;

    @Column(nullable = false, length = 20)
    @Schema(description = "Senha do Aluno", example = "Gats2024@")
    private String senha;

    @Column(nullable = false)
    @Schema(description = "XP do Aluno", example = "3000")
    private Integer xp;

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    @Schema(description = "Turma do Aluno", example = "8")
    private Turma turma;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getXp() {
        return xp;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }
}

