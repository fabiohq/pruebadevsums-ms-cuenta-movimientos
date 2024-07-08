package co.com.cuentamovimientos.cuenta.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloRequest {

	private ModeloCuenta cuenta;
}
