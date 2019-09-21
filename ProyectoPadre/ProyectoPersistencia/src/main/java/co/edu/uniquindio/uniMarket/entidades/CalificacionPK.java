package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Calificacion
 *
 */ 
public class CalificacionPK  implements Serializable {   
   
	         
	private String codigoProducto;         
	private String cedulaUsuario;
	private static final long serialVersionUID = 1L;

	public CalificacionPK() {}

	

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	

	public String getCedulaUsuario() {
		return this.cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof CalificacionPK)) {
			return false;
		}
		CalificacionPK other = (CalificacionPK) o;
		return true
			&& (getCodigoProducto() == null ? other.getCodigoProducto() == null : getCodigoProducto().equals(other.getCodigoProducto()))
			&& (getCedulaUsuario() == null ? other.getCedulaUsuario() == null : getCedulaUsuario().equals(other.getCedulaUsuario()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getCodigoProducto() == null ? 0 : getCodigoProducto().hashCode());
		result = prime * result + (getCedulaUsuario() == null ? 0 : getCedulaUsuario().hashCode());
		return result;
	}
   
   
}
