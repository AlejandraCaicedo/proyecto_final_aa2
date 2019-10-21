package co.edu.uniquindio.uniMarket.dto;

import java.util.Date;

import co.edu.uniquindio.uniMarket.entidades.Type;

public class PRODUCT_INFORMATION {

	private String code;
	private String name;
	private String description;
	private double price;
	private int availability;
	private Type type;
	private Date limit_date;

	public PRODUCT_INFORMATION(String code, String name, String description, double price, int availability, Type type,
			Date limit_date) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
		this.type = type;
		this.limit_date = limit_date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(Date limit_date) {
		this.limit_date = limit_date;
	}

}
