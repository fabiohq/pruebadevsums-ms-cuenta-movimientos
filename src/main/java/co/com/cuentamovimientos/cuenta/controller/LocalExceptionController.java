package co.com.cuentamovimientos.cuenta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.com.cuentamovimientos.excepciones.LocalException;
import co.com.cuentamovimientos.excepciones.LocalMessage;
import co.com.cuentamovimientos.excepciones.LocalResourceNotFoundException;
import co.com.cuentamovimientos.movimiento.modelo.ModeloResponse;

@ControllerAdvice
public class LocalExceptionController {

	@ExceptionHandler(LocalException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ModeloResponse> LocalException(LocalException exception){
		LocalMessage localMessage=new LocalMessage();
//		localMessage.setCodigoError(exception.getCodigo());
//		localMessage.setMensageError(exception.getMessage());
		
		ModeloResponse response = new ModeloResponse();
		response.setLocalMessage(localMessage);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ExceptionHandler(LocalResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ModeloResponse> LocalResourceNotFoundException(LocalResourceNotFoundException exception){
		LocalMessage localMessage=new LocalMessage();
//		localMessage.setCodigoError(exception.getCodigo());
//		localMessage.setMensageError(exception.getMessage());
		
		ModeloResponse response = new ModeloResponse();
		response.setLocalMessage(localMessage);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
