package com.ibe.ibe.models;

import java.time.LocalDate;
import java.util.List;

public class Membro {

    private Pessoa pessoa;
    private String foto;
    private String rg;
    private String cpf;
    private String profissao;
    private Pessoa pai;
    private Pessoa mae;
    private Pessoa conjuge;
    private List<Pessoa> filhos;
    private LocalDate dataBatismo;
    private String localBatismo;
    private TipoAceite estaIBEpor;
    private String observacao;

    private boolean ativo;


}
