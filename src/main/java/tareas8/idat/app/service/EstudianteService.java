package tareas8.idat.app.service;

import java.util.List;

import tareas8.idat.app.model.Estudiante;



public interface EstudianteService {

	void guardar(Estudiante estudiante);
	void actualizar(Estudiante estudiante);
	void eliminar(Integer id);
	List<Estudiante> listar();
	Estudiante obtener(Integer id);
}
