package co.com.cuentamovimientos.cuenta.modelo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloCuenta {

	private Long idcuenta;
    private Long idcliente;
    private String numerocuenta;
    private String tipocuenta;
    private BigDecimal saldoinicial;
    private BigDecimal saldoDisponible;
    private boolean estado;
}
