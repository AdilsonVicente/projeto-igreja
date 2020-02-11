package com.projeto.igreja.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.igreja.api.model.Pastoral;
import com.projeto.igreja.api.repository.PastoralRepository;

@RestController
@RequestMapping("/pastorais")
public class PastoralController {

	@Autowired
	private PastoralRepository pastoralRepository;
	
	@GetMapping
	public List<Pastoral> listar(){
		return pastoralRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pastoral> cadastrar(@RequestBody Pastoral pastoral, HttpServletResponse response) {
		Pastoral pastoralSalva = pastoralRepository.save(pastoral);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(pastoralSalva.getCodigo()).toUri();
		response.setHeader("location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pastoralSalva);
	}
	
	@GetMapping("/{codigo}")
	public Optional<Pastoral> buscarPeloCodigo(@PathVariable Long codigo) {
		return pastoralRepository.findById(codigo);
	}
}
