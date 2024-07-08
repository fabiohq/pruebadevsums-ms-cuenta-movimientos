package co.com.cuentamovimientos.cuenta.service;

import java.time.LocalDate;

public interface IServiceReportes {

	public String generarReporte(LocalDate fechaInicio,LocalDate fechaFin,String idCliente);
}
