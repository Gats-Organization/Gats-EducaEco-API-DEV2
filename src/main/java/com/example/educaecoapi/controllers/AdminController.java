package com.example.educaecoapi.controllers;

import com.example.educaecoapi.models.Admin;
import com.example.educaecoapi.models.Aluno;
import com.example.educaecoapi.models.Turma;
import com.example.educaecoapi.services.AdminService;
import com.example.educaecoapi.services.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // Endpoint para buscar professor por ID
    @GetMapping("/selecionar")
    @Operation(summary = "Busca admins", description = "Retorna uma lista de admins.")
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "Lista de admins retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Aluno.class))),
            @ApiResponse (responseCode = "500", description = "Erro interno no servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
    })
    public List<Admin> buscarTodosAdmins() {
        return adminService.buscarTodosAdmins();
    }
}
