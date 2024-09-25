package com.example.educaecoapi.models;

import jakarta.persistence.*;

@Entity
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "idendereco", referencedColumnName = "id")
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

