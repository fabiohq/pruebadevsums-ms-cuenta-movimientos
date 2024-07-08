package co.com.cuentamovimientos.movimiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cuentamovimientos.movimiento.modelo.ModeloRequest;
import co.com.cuentamovimientos.movimiento.modelo.ModeloResponse;
import co.com.cuentamovimientos.movimiento.service.IServiceMovimiento;

@RestController
@RequestMapping("/api/v1/movimientos")
public class ControllerMovimientos {

	@Autowired
	private IServiceMovimiento service;
	
	@PostMapping
	public ModeloResponse crear (@RequestBody ModeloRequest request) {
		return service.crear(request);		
	}
	
	@PutMapping
	public ModeloResponse editar(@RequestBody ModeloRequest request) {
		
		return service.editar(request);
	}
	
	@DeleteMapping("/{id}")
	public ModeloResponse eliminar(@PathVariable long id) {
		return service.eliminar(id);
	}
	
	@GetMapping("/{id}")
	public ModeloResponse obtener(@PathVariable long id) {
		return service.obtener(id);
	}
	
	@GetMapping
	public ModeloResponse listar() {
		return service.listar();
	}
}
