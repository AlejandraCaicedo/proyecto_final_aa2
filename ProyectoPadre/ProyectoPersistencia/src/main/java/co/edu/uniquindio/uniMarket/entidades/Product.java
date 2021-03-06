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

	@ElementCollection
	@Column(name = "producto_IMAGES")
	private HashMap<String, String> images;

	@Id
	@Column(name = "code", length = 10, nullable = false)
	private String code;

	@Column(name = "availability", nullable = false)
	private int availability;

	@Temporal(TemporalType.TIMESTAMP)
	private Date limit_Date;

	@OneToMany(mappedBy = "product")
	private List<Rate> rates;

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

	public HashMap<String, String> getImages() {
		return images;
	}

	public void setImages(HashMap<String, String> images) {
		this.images = images;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availability;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((limit_Date == null) ? 0 : limit_Date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
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
		Product other = (Product) obj;
		if (availability != other.availability)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (limit_Date == null) {
			if (other.limit_Date != null)
				return false;
		} else if (!limit_Date.equals(other.limit_Date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [name=" + name + ", description=" + description + ", price=" + price + ", code=" + code
				+ ", availability=" + availability + ", limit_Date=" + limit_Date + "]";
	}

}
