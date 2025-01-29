package com.beetech.AgendaContatos.model.pessoa;

import com.beetech.AgendaContatos.model.contato.Contato;
import com.beetech.AgendaContatos.model.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DadosAtualizacaoPessoa(
        @NotBlank String nome,
        @NotBlank String sobrenome,
        @NotBlank Date dataNascimento,
        @Valid Endereco endereco,
        @Valid Contato contato
) {
}
