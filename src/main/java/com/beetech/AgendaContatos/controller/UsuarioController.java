package com.beetech.AgendaContatos.controller;


import com.beetech.AgendaContatos.model.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping
    public ResponseEntity<List<DetalhamentoUsuario>> listarUsuarios() {
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoUsuario> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarUsuario(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados,
                                           UriComponentsBuilder uriBuilder) {
        Usuario usuario = userService.cadastrarUsuario(dados);

        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoUsuario(usuario));
    }


    @PutMapping("/{id}")
    public ResponseEntity<DetalhamentoUsuario> atualizarUsuario(@PathVariable Long id,
                                                                @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        return ResponseEntity.ok(userService.atualizaUsuario(id, dados));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        userService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestBody @Valid DadosAutenticacaoUsuario dados) {
        return ResponseEntity.ok(userService.autenticar(dados));
    }
}
