package com.beetech.AgendaContatos.model.contato;

import jakarta.validation.constraints.NotBlank;

public record DadosContato(
        @NotBlank String telefone,
        @NotBlank String email,
        String instagram,
        String facebook,
        String twitterX
) {
}
