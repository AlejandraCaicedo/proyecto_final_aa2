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
	private int ID;

	@ElementCollection
	private HashMap<String, Product> hmProducts;

	private Purchase purchase;

	private static final long serialVersionUID = 1L;

	public PurchaseDetail() {
		super();
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

}
