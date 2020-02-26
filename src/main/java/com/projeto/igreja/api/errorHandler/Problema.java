package com.projeto.igreja.api.errorHandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problema {
	
	private LocalDateTime dataOcorrido;
	private Integer status;
	private String tipo;
	private String titulo;
	private String detalhes;
	
	
	
}
