package co.com.cuentamovimientos.movimiento.modelo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloMovimiento {

	private Long idmovimiento;
	private Long idcuenta;
    private Date fecha;
    private String tipomovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
}
