package com.projeto.igreja.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.igreja.api.model.Igreja;
import com.projeto.igreja.api.service.IgrejaService;

@RestController
@RequestMapping("/igrejas")
public class IgrejaController {
	
	@Autowired
	private IgrejaService igrejaService;
	
	@GetMapping
	public List<Igreja> listar() {
		return igrejaService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Igreja igreja = igrejaService.buscarPorId(id);
		return ResponseEntity.ok(igreja);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Igreja igreja) {
		Igreja igrejaSalva = igrejaService.atualizar(id, igreja);
		return ResponseEntity.ok(igrejaSalva);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Igreja igreja) {
		System.out.println(igreja);
		Igreja igrejaSalva = igrejaService.salvar(igreja);
		return ResponseEntity.status(HttpStatus.CREATED).body(igrejaSalva);
	}
	
}
