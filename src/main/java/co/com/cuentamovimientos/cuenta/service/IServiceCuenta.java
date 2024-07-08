package co.com.cuentamovimientos.cuenta.service;

import co.com.cuentamovimientos.cuenta.modelo.ModeloRequest;
import co.com.cuentamovimientos.cuenta.modelo.ModeloResponse;

public interface IServiceCuenta {

	public ModeloResponse crear(ModeloRequest request);

	public ModeloResponse editar(ModeloRequest request);

	public ModeloResponse eliminar(long id);

	public ModeloResponse obtener(long id);

	public ModeloResponse listar();
}
