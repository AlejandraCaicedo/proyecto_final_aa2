package co.edu.uniquindio.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.RatePK;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("metodosBean")
@ApplicationScoped
public class MetodosBean {

	@EJB
	private NegocioEJB negocioEJB;

	@ManagedProperty("#{securityBean}")
	@Inject
	private User user;
	private List<Product> listProducts;
	private String comment;
	private double rate;

	public void addFavorite() {

		for (int i = 0; i < listProducts.size(); i++) {
			user.getListFavorites().add(listProducts.get(i));
		}
		negocioEJB.toEditUser(user, user.getID());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been added to your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void removeFavorite() {

		for (int i = 0; i < listProducts.size(); i++) {
			user.getListFavorites().remove(listProducts.get(i));
		}
		negocioEJB.toEditUser(user, user.getID());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been removed from your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void makeComment() {
		Commentary commentary = new Commentary("random", user, listProducts.get(0), comment);
		negocioEJB.toCreateCommentary(commentary);

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Comment",
				"Comment created succesfully");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	}

	public void toRate() {
		RatePK ratePK = new RatePK(listProducts.get(0).getCode(), user.getID());
		Rate rate = new Rate(ratePK, listProducts.get(0), user, this.rate);
		negocioEJB.toCreateRate(rate);

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Rate",
				"Your rate has been succesfully process");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public NegocioEJB getNegocioEJB() {
		return negocioEJB;
	}

	public void setNegocioEJB(NegocioEJB negocioEJB) {
		this.negocioEJB = negocioEJB;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
