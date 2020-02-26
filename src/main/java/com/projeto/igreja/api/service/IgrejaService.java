package com.projeto.igreja.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.igreja.api.exception.EntidadeNaoEncontradaExcpetion;
import com.projeto.igreja.api.model.Igreja;
import com.projeto.igreja.api.repository.IgrejaRepository;

@Service
public class IgrejaService {
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	
	
	public List<Igreja> listar() {
		return igrejaRepository.findAll();
	}
	
	public Igreja buscarPorId(Long id) {
		return	igrejaRepository.findById(id).orElseThrow(() -> 
				new EntidadeNaoEncontradaExcpetion("Entidade não encontrada"));
	}
	
	public Igreja atualizar(Long id, Igreja igreja) {
		Igreja igrejaRetornada = buscarPorId(id);
		
		BeanUtils.copyProperties(igreja, igrejaRetornada, "id");
		return igrejaRepository.save(igrejaRetornada);
	}
	
	public Igreja salvar(Igreja igreja) {
		return igrejaRepository.save(igreja);
	}
	

	
}
