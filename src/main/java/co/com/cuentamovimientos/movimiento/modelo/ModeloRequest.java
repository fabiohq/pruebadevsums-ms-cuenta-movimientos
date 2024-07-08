package co.com.cuentamovimientos.movimiento.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloRequest {

	private String numeroCuenta;
	private ModeloMovimiento movimiento;
}
