package com.beetech.AgendaContatos.model.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;

@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;

    public Endereco() { }

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
    }

    public Endereco(Endereco endereco) {
        this.cep = endereco.cep;
        this.logradouro = endereco.logradouro;
        this.complemento = endereco.complemento;
        this.bairro = endereco.bairro;
        this.cidade = endereco.cidade;
        this.uf = endereco.uf;
        this.numero = endereco.numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void atualizar(@Valid Endereco dadosAtualizados) {
        if (dadosAtualizados.getCep() != null) {
            this.cep = dadosAtualizados.getCep();
        }

        if (dadosAtualizados.getLogradouro() != null) {
            this.logradouro = dadosAtualizados.getLogradouro();
        }

        if (dadosAtualizados.getComplemento() != null) {
            this.complemento = dadosAtualizados.getComplemento();
        }

        if (dadosAtualizados.getBairro() != null) {
            this.bairro = dadosAtualizados.getBairro();
        }

        if (dadosAtualizados.getCidade() != null) {
            this.cidade = dadosAtualizados.getCidade();
        }

        if (dadosAtualizados.getUf() != null) {
            this.uf = dadosAtualizados.getUf();
        }

        if (dadosAtualizados.getNumero() != null) {
            this.numero = dadosAtualizados.getNumero();
        }
    }
}
