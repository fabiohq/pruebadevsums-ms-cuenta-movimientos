package co.com.cuentamovimientos.cuenta.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cuentamovimientos.cuenta.entity.EntityCuenta;
import co.com.cuentamovimientos.cuenta.modelo.ModeloCuenta;
import co.com.cuentamovimientos.cuenta.modelo.ModeloRequest;
import co.com.cuentamovimientos.cuenta.modelo.ModeloResponse;
import co.com.cuentamovimientos.cuenta.repository.IRepositoryCuenta;
import co.com.cuentamovimientos.movimiento.entity.EntityMovimiento;
import co.com.cuentamovimientos.movimiento.entity.EntityReporteMovimientos;
import co.com.cuentamovimientos.movimiento.repository.IRepositoryMovimeinto;
import co.com.cuentamovimientos.movimiento.repository.IRepositoryReporteMovimientos;

@Service
public class ServiceCuenta implements IServiceCuenta {

	@Autowired
	private IRepositoryCuenta repository;

	@Autowired
	IRepositoryMovimeinto repositoryMoviemiento;
	
	@Autowired 
	IRepositoryReporteMovimientos repositoryReporteMovimientos;

	@Override
	public ModeloResponse crear(ModeloRequest request) {

		Random random = new Random();

		BigDecimal saldo = request.getCuenta().getSaldoinicial();
		BigDecimal saldoInicial = new BigDecimal("0.00");

		long numeroCuenta = Math.abs(random.nextLong() % 1_000_000_000_0L);
		BigDecimal nuevoNumeroCuenta = new BigDecimal(numeroCuenta);
		request.getCuenta().setNumerocuenta(String.valueOf(nuevoNumeroCuenta));

		request.getCuenta().setSaldoinicial(saldoInicial);
		request.getCuenta().setSaldoDisponible(saldo);
		EntityCuenta entityCuenta = convertirModeloAEntity(request.getCuenta());

		entityCuenta = repository.save(entityCuenta);

		EntityMovimiento entityMovimiento = new EntityMovimiento();

		Date fechaParseada = null;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			fechaParseada = formatoFecha.parse(formatoFecha.format(new Date()));
		} catch (ParseException e) {
			
		}
		
		entityMovimiento.setFecha(fechaParseada);

		entityMovimiento.setSaldo(saldo);
		entityMovimiento.setValor(saldo);
		entityMovimiento.setTipomovimiento("Deposito de " + saldo);

		repositoryMoviemiento.save(entityMovimiento);

		EntityReporteMovimientos entityReporteMovimientos = new EntityReporteMovimientos();
		entityReporteMovimientos.setCuentaIdcuenta(entityCuenta);
		entityReporteMovimientos.setMovimientosIdmovimientos(entityMovimiento);
		entityReporteMovimientos.setSaldoinicial(saldoInicial);
		entityReporteMovimientos.setSaldodisponible(saldo);
		
		repositoryReporteMovimientos.save(entityReporteMovimientos);
		
		ModeloCuenta modelo = convertirEntityAModelo(entityCuenta);

		return setModeloCuenta(modelo);
	}

	@Override
	public ModeloResponse editar(ModeloRequest request) {

		EntityCuenta entity = convertirModeloAEntity(request.getCuenta());

		entity = repository.save(entity);

		ModeloCuenta modelo = convertirEntityAModelo(entity);

		return setModeloCuenta(modelo);
	}

	@Override
	public ModeloResponse eliminar(long id) {

		repository.deleteById(id);

		return listar();
	}

	@Override
	public ModeloResponse obtener(long id) {

		Optional<EntityCuenta> opcional = repository.findById(id);

		ModeloResponse response = new ModeloResponse();

		if (opcional.isPresent()) {

			ModeloCuenta modelo = convertirEntityAModelo(opcional.get());

			response = setModeloCuenta(modelo);

		} else {

			// Manejar error

		}

		return response;
	}

	@Override
	public ModeloResponse listar() {

		List<EntityCuenta> entities = repository.findAll();

		ModeloResponse response = new ModeloResponse();

		response.setCuentas(entities.stream().map(e -> convertirEntityAModelo(e)).collect(Collectors.toList()));

		return response;
	}

	private EntityCuenta convertirModeloAEntity(ModeloCuenta modelo) {

		EntityCuenta entity = new EntityCuenta();
		entity.setIdcuenta(modelo.getIdcuenta());
		entity.setIdcliente(modelo.getIdcliente());
		entity.setNumerocuenta(modelo.getNumerocuenta());
		entity.setTipocuenta(modelo.getTipocuenta());
		entity.setSaldoinicial(modelo.getSaldoinicial());
		entity.setEstado(modelo.isEstado());
//		entity.setSaldoDisponible(modelo.getSaldoDisponible());

		return entity;
	}

	private ModeloCuenta convertirEntityAModelo(EntityCuenta entity) {

		ModeloCuenta modelo = new ModeloCuenta();
		modelo.setIdcuenta(entity.getIdcuenta());
		modelo.setIdcliente(entity.getIdcliente());
		modelo.setNumerocuenta(entity.getNumerocuenta());
		modelo.setTipocuenta(entity.getTipocuenta());
		modelo.setSaldoinicial(entity.getSaldoinicial());
		modelo.setEstado(entity.getEstado());
//		modelo.setSaldoDisponible(entity.getSaldoDisponible());

		return modelo;
	}

	private ModeloResponse setModeloCuenta(ModeloCuenta modelo) {

		List<ModeloCuenta> modelos = new ArrayList<ModeloCuenta>();
		modelos.add(modelo);
		ModeloResponse response = new ModeloResponse();
		response.setCuentas(modelos);

		return response;
	}
}
