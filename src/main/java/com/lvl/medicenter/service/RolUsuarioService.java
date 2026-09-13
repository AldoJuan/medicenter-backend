package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.RolUsuario;
import com.lvl.medicenter.repository.RolUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolUsuarioService {

    private final RolUsuarioRepository rolUsuarioRepository;

    @Transactional
    public RolUsuario saveOrUpdateRolUsuario(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }

    public RolUsuario getByIdRolUsuario(RolUsuario.RolUsuarioId id) {
        return rolUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación de rol no encontrada"));
    }

    public List<RolUsuario> findRolUsuario() {
        return rolUsuarioRepository.findAll();
    }

    @Transactional
    public void deleteRolUsuario(RolUsuario.RolUsuarioId id) {
        rolUsuarioRepository.deleteById(id);
    }
}