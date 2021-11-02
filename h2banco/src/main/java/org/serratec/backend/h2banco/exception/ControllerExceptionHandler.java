package org.serratec.backend.h2banco.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//refazer com calma

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	 
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request){ 
	 
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos inválidos. Confira o preenchimento", LocalDateTime.now());
		//return super.handleExceptionInternal(ex, null, headers, status, request);
		//return ResponseEntity.badRequest().body(new ErroResposta(status.ordinal(), "Existem campos inválidos. Confira o preenchimento", LocalDateTime.now()));
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

}
