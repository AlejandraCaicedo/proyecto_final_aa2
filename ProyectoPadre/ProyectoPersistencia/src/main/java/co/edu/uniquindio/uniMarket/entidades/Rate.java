package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Rate.ALL_RATINGS, query = "select r from Rate r"),
		@NamedQuery(name = Rate.RATIGNS_PRODUCT, query = "select r from Rate r where r.product.code = :codigo") })
public class Rate implements Serializable {

	@EmbeddedId
	private RatePK rateID; // Identificador unico sobre la valoracion de un producto

	@ManyToOne
	@MapsId("product")
	private Product product; // Producto que ha sido valorado

	@ManyToOne
	@MapsId("user")
	private User user; // Usuario que califica un producto

	@Column(name = "rate", nullable = false)
	private double rate; // Calificacion obtenida de un producto

	private static final long serialVersionUID = 1L;

	public static final String ALL_RATINGS = "ALL_RATINGS";
	public static final String RATIGNS_PRODUCT = "RATIGNS_PRODUCT";

	/**
	 * Constructor vacio de la clase calificacion
	 */
	public Rate() {
		super();
	}

	/**
	 * Constructor con parametros para la creacion de una calificacion
	 * 
	 * @param rateID,  identificacion unica sobre una calificacion
	 * @param product, producto que ha sido calificado
	 * @param user,    usuario que califica un producto
	 * @param rate,    calificacion que obtiene un producto de un usuario
	 */
	public Rate(RatePK rateID, Product product, User user, double rate) {
		super();
		this.rateID = rateID;
		this.product = product;
		this.user = user;
		this.rate = rate;
	}

	/**
	 * Metodo que permite obtener la identificacion de una calificacion
	 * 
	 * @return rateID
	 */
	public RatePK getRateID() {
		return rateID;
	}

	/**
	 * Metodo que permite asignar una identificacion a un producto
	 * 
	 * @param rateID, registro unico de una calificacion
	 */
	public void setRateID(RatePK rateID) {
		this.rateID = rateID;
	}

	/**
	 * Metodo que permite obtener un producto valorado
	 * 
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metodo que permite asignar un producto a la calificacion
	 * 
	 * @param product, es el producto a ser valorado
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metodo que permite obtener el ususario que realiza una calificacion
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Metodo que permite asignar un usuario que va a calificar un producto
	 * 
	 * @param user, usuario que valora un producto
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Metodo que permite obtener la valoracion dada a un producto
	 * 
	 * @return rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Metodo que permite asignar una calificacion
	 * 
	 * @param rate, calificacion que se le da a un producto
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * Metodo hashCOde para la clase calificacion
	 */
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

	/**
	 * Metodo que permite comparar que 2 calificaciones no tengan el mismo
	 * identificador
	 */
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

	/**
	 * Metodo que permite dar una forma standarizada a la hora de mostrar la
	 * informacion sobre una calificacion
	 */
	@Override
	public String toString() {
		return "Rate [rateID=" + rateID + ", product=" + product.getName() + ", user=" + user.getFullName() + ", rate="
				+ rate + "]";
	}

}
