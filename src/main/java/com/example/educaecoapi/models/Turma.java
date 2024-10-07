package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da Turma", example = "1")
    private Long id;

    @Column(nullable = false, length = 1)
    @Schema(description = "Nomenclatura da Turma", example = "A")
    private String nomenclatura;

    @Column(nullable = false)
    @Schema(description = "Serie da Turma", example = "1")
    private String serie;

    @Column(nullable = false)
    @Min(value = 2024, message = "O ano deve ser maior ou igual a 2024")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    @Schema(description = "Ano da Turma", example = "2024")
    private int ano;

    @ManyToOne
    @JoinColumn(name = "id_escola", referencedColumnName = "id")
    @Schema(description = "Escola da Turma", example = "1")
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    @Schema(description = "Professor da Turma", example = "1")
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

