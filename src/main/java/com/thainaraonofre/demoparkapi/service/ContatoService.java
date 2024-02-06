package com.thainaraonofre.demoparkapi.service;


import com.thainaraonofre.demoparkapi.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepositoryRepository;
}
