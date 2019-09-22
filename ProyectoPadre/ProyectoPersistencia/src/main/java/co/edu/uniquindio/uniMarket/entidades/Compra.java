package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compra
 *
 */
@Entity

@IdClass(CompraPK.class)
public class Compra implements Serializable {

	@Id
	@Column(name = "userID")
	private String userID;

	@Id
	@Column(name = "productCode")
	private String productCode;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	@Column(name = "paymentMethod")
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	private static final long serialVersionUID = 1L;

	public Compra() {
		super();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
