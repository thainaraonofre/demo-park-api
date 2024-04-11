package com.thainaraonofre.demoparkapi.service;


import com.thainaraonofre.demoparkapi.entity.Usuario;
import com.thainaraonofre.demoparkapi.exception.EntityNotFoundException;
import com.thainaraonofre.demoparkapi.exception.PasswordInvalidException;
import com.thainaraonofre.demoparkapi.exception.UsernameUniqueViolationException;
import com.thainaraonofre.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("Username '%s' já cadastrado", usuario.getUsername()));
        }
    }


    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado.", id)));
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("A nova senha não confere com a confirmação de senha.");
        }

        Usuario user = buscarPorId(id);

        if (!user.getPassword().equals(senhaAtual)) {
            throw new PasswordInvalidException("A senha atual não corresponde à senha armazenada.");
        }

        user.setPassword(novaSenha);
        return usuarioRepository.save(user);
    }


    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
