package co.com.cuentamovimientos.cuenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cuentamovimientos.cuenta.modelo.ModeloRequest;
import co.com.cuentamovimientos.cuenta.modelo.ModeloResponse;
import co.com.cuentamovimientos.cuenta.service.IServiceCuenta;

@RestController
@RequestMapping("/api/v1/cuentas")
public class ControllerCuenta {

	@Autowired
	private IServiceCuenta service;
	
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
