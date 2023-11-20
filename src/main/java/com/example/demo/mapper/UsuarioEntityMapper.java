package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.persistence.entity.Usuario;

@Component
public class UsuarioEntityMapper {

	public Usuario from(UsuarioDTO from) {
        return Usuario.builder()
                      .nome(from.getNome())
                      .email(from.getEmail())
                      .idade(from.getIdade())
                      .build();
    }
	
	public UsuarioDTO from(Usuario from) {
        return UsuarioDTO.builder()
        		.id(from.getId())
                      .nome(from.getNome())
                      .email(from.getEmail())
                      .idade(from.getIdade())
                      .build();
    }
}
