package co.com.cuentamovimientos.cuenta.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloResponse {

	private List<ModeloCuenta> cuentas;
}
