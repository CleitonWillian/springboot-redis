package com.example.demo.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.mapper.UsuarioEntityMapper;
import com.example.demo.persistence.entity.Usuario;
import com.example.demo.persistence.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper mapper;


    @Cacheable(value = "usuarios", key = "#id")
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        log.info("buscou no banco");
        return mapper.from(usuario);
    }

    @CachePut(value = "usuarios", key = "#result.id")
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.from(usuarioDTO);
        return mapper.from(usuarioRepository.save(usuario));
    }
}
