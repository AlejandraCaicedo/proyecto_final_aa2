package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: detalleCompra
 *
 */
@Entity

public class PurchaseDetail implements Serializable {

	@Id
	@Column(name = "ID", nullable = false)
	private int ID;

	@ElementCollection
	private HashMap<String, Product> hmProducts;

	private Purchase purchase;

	@Column(name = "quantity")
	private int quantity;

	private static final long serialVersionUID = 1L;

	public PurchaseDetail() {
		super();
	}

	public PurchaseDetail(int iD, HashMap<String, Product> hmProducts, Purchase purchase, int quantity) {
		super();
		ID = iD;
		this.hmProducts = hmProducts;
		this.purchase = purchase;
		this.quantity = quantity;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public HashMap<String, Product> getHmProducts() {
		return hmProducts;
	}

	public void setHmProducts(HashMap<String, Product> hmProducts) {
		this.hmProducts = hmProducts;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
