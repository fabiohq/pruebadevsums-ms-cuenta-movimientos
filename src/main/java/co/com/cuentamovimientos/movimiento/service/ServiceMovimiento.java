package co.com.cuentamovimientos.movimiento.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cuentamovimientos.cuenta.entity.EntityCuenta;
import co.com.cuentamovimientos.cuenta.repository.IRepositoryCuenta;
import co.com.cuentamovimientos.movimiento.entity.EntityMovimiento;
import co.com.cuentamovimientos.movimiento.entity.EntityReporteMovimientos;
import co.com.cuentamovimientos.movimiento.modelo.ModeloMovimiento;
import co.com.cuentamovimientos.movimiento.modelo.ModeloRequest;
import co.com.cuentamovimientos.movimiento.modelo.ModeloResponse;
import co.com.cuentamovimientos.movimiento.repository.IRepositoryMovimeinto;
import co.com.cuentamovimientos.movimiento.repository.IRepositoryReporteMovimientos;

@Service
public class ServiceMovimiento implements IServiceMovimiento {

	@Autowired
	IRepositoryMovimeinto repository;
	@Autowired
	IRepositoryCuenta repositoryCuenta;
	@Autowired 
	IRepositoryReporteMovimientos repositoryReporteMovimientos;

	@Override
	public ModeloResponse crear(ModeloRequest request) {

		Optional<EntityCuenta> opcionalCuenta = repositoryCuenta.findByNumerocuenta(request.getNumeroCuenta());

		if (!opcionalCuenta.isPresent()) {
			// Retornar error
		}
		
		EntityCuenta entityCuenta = opcionalCuenta.get();
		
		
		Optional<EntityMovimiento> optionalMovimiento = repository.findLatestMovimientoByCuentaId(entityCuenta.getIdcuenta());

		if (!optionalMovimiento.isPresent()) {
			// Retornar error
		}
		
		EntityMovimiento entityMovimiento = optionalMovimiento.get();
		
		
		BigDecimal nuevoSaldoDisponible = entityMovimiento.getSaldo().add(request.getMovimiento().getValor());
		
		if(nuevoSaldoDisponible.compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("Saldo menor a cero "+nuevoSaldoDisponible);
		}
				
		request.getMovimiento().setSaldo(nuevoSaldoDisponible);
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		request.getMovimiento().setFecha(new Date());
		
		StringBuilder sb = new StringBuilder();
		sb.append(request.getMovimiento().getTipomovimiento());
		sb.append(" de ");
		sb.append(request.getMovimiento().getValor());
		request.getMovimiento().setTipomovimiento(sb.toString());

		EntityMovimiento newEntityMovimiento = convertirModeloAEntity(request.getMovimiento(), entityCuenta);

		newEntityMovimiento = repository.save(newEntityMovimiento);
		
		
		EntityReporteMovimientos entityReporteMovimientos = new EntityReporteMovimientos();
		entityReporteMovimientos.setCuentaIdcuenta(entityCuenta);
		entityReporteMovimientos.setMovimientosIdmovimientos(newEntityMovimiento);
		entityReporteMovimientos.setSaldoinicial(entityMovimiento.getSaldo());
		entityReporteMovimientos.setSaldodisponible(nuevoSaldoDisponible);
		
		repositoryReporteMovimientos.save(entityReporteMovimientos);	
		ModeloMovimiento modelo = convertirEntityAModelo(newEntityMovimiento);

		return setModeloMovimiento(modelo);
	}

	@Override
	public ModeloResponse editar(ModeloRequest request) {

		Optional<EntityCuenta> opcionalCuenta = repositoryCuenta.findById(request.getMovimiento().getIdcuenta());

		if (!opcionalCuenta.isPresent()) {
			// Retornar error
		}
				
		Optional<EntityMovimiento> opcionalMovimiento =  repository.findById(request.getMovimiento().getIdmovimiento());
		
		if (!opcionalMovimiento.isPresent()) {
			// Retornar error
		}

		BigDecimal nuevoSaldo = opcionalMovimiento.get().getSaldo().add(request.getMovimiento().getValor());
		
		request.getMovimiento().setSaldo(nuevoSaldo);

		EntityMovimiento entity = convertirModeloAEntity(request.getMovimiento(), opcionalCuenta.get());

		entity = repository.save(entity);

		ModeloMovimiento modelo = convertirEntityAModelo(entity);

		return setModeloMovimiento(modelo);
	}

	@Override
	public ModeloResponse eliminar(long id) {

		repository.deleteById(id);

		return listar();
	}

	@Override
	public ModeloResponse obtener(long id) {

		Optional<EntityMovimiento> opcional = repository.findById(id);

		ModeloResponse response = new ModeloResponse();

		if (opcional.isPresent()) {

			ModeloMovimiento modelo = convertirEntityAModelo(opcional.get());

			response = setModeloMovimiento(modelo);

		} else {

			// Manejar error

		}

		return response;
	}

	@Override
	public ModeloResponse listar() {

		List<EntityMovimiento> entities = repository.findAll();

		ModeloResponse response = new ModeloResponse();

		response.setMoviemtos(entities.stream().map(e -> convertirEntityAModelo(e)).collect(Collectors.toList()));

		return response;
	}

	private EntityMovimiento convertirModeloAEntity(ModeloMovimiento modelo, EntityCuenta entityCuenta) {

		EntityMovimiento entity = new EntityMovimiento();
//		entity.setIdmovimiento(modelo.getIdmovimiento());
		entity.setFecha(modelo.getFecha());
		entity.setTipomovimiento(modelo.getTipomovimiento());
		entity.setValor(modelo.getValor());
		entity.setSaldo(modelo.getSaldo());
//		entity.setCuentaIdcuenta(entityCuenta);

		return entity;
	}

	private ModeloMovimiento convertirEntityAModelo(EntityMovimiento entity) {

		ModeloMovimiento modelo = new ModeloMovimiento();
		modelo.setIdmovimiento(entity.getIdmovimientos());
		modelo.setFecha(entity.getFecha());
		modelo.setTipomovimiento(entity.getTipomovimiento());
		modelo.setValor(entity.getValor());
		modelo.setSaldo(entity.getSaldo());

		return modelo;
	}

	private ModeloResponse setModeloMovimiento(ModeloMovimiento modelo) {

		List<ModeloMovimiento> modelos = new ArrayList<ModeloMovimiento>();
		modelos.add(modelo);
		ModeloResponse response = new ModeloResponse();
		response.setMoviemtos(modelos);

		return response;
	}
}