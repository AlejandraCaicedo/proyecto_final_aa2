package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
@NamedQueries({
		// @NamedQuery(name = "TODOS_PRODUCTOS_COMPRA_OTRO_EJEMPLO", query = "select
		// d.productoCompra from Compra c, IN( c.detalleCompra) d where c.codigo = :
		// codigo"),
		// @NamedQuery(name = "TODOS_PRODUCTOS_COMPRA", query = "select d.productoCompra
		// from Compra c inner join c.detalleCompra d where c.codigo = :codigo"),
		// @NamedQuery(name = "TODAS_COMPRAS_PERSONA", query = "select c from Compra c
		// where c.usuarioCompra.nombre = 'pepito'")
})
public class User extends Person implements Serializable {

	@OneToMany(mappedBy = "user")
	private List<Purchase> listCompra;

	@OneToMany(mappedBy = "user")
	private List<Rate> rates;

	@OneToMany(mappedBy = "user")
	private List<Commentary> comments;

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String iD, String fullName, String email, String cellphoneNumber, String adress, String password) {
		super(iD, fullName, email, cellphoneNumber, adress, password);
	}

	public List<Purchase> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Purchase> listCompra) {
		this.listCompra = listCompra;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<Commentary> getComments() {
		return comments;
	}

	public void setComments(List<Commentary> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User [listCompra=" + listCompra + ", rates=" + rates + ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((listCompra == null) ? 0 : listCompra.hashCode());
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (listCompra == null) {
			if (other.listCompra != null)
				return false;
		} else if (!listCompra.equals(other.listCompra))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		return true;
	}

}
