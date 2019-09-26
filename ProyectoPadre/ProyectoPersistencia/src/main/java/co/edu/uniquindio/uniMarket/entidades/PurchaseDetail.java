package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: detalleCompra
 *
 */

/**
 * 
 * @author Juan David Ariza
 * @author Alejandra Caicedo Chaves
 * @author Alejandro Gutierrez Velez
 * 
 */

@Entity
public class PurchaseDetail implements Serializable {

	@Id
	@Column(name = "ID", nullable = false)
	private int ID; //Identificado unico del detalle de compre

	@ManyToOne
	private Product product; //Producto del cual se da un detalle de compra

	@ManyToOne
	private Purchase purchase; //Compra realizada con anterioridad

	@Column(name = "quantity", nullable = false)
	private int quantity; //Cantidad de productos adquiridos

	@Column(name = "price", nullable = false)
	private double price; //Precio por el que se hizo la compra total

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase detalle de compra
	 */
	public PurchaseDetail() {
		super();
	}

	/**
	 * Constructor con los campos asignados para el detalle de una compra
	 * @param iD, identificador unico del detalle de compra
	 * @param quantity, cantidad de productos comprados con anterioridad
	 * @param price, precio por el que se adquiere los productos a la hora de comprarlos
	 */
	public PurchaseDetail(int iD, int quantity, int price) {
		super();
		ID = iD;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Metodo que permite obtener la identificacion de un detalle de compra
	 * @return ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Metodo que permite asignar un valor de idetnficacion de un detalle de compra
	 * @param ID, identificador unico de un detalle de compra
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Metodo con el que se obtiene el producto comprado
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metodo que permite asignar un producto que ha sido comprado
	 * @param product, producto que ha sido comprado con anterioridad y sobre el cual se va a mostrar mas a detalle su compra
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metodo que permite obtener una compra realizada
	 * @return purchase
	 */
	public Purchase getPurchase() {
		return purchase;
	}

	/**
	 * Metodo que permite asignar una compra realizada con anterioridad
	 * @param purchase, compra que ha sido realizada con anterioridad
	 */
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	/**
	 * Metodo que permite obtener la cantidad de productos comprados anteriormente
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metodo que permite asignar una cantidad de productos comprados a la hora de ser vendidos
	 * @param quantity, cantidad de productos comprados
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Metodo que permite obtener un precio de compra
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metodo que permite poner un valor de precio a una ocmpra realizada
	 * @param price, precio con el que se adquirio el producto
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metodo hashCode para la clase detalle de compra
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + quantity;
		return result;
	}

	/**
	 * Metodo que permite comparar dos detalles de compra y saber si son o no iguales
	 */
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
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
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

	/**
	 * Metodo que da una forma standar a la hora de mostrar la informacion de un detalle de compra
	 */
	@Override
	public String toString() {
		return "PurchaseDetail [ID=" + ID + ", purchase=" + purchase.getPurchaseCode() + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
}
