package com.beetech.AgendaContatos.model.pessoa;

import com.beetech.AgendaContatos.model.contato.Contato;
import com.beetech.AgendaContatos.model.endereco.Endereco;
import com.beetech.AgendaContatos.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.Date;

@Table(name="pessoas")
@Entity(name="Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;

    public Pessoa() {}

    public Pessoa(Pessoa pessoa) {
        this.nome = pessoa.nome;
        this.sobrenome = pessoa.sobrenome;
        this.dataNascimento = pessoa.dataNascimento;
        this.endereco = new Endereco(pessoa.endereco);
        this.contato = new Contato(pessoa.contato);
    }

    public Pessoa(DadosCadstroPessoa dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.dataNascimento = dados.dataNascimento();
        this.endereco = new Endereco(dados.endereco());
        this.contato = new Contato(dados.contato());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void atualizar(@Valid DadosAtualizacaoPessoa pessoaAtualizada) {
        if (pessoaAtualizada.nome() != null) {
            this.nome = pessoaAtualizada.nome();
        }
        if (pessoaAtualizada.sobrenome() != null) {
            this.sobrenome = pessoaAtualizada.sobrenome();
        }
        if (pessoaAtualizada.dataNascimento() != null) {
            this.dataNascimento = pessoaAtualizada.dataNascimento();
        }
        if (pessoaAtualizada.endereco() != null) {
            this.endereco.atualizar(pessoaAtualizada.endereco());
        }
        if (pessoaAtualizada.contato() != null) {
            this.contato.atualizar(pessoaAtualizada.contato());
        }
    }
}
