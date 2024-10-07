package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da Escola", example = "1")
    private Long id;

    @Column(nullable = false, length = 20)
    @Schema(description = "Nome da Escola", example = "Germinare")
    private String nome;

    @Column(nullable = false, length = 50)
    @Schema(description = "Email da Escola", example = "germinare@gats.com")
    private String email;

    @Column(nullable = false, length = 15)
    @Schema(description = "Telefone da Escola", example = "(11) 1234-5678")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    @Schema(description = "Endereço da Escola", example = "1")
    private Endereco endereco;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}

