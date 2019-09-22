package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Calificacion
 *
 */
@Entity

@IdClass(CalificacionPK.class)
public class Calificacion implements Serializable {

	@Id
	@Column(name = "productCode")
	private String productCode;
	@Id
	@Column(name = "userID")
	private String userID;

	@Column(name = "rate")
	private double rate;
	private static final long serialVersionUID = 1L;

	public Calificacion() {
		super();
	}

	public Calificacion(String productCode, String userID, double rate) {
		super();
		this.productCode = productCode;
		this.userID = userID;
		this.rate = rate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
