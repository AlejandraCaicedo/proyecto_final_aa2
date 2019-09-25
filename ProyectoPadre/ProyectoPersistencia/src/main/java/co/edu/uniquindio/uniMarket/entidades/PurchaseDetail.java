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

	@ManyToOne
	private Purchase purchase;

	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name = "price", nullable = false)
	private int price;

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

	public PurchaseDetail(int iD, int quantity, int price) {
		super();
		ID = iD;
		this.quantity = quantity;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((hmProducts == null) ? 0 : hmProducts.hashCode());
		result = prime * result + price;
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseDetail other = (PurchaseDetail) obj;
		if (ID != other.ID)
			return false;
		if (hmProducts == null) {
			if (other.hmProducts != null)
				return false;
		} else if (!hmProducts.equals(other.hmProducts))
			return false;
		if (price != other.price)
			return false;
		if (purchase == null) {
			if (other.purchase != null)
				return false;
		} else if (!purchase.equals(other.purchase))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseDetail [ID=" + ID + ", purchase=" + purchase.getPurchaseCode() + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
}
