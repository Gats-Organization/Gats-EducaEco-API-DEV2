package com.example.educaecoapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    @Column(length = 10)
    private int numero;

    @NotBlank
    @Size(max = 80)
    private String rua;

    @NotBlank
    @Size(max = 50)
    private String bairro;

    @NotBlank
    @Size(max = 50)
    private String cidade;

    @NotBlank
    @Size(max = 30)
    private String estado;  // Corrigido para 30 caracteres, conforme a tabela

    @NotBlank
    @Size(max = 10)
    private String cep;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }
}

