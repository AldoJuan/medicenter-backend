package com.lvl.medicenter.service;

import com.lvl.medicenter.domain.Rol;
import com.lvl.medicenter.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    @Transactional
    public Rol saveOrUpdateRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol getByIdRol(Integer id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }

    public List<Rol> findRol() {
        return rolRepository.findAll();
    }

    @Transactional
    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}