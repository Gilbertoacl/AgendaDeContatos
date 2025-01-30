package com.beetech.AgendaContatos.infra.exceptions.handles;

import com.beetech.AgendaContatos.infra.exceptions.usuarioExceptions.UsuarioJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Excessão para usuário ja cadastrado
    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<String> handleUsuarioJaExisteException(UsuarioJaExisteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //Excessão geral
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
    }
}
