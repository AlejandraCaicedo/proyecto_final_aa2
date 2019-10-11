package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Admin.ALL_ADMIN, query = "select a from Admin a"),
		@NamedQuery(name = Admin.FIND_ADMIN, query = "select a from Admin a where a.ID =:ID and a.password =:password") })
public class Admin extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	// Query que retorna todos los administradores actuales
	public static final String ALL_ADMIN = "ALL_ADMIN";

	// Query que retorna un Admin dado un ID y la contraseņa
	public static final String FIND_ADMIN = "FIND_ADMIN";

	/**
	 * Constructor vacio de la clase administrador, hereda de la clase persona
	 */
	public Admin() {
		super();
	}

	/**
	 * Constructor de la clase administrador
	 * 
	 * @param iD,              Identificacion unica del administrador
	 * @param fullName,        nombre completo del administrador
	 * @param email,           correo electronico que posee el administrador
	 * @param cellphoneNumber, numero de telefono del administrador
	 * @param adress,          direccion de residencia actual del administrador
	 * @param password,        contrasenia con la que ingresara el administrador
	 */
	public Admin(String iD, String fullName, String email, String cellphoneNumber, String adress, String password) {
		super(iD, fullName, email, cellphoneNumber, adress, password);
	}

	/**
	 * Metodo hashcode del metodo administrador
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Metodo equals del administador que determina si dos objetos son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	/**
	 * Metodo toString para dar una forma standar al muestreo de los administradores
	 */
	@Override
	public String toString() {
		return "Admin []";
	}

}
