package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.exceptions.usuarioExceptions.UsuarioJaExisteException;
import com.beetech.AgendaContatos.exceptions.usuarioExceptions.UsuarioNaoExistenteException;
import com.beetech.AgendaContatos.model.pessoa.Pessoa;
import com.beetech.AgendaContatos.model.pessoa.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario cadastrarUsuario(DadosCadastroUsuario dados) {
        if (usuarioRepository.existsByLogin(dados.login())) {
            throw new UsuarioJaExisteException("Já existe um usuário com o login " + dados.login());
        }

        var pessoa = pessoaRepository.save(new Pessoa(dados.pessoa()));

        return usuarioRepository.save(new Usuario(dados, pessoa));
    }

    public List<DetalhamentoUsuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAllAtivoByLogin();

        return usuarios.stream().map(DetalhamentoUsuario::new).toList();
    }

    public DetalhamentoUsuario buscarUsuario(Long id) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuário não encontrado"));

        return new DetalhamentoUsuario(user);
    }

    @Transactional
    public DetalhamentoUsuario atualizaUsuario(Long id, DadosAtualizacaoUsuario dados) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuário não encontrado"));

        user.atualizar(dados);
        user.getPessoa().atualizar(dados.pessoa());

        usuarioRepository.save(user);

        return new DetalhamentoUsuario(user);
    }

    @Transactional
    public void excluirUsuario(Long id) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuário não encontrado"));

        user.excluir();
    }

    @Transactional(readOnly = true)
    public Usuario autenticar(@Valid DadosAutenticacaoUsuario dados) {
        Usuario user = usuarioRepository.findByLogin(dados.login())
                .orElseThrow(() -> new RuntimeException("Login ou senha inválidos!"));

        if (user != null && user.getSenha().equals(dados.senha())) {
            return user;
        }

        return null;
    }
}
