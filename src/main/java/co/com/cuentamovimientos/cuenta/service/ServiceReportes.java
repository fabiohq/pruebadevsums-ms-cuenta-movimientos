package co.com.cuentamovimientos.cuenta.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ServiceReportes implements IServiceReportes{

	@Override
	public String generarReporte(LocalDate fechaInicio, LocalDate fechaFin, String idCliente) {
		
		if (fechaInicio.isAfter(fechaFin)) {
			throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
		}
		
		
		return null;
	}

}
