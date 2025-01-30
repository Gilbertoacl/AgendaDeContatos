package com.beetech.AgendaContatos.infra.exceptions.usuarioExceptions;

public class UsuarioNaoExistenteException extends RuntimeException{
    public UsuarioNaoExistenteException(String message) { super(message); }
}
