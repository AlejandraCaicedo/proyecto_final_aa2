package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Person implements Serializable {

	private String name;
	private String password;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(String ID, String name, String password) {
		super(ID);
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
