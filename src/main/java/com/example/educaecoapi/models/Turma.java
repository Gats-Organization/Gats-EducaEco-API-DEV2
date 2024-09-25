package com.example.educaecoapi.models;

import jakarta.persistence.*;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String nomenclatura;

    @ManyToOne
    @JoinColumn(name = "idescola", referencedColumnName = "id")
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "idprofessor", referencedColumnName = "id")
    private Professor professor;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public Escola getEscola() {
        return escola;
    }

    public Professor getProfessor() {
        return professor;
    }
}

