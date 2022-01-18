package com.ibe.ibe.models;

import javax.persistence.*;

@Entity
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    private Boolean iniciante = true;
    private Boolean ativo = true;

    public Visitante() {
    }

    public Visitante(Long id, Pessoa pessoa, Boolean iniciante, Boolean ativo) {
        this.id = id;
        this.pessoa = pessoa;
        this.iniciante = iniciante;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getIniciante() {
        return iniciante;
    }

    public void setIniciante(Boolean iniciante) {
        this.iniciante = iniciante;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
