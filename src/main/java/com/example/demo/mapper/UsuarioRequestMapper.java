package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.rest.model.UsuarioRequestModel;
import com.example.demo.rest.model.UsuarioResponseModel;

@Component
public class UsuarioRequestMapper {
	
	
	public UsuarioDTO from(UsuarioRequestModel from) {
        return UsuarioDTO.builder()
                      .nome(from.getNome())
                      .email(from.getEmail())
                      .idade(from.getIdade())
                      .build();
    }
	
	public UsuarioResponseModel from(UsuarioDTO from) {
        return UsuarioResponseModel.builder()
        			  .id(from.getId())
                      .nome(from.getNome())
                      .email(from.getEmail())
                      .idade(from.getIdade())
                      .build();
	}

}
