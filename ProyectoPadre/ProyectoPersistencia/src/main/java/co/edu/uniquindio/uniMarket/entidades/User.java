package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.HashMap;
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

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "cellphoneNumber", length = 10, nullable = false)
	private String cellphoneNumber;

	@Column(name = "adress", nullable = false)
	private String adress;

	@Column(name = "password", nullable = false)
	private String password;

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

	public User(String ID, String fullName, String email, String cellphoneNumber, String adress, String password) {
		super(ID);
		this.fullName = fullName;
		this.email = email;
		this.cellphoneNumber = cellphoneNumber;
		this.adress = adress;
		this.password = password;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphoneNumber() {
		return this.cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Purchase> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Purchase> listCompra) {
		this.listCompra = listCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((cellphoneNumber == null) ? 0 : cellphoneNumber.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((listCompra == null) ? 0 : listCompra.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (cellphoneNumber == null) {
			if (other.cellphoneNumber != null)
				return false;
		} else if (!cellphoneNumber.equals(other.cellphoneNumber))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (listCompra == null) {
			if (other.listCompra != null)
				return false;
		} else if (!listCompra.equals(other.listCompra))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", cellphoneNumber=" + cellphoneNumber + ", adress="
				+ adress + ", password=" + password + "]";
	}

}
