package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.model.pessoa.DadosCadstroPessoa;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank(message = "{login.obrigatorio}")
        String login,
        @NotBlank(message = "{senha.obrigatorio}")
        String senha,
        @NotBlank(message = "{pessoa.obrigatorio}")
        DadosCadstroPessoa pessoa
) { }
