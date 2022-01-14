package com.ibe.ibe.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Visitante {

    @Embedded
    private Pessoa pessoa;

    private Boolean iniciante = true;
    private Boolean ativo = true;

    public Visitante() {
    }

    public Visitante(Pessoa pessoa, Boolean iniciante, Boolean ativo) {
        this.pessoa = pessoa;
        this.iniciante = iniciante;
        this.ativo = ativo;
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
