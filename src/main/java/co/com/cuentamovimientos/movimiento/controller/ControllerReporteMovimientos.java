package co.com.cuentamovimientos.movimiento.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.cuentamovimientos.movimiento.modelo.ReporteMovimientosDTO;
import co.com.cuentamovimientos.movimiento.service.IServiceReporteMovimientos;

@RestController
public class ControllerReporteMovimientos {

	@Autowired
	private IServiceReporteMovimientos reporteMovimientos;

	@GetMapping("/reportes")
    public List<ReporteMovimientosDTO> getReporteMovimientos(@RequestParam("fechaInicio") String fechaInicio, 
                                                             @RequestParam("fechaFin") String fechaFin,
                                                             @RequestParam("cliente") String identificacion) {
        LocalDate startDate = LocalDate.parse(fechaInicio);
        LocalDate endDate = LocalDate.parse(fechaFin);
        return reporteMovimientos.getReporteMovimientosBetweenDates(identificacion, startDate, endDate);
    
	}
}
