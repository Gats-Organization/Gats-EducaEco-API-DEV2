package com.example.educaecoapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Endereço", example = "1")
    private Long id;

    @NotNull
    @Min(1)
    @Column(length = 10)
    @Schema(description = "CEP do Endereço", example = "12345678")
    private String numero;

    @NotBlank
    @Size(max = 80)
    @Schema(description = "Rua do Endereço", example = "Avenida Paulista")
    private String rua;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Bairro do Endereço", example = "Centro")
    private String bairro;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Cidade do Endereço", example = "São Paulo")
    private String cidade;

    @NotBlank
    @Size(max = 30)
    @Schema(description = "Estado do Endereço", example = "SP")
    private String estado;  // Corrigido para 30 caracteres, conforme a tabela

    @NotBlank
    @Size(max = 10)
    @Schema(description = "CEP do Endereço", example = "12345678")
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

    public String getNumero() {
        return numero;
    }
}

