package com.projeto.igreja.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.igreja.api.exception.EntidadeNaoEncontradaExcpetion;
import com.projeto.igreja.api.exception.RequisicaoComBadRequestException;
import com.projeto.igreja.api.model.Pastoral;
import com.projeto.igreja.api.repository.IgrejaRepository;
import com.projeto.igreja.api.repository.PastoralRepository;

@Service
public class PastoralService {
	
	
	@Autowired
	private PastoralRepository pastoralRepository;
	
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	
	public Pastoral salvar(Pastoral pastoral) {
		Long idIgreja = pastoral.getIgreja().getId();
		
		igrejaRepository.findById(idIgreja).orElseThrow(() -> new RequisicaoComBadRequestException());
		
		return pastoralRepository.save(pastoral);
	}
	
	public Pastoral editar(Long id, Pastoral pastoral) {
		Long idIgreja = pastoral.getIgreja().getId();
		igrejaRepository.findById(idIgreja).orElseThrow(() -> new RequisicaoComBadRequestException());
		Pastoral pastoralRetornada = buscarPorId(id);
		
		BeanUtils.copyProperties(pastoral, pastoralRetornada, "id");
		return pastoralRepository.save(pastoralRetornada);
	}
	
	public Pastoral buscarPorId(Long id) {
		return pastoralRepository.findById(id).orElseThrow(() ->  new EntidadeNaoEncontradaExcpetion("Entidade não encontrada"));
	}
	
}
