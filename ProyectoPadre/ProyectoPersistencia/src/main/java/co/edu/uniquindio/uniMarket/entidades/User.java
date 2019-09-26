package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

/**
 * 
 * @author Juan David Ariza
 * @author Alejandra Caicedo Chaves
 * @author Alejandro Gutierrez Velez
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
	private List<Purchase> listCompra; // Lista de compras que ha hecho un usuario

	@OneToMany(mappedBy = "user")
	private List<Rate> rates; // Lista de calificaciones que ha hecho un usuario

	@OneToMany(mappedBy = "user")
	private List<Commentary> comments; // Lista de comentario que ha hecho un usuario

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase usuario, hereda de la clase persona
	 */
	public User() {
		super();
	}

	/**
	 * Constructor con los parametros para crear un usuario
	 * 
	 * @param iD,
	 *            registro unico de cada usuario
	 * @param fullName,
	 *            nombre completo de un usuario
	 * @param email,
	 *            correo electronico de cada usuario
	 * @param cellphoneNumber,
	 *            numero de celular de cada usuario
	 * @param adress,
	 *            direccion de residencia de un usuario
	 * @param password,
	 *            contraseña que tiene cada usuario
	 */
	public User(String iD, String fullName, String email, String cellphoneNumber, String adress, String password) {
		super(iD, fullName, email, cellphoneNumber, adress, password);
	}

	/**
	 * Metodo que permite obtener una lista de compras realizadas por un usuario
	 * 
	 * @return listCompra
	 */
	public List<Purchase> getListCompra() {
		return listCompra;
	}

	/**
	 * Metodo que permite asignar un listado de compras realizadas por un usuario x
	 * 
	 * @param listCompra,
	 *            es la lista de comopras que le va a ser aignado al usuario
	 */
	public void setListCompra(List<Purchase> listCompra) {
		this.listCompra = listCompra;
	}

	/**
	 * Metodo que permite obtener el listado de calificaciones de un usuario
	 * 
	 * @return rates
	 */
	public List<Rate> getRates() {
		return rates;
	}

	/**
	 * Metodo para asignar calificaciones hechas por un usuario
	 * 
	 * @param rates,
	 *            lista de calificaciones hechas por el usuario
	 */
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	/**
	 * Metodo que permite obtener los cometnarios que ha realizado un usuario
	 * 
	 * @return comments
	 */
	public List<Commentary> getComments() {
		return comments;
	}

	/**
	 * Metodo que permite asignar un listado de comentarios a un usuario
	 * 
	 * @param comments,
	 *            es el listado de calificaciones hechos por un usuario
	 */
	public void setComments(List<Commentary> comments) {
		this.comments = comments;
	}

	/**
	 * Metodo que permite dar una estructura definida a la forna en que se muestra
	 * la informacion sobre el usuario
	 */
	@Override
	public String toString() {
		return "User [listCompra=" + listCompra + ", rates=" + rates + ", comments=" + comments + "]";
	}

	/**
	 * Metodo hashCode para la entidad Usuario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((listCompra == null) ? 0 : listCompra.hashCode());
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
		return result;
	}

	/**
	 * Metodo que permite comparar si 2 personas son iguales dada su llave primaria
	 */
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
