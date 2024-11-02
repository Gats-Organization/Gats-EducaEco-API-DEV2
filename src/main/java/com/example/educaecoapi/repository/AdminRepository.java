package com.example.educaecoapi.repository;

import com.example.educaecoapi.models.Admin;
import com.example.educaecoapi.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAll();
}
