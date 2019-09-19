package co.edu.uniquindio.prueba.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehiculo
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = Vehiculo.TODOS_VEHICULOS, query = "select v from Vehiculo v"),
		@NamedQuery(name = Vehiculo.TODOS_VEHICULOS_COLOR, query = "select v from Vehiculo v where v.color = :color") })

public class Vehiculo implements Serializable {

	@Id
	private String codigo;
	private String color;
	private int modelo;

	@ManyToOne
	private Marca marca;
	private static final long serialVersionUID = 1L;
	public static final String TODOS_VEHICULOS = "TODOS_VEHICULOS";
	public static final String TODOS_VEHICULOS_COLOR = "TODOS_VEHICULOS_COLOR";

	public Vehiculo() {
		super();
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModelo() {
		return this.modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", color=" + color + ", modelo=" + modelo + ", marca=" + marca + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + modelo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo != other.modelo)
			return false;
		return true;
	}

}
