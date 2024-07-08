package co.com.cuentamovimientos.movimiento.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cuentamovimientos.movimiento.modelo.ReporteMovimientosDTO;
import co.com.cuentamovimientos.movimiento.repository.IRepositoryReporteMovimientos;

@Service
public class ServiceReporteMovimientos implements IServiceReporteMovimientos{

	@Autowired
    private IRepositoryReporteMovimientos reporteMovimientosRepository;
	
	public List<ReporteMovimientosDTO> getReporteMovimientosBetweenDates(String identificacion, LocalDate fechaInicio, LocalDate fechaFin) {
		
		List<Object[]> resultados = reporteMovimientosRepository.findReportesByIdentificacionAndFechas(identificacion, fechaInicio, fechaFin);
        List<ReporteMovimientosDTO> dtos = new ArrayList<>();

        for (Object[] resultado : resultados) {
            ReporteMovimientosDTO dto = new ReporteMovimientosDTO();
            // Convertir Timestamp a LocalDate
            Timestamp fechaTimestamp = (Timestamp) resultado[0];
            LocalDate fechaLocalDate = fechaTimestamp.toLocalDateTime().toLocalDate();

            dto.setFecha(fechaLocalDate);
            dto.setCliente((String) resultado[1]);
            dto.setNumeroCuenta((String) resultado[2]);
            dto.setTipoCuenta((String) resultado[3]);
            dto.setSaldoInicial((BigDecimal) resultado[4]);
            Boolean estado = (Boolean) resultado[5];
            dto.setEstado(estado);
            dto.setTipoMovimiento((String) resultado[6]);
            dto.setSaldoDisponible((BigDecimal) resultado[7]);

            dtos.add(dto);
        }

        return dtos;
    }

}
