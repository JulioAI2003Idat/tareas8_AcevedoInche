package tareas8.idat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tareas8.idat.app.model.Estudiante;
import tareas8.idat.app.service.EstudianteService;


@RestController
@RequestMapping("/estudiante")
public class EstudianteController {


	@Autowired
	private EstudianteService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Estudiante>> listar(){
		List<Estudiante> listaestudiantes = service.listar();
		return new ResponseEntity<List<Estudiante>>(listaestudiantes,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Estudiante estudiante = service.obtener(id);
		if (estudiante!= null) {
			return new ResponseEntity<>(estudiante,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(estudiante,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Estudiante estudiante){
		service.guardar(estudiante);
		return new ResponseEntity<>(estudiante,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Estudiante p,@PathVariable Integer id){
		//producto.setId_producto(id);

		Estudiante estudiante = service.obtener(p.getIdEstudiante());
		if (estudiante!= null) {
			service.actualizar(estudiante);
			return new ResponseEntity<>(estudiante,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(estudiante,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Estudiante estudiante = service.obtener(id);
		if (estudiante!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
