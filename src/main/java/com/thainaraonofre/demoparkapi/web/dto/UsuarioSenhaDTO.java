package com.thainaraonofre.demoparkapi.web.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioSenhaDTO {

    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;

}
