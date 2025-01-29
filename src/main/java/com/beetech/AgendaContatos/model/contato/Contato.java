package com.beetech.AgendaContatos.model.contato;


import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;

@Embeddable
public class Contato {
    private String telefone;
    private String email;
    private String instagram;
    private String facebook;
    private String twitterX;

    public Contato() {}

    public Contato(DadosContato dados) {
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.instagram = dados.instagram();
        this.facebook = dados.facebook();
        this.twitterX = dados.twitterX();
    }

    public Contato(Contato contato) {
        this.telefone = contato.telefone;
        this.email = contato.email;
        this.instagram = contato.instagram;
        this.facebook = contato.facebook;
        this.twitterX = contato.twitterX;
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

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitterX() {
        return twitterX;
    }

    public void setTwitterX(String twitterX) {
        this.twitterX = twitterX;
    }

    public void atualizar(@Valid Contato contatoAtualizado) {
        if (contatoAtualizado.getTelefone() != null) {
            this.telefone = contatoAtualizado.getTelefone();
        }
        if (contatoAtualizado.getEmail() != null) {
            this.email = contatoAtualizado.getEmail();
        }
        if (contatoAtualizado.getInstagram() != null) {
            this.instagram = contatoAtualizado.getInstagram();
        }
        if (contatoAtualizado.getFacebook() != null) {
            this.facebook = contatoAtualizado.getFacebook();
        }
        if (contatoAtualizado.getTwitterX() != null) {
            this.twitterX = contatoAtualizado.getTwitterX();
        }
    }
}
