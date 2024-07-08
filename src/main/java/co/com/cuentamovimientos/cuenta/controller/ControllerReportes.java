package co.com.cuentamovimientos.cuenta.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.cuentamovimientos.cuenta.service.IServiceReportes;

@RestController
@RequestMapping("/api/v1/reportes")
public class ControllerReportes {

	@Autowired
	private IServiceReportes service;
	
	public ResponseEntity<String> generarReporte(
			@RequestParam(name = "fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,	            
			@RequestParam(name = "fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,	            
			@RequestParam(name = "idCliente") String idCliente) {
		
		String response = service.generarReporte(fechaInicio, fechaFin, idCliente);
		try {
			return ResponseEntity.ok().body(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(response);
		}		
		
		
	}
}
