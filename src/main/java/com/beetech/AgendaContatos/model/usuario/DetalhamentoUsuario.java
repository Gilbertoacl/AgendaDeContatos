package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.model.contato.Contato;

public record DetalhamentoUsuario( Long id, String login, String nomePessoa, Contato contato ) {
    public DetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getPessoa().getNome(), usuario.getPessoa().getContato());
    }
}
