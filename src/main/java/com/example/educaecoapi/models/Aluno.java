package com.example.educaecoapi.models;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 20)
    private String sobrenome;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String senha;

    @Column(nullable = false)
    private Integer xp;

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
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
}

