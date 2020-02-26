package com.projeto.igreja.api.errorHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projeto.igreja.api.exception.EntidadeNaoEncontradaExcpetion;
import com.projeto.igreja.api.exception.RequisicaoComBadRequestException;

@ControllerAdvice
public class ErrorHandlerException extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(EntidadeNaoEncontradaExcpetion.class)
	public ResponseEntity<?> handlerEntidadeNaoEncontrada(EntidadeNaoEncontradaExcpetion ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Problema problema = Problema.builder()
				.dataOcorrido(LocalDateTime.now())
				.status(status.value())
				.tipo("https://igreja.com.br/entidade-não-encontrada")
				.titulo("Pagina-não-encontrada")
				.detalhes("Entidade não encontrada, pode estar nulo o id")
				.build();
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(RequisicaoComBadRequestException.class)
	public ResponseEntity<?> handlerRequisicaoComBadRequest(RequisicaoComBadRequestException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Problema problema = Problema.builder()
				.dataOcorrido(LocalDateTime.now())
				.tipo("https://igreja.com.br/requisicao-mal-feita")
				.titulo("Bad request")
				.detalhes("Requisição feita com atributos invalidos/errados")
				.build();
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (body == null) {
			body = Problema.builder()
					.status(status.value())
					.titulo(status.getReasonPhrase())
					.build();
		} else if (body instanceof String) {
			body = Problema.builder()
					.status(status.value())
					.titulo((String) body)
					.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	

}
