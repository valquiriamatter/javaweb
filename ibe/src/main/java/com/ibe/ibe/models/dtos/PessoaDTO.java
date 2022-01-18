package com.ibe.ibe.models.dtos;

import java.time.LocalDate;

public class PessoaDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private EnderecoDTO enderecoDTO;

//    private String enderecoRua;
//    private String enderecoNumero;
//    private String enderecoBairro;
//    private String enderecoCidade;
//    private String enderecoEstado;

    public PessoaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }

    //    public String getEnderecoRua() {
//        return enderecoRua;
//    }
//
//    public void setEnderecoRua(String enderecoRua) {
//        this.enderecoRua = enderecoRua;
//    }
//
//    public String getEnderecoNumero() {
//        return enderecoNumero;
//    }
//
//    public void setEnderecoNumero(String enderecoNumero) {
//        this.enderecoNumero = enderecoNumero;
//    }
//
//    public String getEnderecoBairro() {
//        return enderecoBairro;
//    }
//
//    public void setEnderecoBairro(String enderecoBairro) {
//        this.enderecoBairro = enderecoBairro;
//    }
//
//    public String getEnderecoCidade() {
//        return enderecoCidade;
//    }
//
//    public void setEnderecoCidade(String enderecoCidade) {
//        this.enderecoCidade = enderecoCidade;
//    }
//
//    public String getEnderecoEstado() {
//        return enderecoEstado;
//    }
//
//    public void setEnderecoEstado(String enderecoEstado) {
//        this.enderecoEstado = enderecoEstado;
//    }
}
