package com.example.educaecoapi.services;

import com.example.educaecoapi.models.Admin;
import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.repository.AdminRepository;
import com.example.educaecoapi.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> buscarTodosAdmins() {
        return adminRepository.findAll();
    }

}
