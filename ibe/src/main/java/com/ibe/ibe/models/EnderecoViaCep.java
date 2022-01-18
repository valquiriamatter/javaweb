package com.ibe.ibe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnderecoViaCep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String logradouro;
    String bairro;
    String localidade;
    String uf;

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }


}