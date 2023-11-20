package com.example.demo.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UsuarioRequestMapper;
import com.example.demo.rest.model.UsuarioRequestModel;
import com.example.demo.rest.model.UsuarioResponseModel;
import com.example.demo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;
	private final UsuarioRequestMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseModel> findById(@PathVariable Long id) {
		var usuarioResponse = mapper.from(service.findById(id));

		return ResponseEntity.ok(usuarioResponse);
	}

	@PostMapping
	public ResponseEntity<UsuarioResponseModel> create(@RequestBody UsuarioRequestModel requestModel) {
		var usuarioSalvo = service.save(mapper.from(requestModel));
		var usuarioResponse = mapper.from(usuarioSalvo);
		return ResponseEntity.ok(usuarioResponse);
	}
}
