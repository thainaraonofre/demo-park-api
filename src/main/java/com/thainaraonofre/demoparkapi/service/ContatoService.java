package com.thainaraonofre.demoparkapi.service;



import com.thainaraonofre.demoparkapi.entity.Contato;
import com.thainaraonofre.demoparkapi.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;


    @Transactional
    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }


    @Transactional(readOnly = true)
    public Contato buscarPorId(Long id) {
        return contatoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Contato não encontrado.")
        );
    }




}
