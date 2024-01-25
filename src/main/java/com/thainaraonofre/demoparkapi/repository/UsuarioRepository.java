package com.thainaraonofre.demoparkapi.repository;

import com.thainaraonofre.demoparkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
}
