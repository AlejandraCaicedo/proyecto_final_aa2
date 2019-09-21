package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Calificacion
 *
 */
@Entity

@IdClass(CalificacionPK.class)
public class Calificacion implements Serializable {

	@Id
	private String codigoProducto;
	@Id
	private String cedulaUsuario;
	private double calificacion;
	private static final long serialVersionUID = 1L;

	public Calificacion() {
		super();
	}

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

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

}
