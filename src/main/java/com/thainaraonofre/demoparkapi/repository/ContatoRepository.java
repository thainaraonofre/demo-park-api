package com.thainaraonofre.demoparkapi.repository;

import com.thainaraonofre.demoparkapi.entity.Contato;
import com.thainaraonofre.demoparkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
}


