package com.example.educaecoapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private String nomenclatura;

    @Column(nullable = false)
    private String serie;

    @Column(nullable = false)
    @Min(value = 2024, message = "O ano deve ser maior ou igual a 2024")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    private int ano;

    @ManyToOne
    @JoinColumn(name = "id_escola", referencedColumnName = "id")
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor professor;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getSerie() {
        return serie;
    }

    public int getAno() {
        return ano;
    }

    public Escola getEscola() {
        return escola;
    }

    public Professor getProfessor() {
        return professor;
    }
}

