package com.thainaraonofre.demoparkapi.service;



import com.thainaraonofre.demoparkapi.entity.Contato;
import com.thainaraonofre.demoparkapi.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;


    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }
}
