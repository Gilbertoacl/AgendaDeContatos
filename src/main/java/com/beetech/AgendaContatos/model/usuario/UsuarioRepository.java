package com.beetech.AgendaContatos.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByLogin(String login);

    @Query("""
            SELECT u FROM Usuario u
            JOIN FETCH u.pessoa
            WHERE u.ativo = true
            """)
    List<Usuario> findAllAtivoByLogin();

    Optional<Usuario> findByLogin(String login);
}
