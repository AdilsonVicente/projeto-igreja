package com.projeto.igreja.api.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	
	private String cep;
	private String cidade;
	private String logradouro;
	private String bairro;
	private String estado;
	
	
}
