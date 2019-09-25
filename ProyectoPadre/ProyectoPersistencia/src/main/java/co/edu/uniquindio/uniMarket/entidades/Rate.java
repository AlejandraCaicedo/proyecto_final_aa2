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
	@MapsId("product")
	private Product product;

	@ManyToOne
	@MapsId("user")
	private User user;

	@Column(name = "rate", nullable = false)
	private double rate;

	private static final long serialVersionUID = 1L;

	public Rate() {
		super();
	}

	public Rate(RatePK rateID, Product product, User user, double rate) {
		super();
		this.rateID = rateID;
		this.product = product;
		this.user = user;
		this.rate = rate;
	}

	public RatePK getRateID() {
		return rateID;
	}

	public void setRateID(RatePK rateID) {
		this.rateID = rateID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rateID == null) ? 0 : rateID.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (rateID == null) {
			if (other.rateID != null)
				return false;
		} else if (!rateID.equals(other.rateID))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rate [rateID=" + rateID + ", product=" + product.getName() + ", user=" + user.getFullName() + ", rate="
				+ rate + "]";
	}

}
