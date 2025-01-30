package com.beetech.AgendaContatos.model.usuario;

import com.beetech.AgendaContatos.infra.exceptions.usuarioExceptions.UsuarioJaExisteException;
import com.beetech.AgendaContatos.infra.exceptions.usuarioExceptions.UsuarioNaoExistenteException;
import com.beetech.AgendaContatos.infra.security.TokenService;
import com.beetech.AgendaContatos.model.pessoa.Pessoa;
import com.beetech.AgendaContatos.model.pessoa.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @Autowired
    public UsuarioService(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository,
                          @Lazy AuthenticationManager authManager, TokenService tokenService) {
        this.pessoaRepository = pessoaRepository;
        this.usuarioRepository = usuarioRepository;
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    public DetalhamentoUsuario buscarUsuarioPorId(Long id) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExistenteException("Usuário não encontrado"));

        return new DetalhamentoUsuario(user);
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Login ou senha inválidos!"));
    }

    @Transactional
    public Usuario cadastrarUsuario(DadosCadastroUsuario dados) {
        if (usuarioRepository.existsByLogin(dados.login())) {
            throw new UsuarioJaExisteException("Já existe um usuário com o login " + dados.login());
        }

        return usuarioRepository.save(
                new Usuario(dados.login(),
                new BCryptPasswordEncoder().encode(dados.senha()),
                pessoaRepository.save(new Pessoa(dados.pessoa()))));
    }

    public List<DetalhamentoUsuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAllAtivoByLogin();

        return usuarios.stream().map(DetalhamentoUsuario::new).toList();
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
    public String autenticar(@Valid DadosAutenticacaoUsuario dados) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        Authentication authentication = authManager.authenticate(authenticationToken);

        return tokenService.gerarToken((Usuario) authentication.getPrincipal());
    }
}
