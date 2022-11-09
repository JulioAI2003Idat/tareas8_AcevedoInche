package tareas8.idat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tareas8.idat.app.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

}
