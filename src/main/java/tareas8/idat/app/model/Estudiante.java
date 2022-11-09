package tareas8.idat.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="estudiante")
public class Estudiante {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstudiante;
	private String nombre;
	private String apellidos;
	private Integer dni;
	
	
}
