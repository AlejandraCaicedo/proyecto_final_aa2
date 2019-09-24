package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compra
 *
 */
@Entity

public class Compra implements Serializable {

	@Id
	@Column(name = "purchaseCode")
	private String purchaseCode;

	@Column(name = "user", nullable = false)
	@ManyToOne
	private Usuario user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	@OneToMany(mappedBy = "purchase")
	private ArrayList<DetalleCompra> listPurchaseDetails;

	private static final long serialVersionUID = 1L;

	public Compra() {
		super();
	}

	public String getPurchaseCode() {
		return this.purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

}
