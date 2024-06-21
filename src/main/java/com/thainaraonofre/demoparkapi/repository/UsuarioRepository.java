package com.thainaraonofre.demoparkapi.repository;

import com.thainaraonofre.demoparkapi.entity.Usuario;
import com.thainaraonofre.demoparkapi.jwt.JwtUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Optional <Usuario> findByUsername(String username);


    @Query("select u.role from Usuario u where u.username like :username")
    Usuario.Role findRoleByUsername(String username);




}
