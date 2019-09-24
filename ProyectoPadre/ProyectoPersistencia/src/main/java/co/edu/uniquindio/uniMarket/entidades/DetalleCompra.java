package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: detalleCompra
 *
 */
@Entity

public class DetalleCompra implements Serializable {

	@Id
	private int ID;

	@ElementCollection
	private HashMap<String, Producto> hmProducts;

	private Compra purchase;

	private static final long serialVersionUID = 1L;

	public DetalleCompra() {
		super();
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

}
