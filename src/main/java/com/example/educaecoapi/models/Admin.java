package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Admin", example = "1")
    private Long id;

    @Column(nullable = false, length = 20)
    @Schema(description = "Nome do Admin", example = "Davison")
    private String nome;

    @Column(nullable = false, length = 50)
    @Schema(description = "Email do Aluno", example = "davison.silva@gats.com")
    private String email;

    @Column(nullable = false, length = 20)
    @Schema(description = "Senha do Aluno", example = "Gats2024@")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
