package co.edu.uniquindio.prueba.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Profesor
 *
 */
@Entity

public class Profesor extends Persona_Prueba implements Serializable {

	private String cargo;
	private static final long serialVersionUID = 1L;

	public Profesor() {
		super();
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
