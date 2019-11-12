package co.edu.uniquindio.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.MessagingException;

import co.edu.uniquindio.uniMarket.Email.EmailClient;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundTypeProduct;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("userBean")
@ApplicationScoped
public class UserBean {

	@EJB
	private NegocioEJB negocioEJB;

	private String ID, fullName, email, adress, password, cellphoneNumber;

	public String createUser() {
		try {
			User user = new User(ID, fullName, email, cellphoneNumber, adress, password);

			negocioEJB.toRegisterUser(user);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sumary", "New user created");
			FacesContext.getCurrentInstance().addMessage(null, message);

			return "";
		} catch (RepeatedIDException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Identifier Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (RepeatedEmailException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Email Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public User iniciarSesion(String email, String password) {

		User user = negocioEJB.autentifyUser(email, password);

		if (user == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Not found User",
					"The user can't be find, the password or the email is incorrect");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return user;
	}

//	public Product publishProduct(String code, String name, String description, double price, int availability,
//			Type type, Date limit_Date) {
//		Product product = null;
//		product = new Product(code, name, description, price, availability, type, limit_Date);
//		return product;
//	}

	public Product[] getListAllProducts() {
		Product[] products;
		List<Product> list = negocioEJB.toListProducts();
		products = negocioEJB.listToArrayProduct(list);
		return products;
	}

	public Product[] getListProductByType(String type) {
		Product[] products = null;
		List<Product> list;
		try {
			list = negocioEJB.toListByType(type);
			products = negocioEJB.listToArrayProduct(list);
			return products;
		} catch (NotFoundTypeProduct e) {
			e.printStackTrace();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not Found Type", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
	}

	public void addFavorite(User user, Product product) {
		user.getListFavorites().add(product);
		negocioEJB.toEditUser(user, user.getID());
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been added to your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void removeFavorite(User user, Product product) {
		user.getListFavorites().remove(product);
		negocioEJB.toEditUser(user, user.getID());
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been removed from your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void recoverPassword(User user) {
		try {
			EmailClient.toRecoverPasswordUser(user.getEmail());
		} catch (MessagingException e) {
			e.printStackTrace();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Error",
					"There was an error trying to send the recover email, verify if your email is correct");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public Product[] getOwnProducts(User user) {
		Product[] products;
		List<Product> list = user.getListProducts();
		products = negocioEJB.listToArrayProduct(list);
		return products;
	}

	public Purchase[] getOwnPurchases(User user) {
		Purchase[] purchases;
		List<Purchase> list = user.getListPurchases();
		purchases = negocioEJB.listToArrayPurchase(list);
		return purchases;
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
