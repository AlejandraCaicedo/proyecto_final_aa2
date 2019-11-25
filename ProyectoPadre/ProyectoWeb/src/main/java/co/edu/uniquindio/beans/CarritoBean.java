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
public class CarritoBean {

	@EJB
	private NegocioEJB negocioEJB;

	@ManagedProperty(value = "#{securityBean.user}")
	@Inject
	private User user;

	// - - - - - Valores Pertenecientes a Purchase - - - - - -
	// Este codigo se actualiza cada ves que se agrega un nuevo producto al carrito
	private String productCode;
	private String purchaseCode;
	private Date purchaseDate;
	private PaymentMethod paymentMethod;
	private List<PurchaseDetail> listPurchaseDetail;

	// - - - - - Valores Pertenecientes a PurchaseDetail - - - - - -

	// Este ID debe ser igual que el de TyeProduct, se debe ir generando solo
	private int ID;
	private int quantity;
	private double price;
	private Product product;
	private Purchase purchase;

	/**
	 * Metodo que crea una nueva compra, se llama cuando se desea confirmar
	 * definitivamente la compra
	 */
	public void createPurchase() {

		addProduct();
		negocioEJB.toCreatePurchase(purchase);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New purchase",
				"Your purchase was processed succesfully");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Crea el detail de un Purchase, se llama cada vez que se agrega un producto al
	 * carrito
	 */
	private void addProduct() {
		PurchaseDetail purchaseDetail = new PurchaseDetail(ID, quantity, price);
		product = negocioEJB.findProduct(productCode);
		purchaseDetail.setProduct(product);
		if (listPurchaseDetail.isEmpty()) {
			Purchase newPurchase = new Purchase(purchaseCode, user, purchaseDate, paymentMethod);
			purchaseDetail.setPurchase(newPurchase);
		} else {
			purchaseDetail.setPurchase(purchase);
		}
		listPurchaseDetail.add(purchaseDetail);
		purchase.setListPurchaseDetails(listPurchaseDetail);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New Product",
				"Your product has been added to the cart");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Metodo que edita la compra actual con los nuevos valores agregados (La lista
	 * de detalles compra, pues lo demas seguira siendo igual)
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
		return listPurchaseDetail;
	}

	public void setPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
		this.listPurchaseDetail = purchaseDetail;
	}

	public NegocioEJB getNegocioEJB() {
		return negocioEJB;
	}

	public void setNegocioEJB(NegocioEJB negocioEJB) {
		this.negocioEJB = negocioEJB;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}
