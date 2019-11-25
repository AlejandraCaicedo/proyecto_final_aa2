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

	@ManagedProperty("#{securityBean.user}")
	@Inject
	private User user;
	private String productCode;
	private String comment;
	private double rate;

	public void addFavorite() {

		Product product = negocioEJB.findProduct(productCode);
		user.getListFavorites().add(product);

		negocioEJB.toEditUser(user, user.getID());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been added to your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void removeFavorite() {

		Product product = negocioEJB.findProduct(productCode);
		user.getListFavorites().remove(product);

		negocioEJB.toEditUser(user, user.getID());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfull Action",
				"This product has been removed from your \"Favorites\" list");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void makeComment() {
		Product product = negocioEJB.findProduct(productCode);
		Commentary commentary = new Commentary("random", user, product, comment);
		negocioEJB.toCreateCommentary(commentary);

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Comment",
				"Comment created succesfully");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	}

	public void toRate() {
		Product product = negocioEJB.findProduct(productCode);
		RatePK ratePK = new RatePK(productCode, user.getID());
		Rate rate = new Rate(ratePK, product, user, this.rate);
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
