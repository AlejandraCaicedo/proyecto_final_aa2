package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentary
 *
 */
/**
 * 
 * @author Juan David Ariza
 * @author Alejandro Caicedo Chaves
 * @author Alejandro Gutierrez Velez
 * 
 */

@Entity

public class Commentary implements Serializable {

	@Id
	@Column(name = "ID")
	private String ID; //Registro unico de un comentario en particular

	@ManyToOne
	private User user; // Es el usuario que comenta acerca de un producto

	private Product product; // Es el producto que desea comentar el usuario

	@Column(name = "comment", nullable = false)
	private String comment; // Es el comentario que hace un usuario a un producto en especifico
	private static final long serialVersionUID = 1L;

	/**
	 * Contructor vacio de la clase comentario
	 */
	public Commentary() {
		super();
	}

	/**
	 * Constructor que recibe atributos de un nuevo comentario
	 * @param iD, identificacion unica de un comentario
	 * @param user, usuario que comenta un producto
	 * @param product, producto sobre el que comenta un usuario
	 * @param comment, comentario que recibe un producto de un usuario
	 */
	public Commentary(String iD, User user, Product product, String comment) {
		super();
		ID = iD;
		this.user = user;
		this.product = product;
		this.comment = comment;
	}

	/**
	 * Metodo para obtener una identificacion
	 * @return ID
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Metodo para colocar un valor a un comentario realizado
	 * @param ID, Identificacion del comentario a colocarle el nuevo valor
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * Metodo para obtener un comentario en especifico
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * Metodo que pone un comentario solicitado
	 * @param comment, es el comentario que se le pondra a un producto en especifico
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Metodo que obtiene el usuario que comento sobre un producto
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Metodo que permite enlazar un usuario con un comentario
	 * @param user, usuario que comenta
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Metodo que obtiene un producto en especifico
	 * @return producto al que se le hace un comentario
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metodo para poner un producto al que se va a comentar
	 * @param product, producto que va a ser comentado
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metodo hashCode para el comentario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Metodo para comparar si 2 objetos son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commentary other = (Commentary) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/**
	 * Metodo para dar una forma standar a la hora de mostrar un comentario
	 */
	@Override
	public String toString() {
		return "Commentary [ID=" + ID + ", user=" + user.getFullName() + ", product=" + product.getName() + ", comment="
				+ comment + "]";
	}

}
