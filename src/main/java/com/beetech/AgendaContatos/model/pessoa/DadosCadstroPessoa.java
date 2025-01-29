package com.beetech.AgendaContatos.model.pessoa;

import com.beetech.AgendaContatos.model.contato.DadosContato;
import com.beetech.AgendaContatos.model.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosCadstroPessoa(
    String nome,
    String sobrenome,
    Date dataNascimento,
    @NotNull(message = "{endereco.obrigatorio}") @Valid
    DadosEndereco endereco,
    @NotNull(message = "{contato.obrigatorio}")
    DadosContato contato
) {
}
