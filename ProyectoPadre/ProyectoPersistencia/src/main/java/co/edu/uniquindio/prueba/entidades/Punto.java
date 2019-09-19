package co.edu.uniquindio.prueba.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Punto
 *
 */
@Entity

@IdClass(PuntoPK.class)
public class Punto implements Serializable {

	   
	@Id
	private double latitud;   
	@Id
	private double longitud;
	private String nombre;
	private static final long serialVersionUID = 1L;

	public Punto() {
		super();
	}   
	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}   
	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
