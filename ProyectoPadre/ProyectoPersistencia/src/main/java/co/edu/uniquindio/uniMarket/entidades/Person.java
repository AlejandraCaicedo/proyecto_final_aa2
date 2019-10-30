package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;

import javax.mail.internet.NewsAddress;
import javax.persistence.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Entity implementation class for Entity: Persona
 *
 */

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "TYPE")
@NamedQueries({ @NamedQuery(name = Person.ALL_PERSONS, query = "select p from Person p"),
		@NamedQuery(name = Person.FIND_BY_ID, query = "select p from Person p where p.ID = :ID") })
public class Person implements Serializable {

	@Id
	private String ID; // Identificador unico de cada persona

	@Column(name = "fullName", nullable = false)
	private String fullName; // Nombre completo de la persona que existe en la base de datos

	@Column(name = "cellphoneNumber", length = 10, nullable = false)
	private String cellphoneNumber; // Numero de telefono actual de la persona en cuestion

	@Column(name = "adress", nullable = false)
	private String adress; // Direccion de residencia de la persona existente en UniMarket

	@Column(name = "password", nullable = false)
	private String password; // Contrasenia con la que se identificara cada persona

	@Column(name = "email", nullable = false)
	private String email; // Correo electronico de una persona en especifico

	// Query que retorna todas las personas registradas en la vase de datos
	public static final String ALL_PERSONS = "ALL_PERSONS";

	// Query que retorna una Persona dado su ID
	public static final String FIND_BY_ID = "FIND_BY_ID";

	private static final long serialVersionUID = 1L;

	public Person() {

	}

	/**
	 * Constructor que recibe cada parametro a la hora de crear una persona
	 * 
	 * @param iD,              identificador unico de cada persona
	 * @param fullName,        nombre completo de alguna persona
	 * @param email,           correo electronico de la persona en cuestion
	 * @param cellphoneNumber, numero de telefono de una persona en la base de datos
	 * @param adress,          direccion de residencia de una persona en especifico
	 * @param password,        contrasenia con la que se identifica cada persona al
	 *                         ingresar a UniMarket
	 */
	public Person(String iD, String fullName, String email, String cellphoneNumber, String adress, String password) {
		super();
		this.ID = iD;
		this.fullName = fullName;
		this.email = email;
		this.cellphoneNumber = cellphoneNumber;
		this.adress = adress;
		this.password = password;
//
//		this.IdProperty = new SimpleStringProperty(ID);
//		this.adressProperty = new SimpleStringProperty(adress);
//		this.fullNameProperty = new SimpleStringProperty(fullName);
//		this.emailProperty = new SimpleStringProperty(email);
//		this.cellPhoneNumberProperty = new SimpleStringProperty(cellphoneNumber);
//		this.passwordProperty = new SimpleStringProperty(password);

	}

//	private final StringProperty IdProperty;
//	private final StringProperty fullNameProperty;
//	private final StringProperty emailProperty;
//	private final StringProperty cellPhoneNumberProperty;
//	private final StringProperty adressProperty;
//	private final StringProperty passwordProperty;

//	public StringProperty getIdProperty() {
//		return IdProperty;
//	}
//
//	public StringProperty getFullNameProperty() {
//		return fullNameProperty;
//	}
//
//	public StringProperty getEmailProperty() {
//		return emailProperty;
//	}
//
//	public StringProperty getCellPhoneNumberProperty() {
//		return cellPhoneNumberProperty;
//	}
//
//	public StringProperty getAdressProperty() {
//		return adressProperty;
//	}
//
//	public StringProperty getPasswordProperty() {
//		return passwordProperty;
//	}

	/**
	 * Metodo que obtiene la identificacion de una persona
	 * 
	 * @return ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Metodo que poner un valor a la identificacion de una persona
	 * 
	 * @param iD, identificador para una persona, debe ser unico
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Metodo para obtener el nombre completo de una persona
	 * 
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Metodo para poner un nombre a una persona
	 * 
	 * @param fullName, nombre completo de la persona
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Metodo para obtener un correo electronico de una persona
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que pone un correo electronico a una persona
	 * 
	 * @param email, correo electronico a ser asignado a una persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo para obtener el numero de telefono de una persona
	 * 
	 * @return cellphoneNumber
	 */
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	/**
	 * Metodo que asigna un numero de telefono a una persona
	 * 
	 * @param cellphoneNumber, numero de telefono a ser asignado
	 */
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	/**
	 * Metodo que obtiene la direccion de residencia de una oersona en particular
	 * 
	 * @return adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Metodo para dar un valor a una direccion de una persona
	 * 
	 * @param adress, direccion de residencia de la persona en cuestion
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * Metodo para obtener la contrasenia de una persona
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo para poner una contrasenia a una persona registrada
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

//	public StringProperty getIDProperty() {
//		StringProperty iDProperty = new SimpleStringProperty(ID);
//		return iDProperty;
//	}
//
//	public StringProperty getFirstNameProperty() {
//		StringProperty firstNameProperty = new SimpleStringProperty(fullName);
//		return firstNameProperty;
//	}
//
//	public StringProperty getCellphoneNumberProperty() {
//		StringProperty cellphoneProperty = new SimpleStringProperty(cellphoneNumber);
//		return cellphoneProperty;
//	}
//
//	public StringProperty getAdressProperty() {
//		StringProperty adressProperty = new SimpleStringProperty(adress);
//		return adressProperty;
//	}
//
//	public StringProperty getPasswordProperty() {
//		StringProperty passwordProperty = new SimpleStringProperty(password);
//		return passwordProperty;
//	}
//
//	public StringProperty getEmailProperty() {
//		StringProperty emailProperty = new SimpleStringProperty(email);
//		return emailProperty;
//	}

	/**
	 * Metodo hashCode de la clase persona
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((cellphoneNumber == null) ? 0 : cellphoneNumber.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * Metodo para comparar que dos personas no sean iguales a partir de su llave
	 * primaria (ID)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/**
	 * Metodo para asignar una forma standar a la hora de buscar una persona
	 */
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", fullName=" + fullName + ", email=" + email + ", cellphoneNumber="
				+ cellphoneNumber + ", adress=" + adress + ", password=" + password + "]";
	}

}
