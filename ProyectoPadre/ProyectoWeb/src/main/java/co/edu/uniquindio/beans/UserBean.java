package co.edu.uniquindio.beans;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("userBean")
@ApplicationScoped
public class UserBean {

	@EJB
	private NegocioEJB negocioEJB;

	private String ID, fullName, email, adress, password, cellphoneNumber;

	public void registrarUsuario() {
		User user = new User(ID, fullName, email, cellphoneNumber, adress, password);
		try {
			negocioEJB.toRegisterUser(user);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sumary", "New user created");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (RepeatedIDException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Identifier Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (RepeatedEmailException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Email Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
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
