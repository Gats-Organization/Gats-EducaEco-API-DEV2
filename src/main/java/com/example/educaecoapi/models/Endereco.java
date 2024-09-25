package com.example.educaecoapi.models;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String cep;

    @Column(length = 2)
    private String estado;

    @Column(length = 50)
    private String cidade;

    @Column(length = 50)
    private String bairro;

    @Column(length = 10)
    private String numero;

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

    public String getNumero() {
        return numero;
    }
}

