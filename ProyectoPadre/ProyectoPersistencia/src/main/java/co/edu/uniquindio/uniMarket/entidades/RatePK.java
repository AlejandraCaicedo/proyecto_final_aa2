package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Embeddable
public class RatePK implements Serializable {

	private String product; // Identificacion de un producto que va a ser calificado
	private String user; // Identificacion del usuario que califca un producto

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase ratePK
	 */
	public RatePK() {
	}

	/**
	 * Metodo que permite obtener el codigo de un producto
	 * 
	 * @return product
	 */
	public String getProduct() {
		return this.product;
	}

	/**
	 * Metodo que permite asinar un codigo a un producto dentro de la clase ratePK
	 * 
	 * @param productCode, codigo del producto que va a ser asignado
	 */
	public void setProduct(String productCode) {
		this.product = productCode;
	}

	/**
	 * Metodo que permite obtener el codigo de un usuario que califica
	 * 
	 * @return user
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * Metodo que permite asignar un codigo a un usuario
	 * 
	 * @param userID, identificacion del usuario a ser asignada
	 */
	public void setUser(String userID) {
		this.user = userID;
	}

	/**
	 * Metodo que permite comparar si dos registros son o no iguales
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RatePK)) {
			return false;
		}
		RatePK other = (RatePK) o;
		return true && (getProduct() == null ? other.getProduct() == null : getProduct().equals(other.getProduct()))
				&& (getUser() == null ? other.getUser() == null : getUser().equals(other.getUser()));
	}

	/**
	 * Metodo hashCode de la clase ratePK
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getProduct() == null ? 0 : getProduct().hashCode());
		result = prime * result + (getUser() == null ? 0 : getUser().hashCode());
		return result;
	}

}
