package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Usuario;
import com.lvl.medicenter.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Usuario saveOrUpdateUsuario(Usuario usuario) {
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setEstado("A");
        return usuarioRepository.save(usuario);
    }

    public Usuario getByIdUsuario(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public List<Usuario> findUsuario() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}