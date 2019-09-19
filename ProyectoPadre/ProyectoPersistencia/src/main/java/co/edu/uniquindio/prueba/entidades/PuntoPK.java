package co.edu.uniquindio.prueba.entidades;

import java.io.Serializable;

/**
 * ID class for entity: Punto
 *
 */ 
public class PuntoPK  implements Serializable {   
   
	         
	private double latitud;         
	private double longitud;
	private static final long serialVersionUID = 1L;

	public PuntoPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PuntoPK)) {
			return false;
		}
		PuntoPK other = (PuntoPK) o;
		return true
			&& (Double.doubleToLongBits(getLatitud()) == Double.doubleToLongBits(other.getLatitud()))
			&& (Double.doubleToLongBits(getLongitud()) == Double.doubleToLongBits(other.getLongitud()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((int) (Double.doubleToLongBits(getLatitud() ) ^ (Double.doubleToLongBits(getLatitud()) >>> 32)));
		result = prime * result + ((int) (Double.doubleToLongBits(getLongitud() ) ^ (Double.doubleToLongBits(getLongitud()) >>> 32)));
		return result;
	}
   
   
}
