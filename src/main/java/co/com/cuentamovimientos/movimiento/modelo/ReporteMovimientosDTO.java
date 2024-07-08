package co.com.cuentamovimientos.movimiento.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ReporteMovimientosDTO {

	private LocalDate fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private boolean estado;
    private String tipoMovimiento;
    private BigDecimal saldoDisponible;
}
