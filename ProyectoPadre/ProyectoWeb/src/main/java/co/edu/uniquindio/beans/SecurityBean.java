package co.edu.uniquindio.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("securityBean")
@FacesConfig(version = Version.JSF_2_3)
@SessionScoped
public class SecurityBean implements Serializable {

	private String email, password;
	private User user = new User();
	private boolean autentify;

	@EJB
	private NegocioEJB negocioEJB;

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void inicializar() {
		this.user = new User();
		this.autentify = false;
	}

	public String iniciarSesion() {
		User u = negocioEJB.autentifyUser(email, password);

		if (u != null) {
			this.user = u;
			this.autentify = true;

			return "index?faces-redirect =true";
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Not found an user", "The email or password are incorrect"));
		}
		return null;

	}

	public Product[] getOwnProducts() {
		Product[] products;
		List<Product> list = user.getListProducts();
		products = negocioEJB.listToArrayProduct(list);
		return products;
	}

	public Purchase[] getOwnPurchases() {
		Purchase[] purchases;
		List<Purchase> list = user.getListPurchases();
		purchases = negocioEJB.listToArrayPurchase(list);
		return purchases;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAutentify() {
		return autentify;
	}

	public void setAutentify(boolean autentify) {
		this.autentify = autentify;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
