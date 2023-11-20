package com.example.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
