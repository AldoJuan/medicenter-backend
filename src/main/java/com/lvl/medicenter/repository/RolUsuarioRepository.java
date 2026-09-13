package com.lvl.medicenter.repository;

import com.lvl.medicenter.domain.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, RolUsuario.RolUsuarioId> {
}