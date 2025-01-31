package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.model.pessoa.DadosAtualizacaoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record DadosAtualizacaoUsuario(
        @NotBlank Long id,
        @NotBlank String login,
        @NotBlank String senha,
        @Valid DadosAtualizacaoPessoa pessoa
) {
}
