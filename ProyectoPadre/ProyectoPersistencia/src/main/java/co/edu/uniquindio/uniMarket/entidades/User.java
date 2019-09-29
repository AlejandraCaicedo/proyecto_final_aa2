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
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
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
//		@NamedQuery(name = User.PRODUCTOS_USUARIO, query = "select u, p from User u inner join u.listProducts p"),
		@NamedQuery(name = User.ALL_USERS, query = "select u from User u") })
public class User extends Person implements Serializable {

	@OneToMany(mappedBy = "user")
	private List<Purchase> listPurchases; // Lista de compras que ha hecho un usuario

	@OneToMany(mappedBy = "user")
	private List<Rate> listRates; // Lista de calificaciones que ha hecho un usuario

	@OneToMany(mappedBy = "user")
	private List<Commentary> listComments; // Lista de comentarios que ha hecho un usuario

	@OneToMany(mappedBy = "user")
	private List<Product> listProducts; // Lista de productos que ha creado un usuario

	private static final long serialVersionUID = 1L;

	public static final String PRODUCTOS_USUARIO = "PRODUCTOS_USUARIO";

	public static final String ALL_USERS = "ALL_USERS";

	/**
	 * Constructor vacio de la clase usuario, hereda de la clase persona
	 */
	public User() {
		super();
	}

	/**
	 * Constructor con los parametros para crear un usuario
	 * 
	 * @param iD,              registro unico de cada usuario
	 * @param fullName,        nombre completo de un usuario
	 * @param email,           correo electronico de cada usuario
	 * @param cellphoneNumber, numero de celular de cada usuario
	 * @param adress,          direccion de residencia de un usuario
	 * @param password,        contraseña que tiene cada usuario
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
		return listPurchases;
	}

	/**
	 * Metodo que permite asignar un listado de compras realizadas por un usuario x
	 * 
	 * @param listCompra, es la lista de comopras que le va a ser aignado al usuario
	 */
	public void setListCompra(List<Purchase> listCompra) {
		this.listPurchases = listCompra;
	}

	/**
	 * Metodo que permite obtener el listado de calificaciones de un usuario
	 * 
	 * @return rates
	 */
	public List<Rate> getRates() {
		return listRates;
	}

	/**
	 * Metodo para asignar calificaciones hechas por un usuario
	 * 
	 * @param rates, lista de calificaciones hechas por el usuario
	 */
	public void setRates(List<Rate> rates) {
		this.listRates = rates;
	}

	/**
	 * Metodo que permite obtener los cometnarios que ha realizado un usuario
	 * 
	 * @return comments
	 */
	public List<Commentary> getComments() {
		return listComments;
	}

	/**
	 * Metodo que permite asignar un listado de comentarios a un usuario
	 * 
	 * @param comments, es el listado de calificaciones hechos por un usuario
	 */
	public void setComments(List<Commentary> comments) {
		this.listComments = comments;
	}

	/**
	 * Metodo que permite dar una estructura definida a la forna en que se muestra
	 * la informacion sobre el usuario
	 */
	@Override
	public String toString() {
		return "User [listCompra=" + listPurchases + ", rates=" + listRates + ", comments=" + listComments + "]";
	}

	/**
	 * Metodo hashCode para la entidad Usuario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listComments == null) ? 0 : listComments.hashCode());
		result = prime * result + ((listPurchases == null) ? 0 : listPurchases.hashCode());
		result = prime * result + ((listRates == null) ? 0 : listRates.hashCode());
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
		if (listComments == null) {
			if (other.listComments != null)
				return false;
		} else if (!listComments.equals(other.listComments))
			return false;
		if (listPurchases == null) {
			if (other.listPurchases != null)
				return false;
		} else if (!listPurchases.equals(other.listPurchases))
			return false;
		if (listRates == null) {
			if (other.listRates != null)
				return false;
		} else if (!listRates.equals(other.listRates))
			return false;
		return true;
	}

}
