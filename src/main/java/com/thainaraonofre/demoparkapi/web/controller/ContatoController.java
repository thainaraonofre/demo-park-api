package com.thainaraonofre.demoparkapi.web.controller;

import com.thainaraonofre.demoparkapi.entity.Contato;
import com.thainaraonofre.demoparkapi.entity.Usuario;
import com.thainaraonofre.demoparkapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("tarefas/contatos")
public class ContatoController {


    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato user = contatoService.salvar(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
