package com.beetech.AgendaContatos.infra.exceptions.usuarioExceptions;

public class UsuarioJaExisteException extends RuntimeException {
    public UsuarioJaExisteException(String message) { super(message); }
}
