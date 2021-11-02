package br.com.alura.mvc.mudi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private Boolean enabled; //pra ver se o usuario está ativo

    //classe para atributo
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pedido> listaPedidos;



}
