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

	private String productCode;
	private String userID;

	private static final long serialVersionUID = 1L;

	public RatePK() {
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
		return true
				&& (getProductCode() == null ? other.getProductCode() == null
						: getProductCode().equals(other.getProductCode()))
				&& (getUserID() == null ? other.getUserID() == null : getUserID().equals(other.getUserID()));
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getProductCode() == null ? 0 : getProductCode().hashCode());
		result = prime * result + (getUserID() == null ? 0 : getUserID().hashCode());
		return result;
	}

}
