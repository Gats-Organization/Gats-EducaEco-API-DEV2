package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
}

