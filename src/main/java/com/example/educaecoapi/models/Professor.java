package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Professor", example = "1")
    private Long id;

    @Column(nullable = false, length = 20)
    @Schema(description = "Nome do Professor", example = "Marina")
    private String nome;

    @Column(nullable = false, length = 20)
    @Schema(description = "Sobrenome do Professor", example = "Nakashi")
    private String sobrenome;

    @Column(nullable = false, length = 50)
    @Schema(description = "Email do Professor", example = "marina.nakashi@gats.com")
    private String email;

    @Column(nullable = false, length = 20)
    @Schema(description = "Senha do Professor", example = "Gats2024@prof")
    private String senha;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

