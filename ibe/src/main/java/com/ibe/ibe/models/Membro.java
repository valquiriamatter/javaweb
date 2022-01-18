package com.ibe.ibe.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    private String foto;
    private String rg;
    private String cpf;
    private String profissao;

    @OneToOne
    private Pessoa pai;
    @OneToOne
    private Pessoa mae;
    @OneToOne
    private Pessoa conjuge;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "membro_filhos", joinColumns = {
//            @JoinColumn(name = "membro_id")},
//            inverseJoinColumns = {@JoinColumn (name = "filho_id")})


    @ManyToMany
    @JoinTable(name="mebros_has_filhos", joinColumns=
            {@JoinColumn(name="membros_id")}, inverseJoinColumns=
            {@JoinColumn(name="filhos_id")})
    private List<Filho> filhos;

    private LocalDate dataBatismo;
    private String localBatismo;

    @Enumerated(EnumType.STRING)
    private TipoAceite estaIBEpor;

    private Boolean ativo = true;
    private String observacao;

    public Membro() {
    }

    public Membro(Pessoa pessoa, String foto, String rg, String cpf, String profissao, Pessoa pai, Pessoa mae, Pessoa conjuge, List<Pessoa> filhos, LocalDate dataBatismo, String localBatismo, TipoAceite estaIBEpor, Boolean ativo, String observacao) {
        this.pessoa = pessoa;
        this.foto = foto;
        this.rg = rg;
        this.cpf = cpf;
        this.profissao = profissao;
        this.pai = pai;
        this.mae = mae;
        this.conjuge = conjuge;
        this.filhos = new ArrayList<>();
        this.dataBatismo = dataBatismo;
        this.localBatismo = localBatismo;
        this.estaIBEpor = estaIBEpor;
        this.ativo = ativo;
        this.observacao = observacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public Pessoa getConjuge() {
        return conjuge;
    }

    public void setConjuge(Pessoa conjuge) {
        this.conjuge = conjuge;
    }

    public List<Filho> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Filho> filhos) {
        this.filhos = filhos;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getLocalBatismo() {
        return localBatismo;
    }

    public void setLocalBatismo(String localBatismo) {
        this.localBatismo = localBatismo;
    }

    public TipoAceite getEstaIBEpor() {
        return estaIBEpor;
    }

    public void setEstaIBEpor(TipoAceite estaIBEpor) {
        this.estaIBEpor = estaIBEpor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
