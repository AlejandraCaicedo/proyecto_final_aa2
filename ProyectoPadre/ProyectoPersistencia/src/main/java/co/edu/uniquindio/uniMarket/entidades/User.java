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
@DiscriminatorValue("USER")
@NamedQueries({
		// @NamedQuery(name = "TODOS_PRODUCTOS_COMPRA_OTRO_EJEMPLO", query = "select
		// d.productoCompra from Compra c, IN( c.detalleCompra) d where c.codigo = :
		// codigo"),
//		@NamedQuery(name = User.ALL_PRODUCTS_PURCHASE, query = "select d.product from Purchase p inner join p.PurchaseDetail d where p.purchaseCode = :codigo"),
		// @NamedQuery(name = "TODAS_COMPRAS_PERSONA", query = "select c from Compra c
		// where c.usuarioCompra.nombre = 'pepito'")
		@NamedQuery(name = User.USER_PRODUCTS, query = "select u, p from User u inner join u.listProducts p"),
		@NamedQuery(name = User.ALL_USERS, query = "select u from User u"),
		@NamedQuery(name = User.GMAIL_USERS, query = "select u from User u where u.email like '%gmail%' "),
		@NamedQuery(name = User.PUBLISHED_PRODUCTS, query = "select new co.edu.uniquindio.uniMarket.dto.PUBLISHED_PRODUCTS(u.ID,u.email, count(p)) from User u INNER JOIN u.listProducts p"),
		@NamedQuery(name = User.FIND_BY_EMAIL, query = "select u from User u where u.email =:EMAIL"),
		@NamedQuery(name = User.ALL_SELLING_USERS, query = "select u from User u INNER JOIN u.listProducts p group by u having count(p)>0"),
		@NamedQuery(name = User.All_SHOPPERS_USERS, query = "select u from User u INNER JOIN u.listPurchases p group by u having count(p)>0"),
		@NamedQuery(name = User.AUTENTIFY_USER, query = "select u from User u where u.password = :password and u.email = :email") })

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

	// Query que retorna los usuarios y su lista de productos publicados
	public static final String USER_PRODUCTS = "USER_PRODUCTS";

	// Query que retorna todos los usuarios
	public static final String ALL_USERS = "ALL_USERS";
//	public static final String ALL_PRODUCTS_PURCHASE = "TODOS_PRDUCTOS_COMPRA";

	// Query que retorna todos los usuarios que estan registrados con un gmail
	public static final String GMAIL_USERS = "GMAIL_USERS";

	// Query que retorna un DTO con el ID, el email y la cantidad de productos
	// publicados de todos los usuarios
	public static final String PUBLISHED_PRODUCTS = "PUBLISHED_PRODUCTS";

	// Query que retorna un usuario dado un Correo Electronico
	public static final String FIND_BY_EMAIL = "FIND_BY_EMAIL";

	// Query que retorna todos los Usuarios que son vendedores
	public static final String ALL_SELLING_USERS = "TODOS_USUARIOS_VENDEDORES";

	public static final String All_SHOPPERS_USERS = "All_SHOPPERS_USERS";

	public static final String AUTENTIFY_USER = "AUTENTIFY_USER";

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
