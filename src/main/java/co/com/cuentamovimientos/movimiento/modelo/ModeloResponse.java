package co.com.cuentamovimientos.movimiento.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.cuentamovimientos.excepciones.LocalMessage;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloResponse {

	private List<ModeloMovimiento> moviemtos;
	private LocalMessage localMessage;
}
