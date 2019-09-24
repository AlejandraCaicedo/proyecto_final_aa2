package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.metadata.CascadableDescriptor;

/**
 * Entity implementation class for Entity: Calificacion
 *
 */
@NamedQueries({

		// @NamedQuery(name = "CALIFICACIONES_PRODUCTO", query = "select c from
		// Calificacion c where c.productoCalificacion.codigo = :codigo")
})

@Entity
public class Rate implements Serializable {

	@EmbeddedId
	private RatePK rateID;

	@ManyToOne
	@MapsId("productCode")
	private Product productCode;

	@ManyToOne
	@MapsId("userID")
	private User userID;

	@Column(name = "rate", nullable = false)
	private double rate;

	private static final long serialVersionUID = 1L;

	public Rate() {
		super();
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Calificacion [productCode=" + productCode + ", userID=" + userID + ", rate=" + rate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		Rate other = (Rate) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

}
