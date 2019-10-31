package co.edu.uniquindio.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("userBean")
@ApplicationScoped
public class UserBean {

//	@EJB
	private NegocioEJB negocioEJB;

	private String ID, fullName, email, adress, password, cellphoneNumber;

	public void registrarUsuario() {
		User user = new User(ID, fullName, email, cellphoneNumber, adress, password);
		try {
			negocioEJB.toRegisterUser(user);
		} catch (RepeatedIDException e) {
			e.printStackTrace();
		} catch (RepeatedEmailException e) {
			e.printStackTrace();
		}
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

}
