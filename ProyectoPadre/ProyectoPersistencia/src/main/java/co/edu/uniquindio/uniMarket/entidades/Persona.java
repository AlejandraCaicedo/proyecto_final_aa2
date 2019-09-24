package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona implements Serializable {

	@Id
	private String ID;
	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}

	public Persona(String ID) {
		super();
		this.ID = ID;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

}
