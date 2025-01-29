package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.model.pessoa.Pessoa;
import jakarta.persistence.*;

@Entity(name = "Usuario" )
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    private Boolean ativo;

    public Usuario() {}

    public Usuario(DadosCadastroUsuario dados, Pessoa pessoa) {
        this.ativo = true;
        this.login = dados.login();
        this.senha = dados.senha();
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void atualizar(DadosAtualizacaoUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public void excluir() {
        this.ativo = false;
    }
}
