package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Product implements Serializable {

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@Column(name = "description", length = 100, nullable = true)
	private String description;

	@Column(name = "price")
	private double price;

	private String imag;

	@Id
	@Column(name = "code", length = 10, nullable = false)
	private String code;

	@Column(name = "availability", nullable = false)
	private int availability;

	@Temporal(TemporalType.TIMESTAMP)
	private Date limit_Date;

	@OneToMany(mappedBy = "product")
	private List<Rate> rates;

	@OneToMany
	private List<PurchaseDetail> listPurchaseDetails;

	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}

	public Product(String name, String description, double price, String code, Date limit_Date) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.code = code;
		this.limit_Date = limit_Date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getLimit_Date() {
		return limit_Date;
	}

	public void setLimit_Date(Date limit_Date) {
		this.limit_Date = limit_Date;
	}

	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Producto [name=" + name + ", description=" + description + ", price=" + price + ", code=" + code
				+ ", availability=" + availability + ", limit_Date=" + limit_Date + "]";
	}

	public String getImag() {
		return imag;
	}

	public void setImag(String imag) {
		this.imag = imag;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<PurchaseDetail> getListPurchaseDetails() {
		return listPurchaseDetails;
	}

	public void setListPurchaseDetails(List<PurchaseDetail> listPurchaseDetails) {
		this.listPurchaseDetails = listPurchaseDetails;
	}

}
