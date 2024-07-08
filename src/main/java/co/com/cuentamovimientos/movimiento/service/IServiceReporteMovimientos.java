package co.com.cuentamovimientos.movimiento.service;

import java.time.LocalDate;
import java.util.List;

import co.com.cuentamovimientos.movimiento.modelo.ReporteMovimientosDTO;

public interface IServiceReporteMovimientos {

	
	public List<ReporteMovimientosDTO> getReporteMovimientosBetweenDates(String identificacion, LocalDate fechaInicio, LocalDate fechaFin);
    
}
