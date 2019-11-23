package co.edu.uniquindio.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.PaymentMethod;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.PurchaseDetail;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("purchaseBean")
@ApplicationScoped
public class PurchaseBean {

	@EJB
	NegocioEJB negocioEJB;

	@ManagedProperty(value = "#{securityBean.user}")
	@Inject
	private User user;

	private String purchaseCode;
	private Date purchaseDate;
	private PaymentMethod paymentMethod;
	private List<PurchaseDetail> purchaseDetail;

	/**
	 * Método que crea una nueva compra
	 */
	public void createPurchase() {

		Purchase purchase = new Purchase(purchaseCode, user, purchaseDate, paymentMethod);

		negocioEJB.toCreatePurchase(purchase);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New purchase",
				"Your purchase was processed succesfully");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Método que edita la compra actual con los nuevos valores agregados (La lista
	 * de detalles compra, pues lo demás seguirá siendo igual)
	 */
	public void editPurchase() {

		negocioEJB.toEditPurchase(new Purchase(purchaseCode, user, purchaseDate, paymentMethod), purchaseCode);
	}

	public Purchase getPurchase() {
		return new Purchase(purchaseCode, user, purchaseDate, paymentMethod);
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PurchaseDetail> getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}

}
