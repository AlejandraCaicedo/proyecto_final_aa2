package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

/**
 * ID class for entity: Compra
 *
 */
public class CompraPK implements Serializable {

	private String userID;
	private String productCode;
	private static final long serialVersionUID = 1L;

	public CompraPK() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/*
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof CompraPK)) {
			return false;
		}
		CompraPK other = (CompraPK) o;
		return true && (getUserID() == null ? other.getUserID() == null : getUserID().equals(other.getUserID()))
				&& (getProductCode() == null ? other.getProductCode() == null
						: getProductCode().equals(other.getProductCode()));
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getUserID() == null ? 0 : getUserID().hashCode());
		result = prime * result + (getProductCode() == null ? 0 : getProductCode().hashCode());
		return result;
	}

}
