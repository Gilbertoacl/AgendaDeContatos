package com.beetech.AgendaContatos.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoUsuario(@NotBlank(message = "{login.obrigatorio}")
                         String login,
                                       @NotBlank(message = "{senha.obrigatorio}")
                         String senha) {
}
