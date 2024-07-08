package co.com.cuentamovimientos.movimiento.service;

import co.com.cuentamovimientos.movimiento.modelo.ModeloRequest;
import co.com.cuentamovimientos.movimiento.modelo.ModeloResponse;

public interface IServiceMovimiento {

	public ModeloResponse crear(ModeloRequest request);
	
	public ModeloResponse editar(ModeloRequest request);

	public ModeloResponse eliminar(long id);

	public ModeloResponse obtener(long id);

	public ModeloResponse listar();
}
