package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;

/**
 * ID class for entity: Calificacion
 *
 */
@Embeddable
public class RatePK implements Serializable {

	private String product;
	private String user;

	private static final long serialVersionUID = 1L;

	public RatePK() {
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String productCode) {
		this.product = productCode;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String userID) {
		this.user = userID;
	}

	/*
	 * @see java.lang.Object#equals(Object)
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

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getProduct() == null ? 0 : getProduct().hashCode());
		result = prime * result + (getUser() == null ? 0 : getUser().hashCode());
		return result;
	}

}
