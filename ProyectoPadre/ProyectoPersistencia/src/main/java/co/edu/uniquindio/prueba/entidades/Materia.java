package co.edu.uniquindio.prueba.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Materia
 *
 */
@Entity

public class Materia implements Serializable {

	@Id
	private String codigo;
	private String nombre;

	@ManyToMany
	private List<Estudiante> estudiantes;

	private static final long serialVersionUID = 1L;

	public Materia() {
		super();
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
