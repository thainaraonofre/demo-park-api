package com.thainaraonofre.demoparkapi.web.dto.mapper;

import com.thainaraonofre.demoparkapi.entity.Usuario;
import com.thainaraonofre.demoparkapi.web.dto.UsuarioCreateDTO;
import com.thainaraonofre.demoparkapi.web.dto.UsuarioResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class UsuarioMapper {


    public static Usuario toUsuario(UsuarioCreateDTO createDto) {
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioResponseDTO toDto(Usuario usuario) {

        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UsuarioResponseDTO> props = new PropertyMap<Usuario, UsuarioResponseDTO>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);

        return mapper.map(usuario, UsuarioResponseDTO.class);

    }


}



