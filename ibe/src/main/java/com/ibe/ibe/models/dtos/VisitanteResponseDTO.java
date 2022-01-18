package com.ibe.ibe.models.dtos;

import java.time.LocalDate;

public class VisitanteResponseDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    public VisitanteResponseDTO() {
    }

    public VisitanteResponseDTO(Long id, String nome, LocalDate dataNascimento, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
