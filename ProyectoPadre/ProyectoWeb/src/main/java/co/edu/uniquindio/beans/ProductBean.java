package co.edu.uniquindio.beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Type;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("productBean")
@ApplicationScoped
public class ProductBean {

	@EJB
	private NegocioEJB negocioEJB;

	private String code, name, description;
	private int availability;
	private double price;
	private Date limit_date;
	private Type type;

	public String createProduct() {

		try {
			User seller = negocioEJB.findUser("user1@user.com");

			Product p = new Product(code, name, description, price, availability, type, limit_date);
			p.setUser(seller);

			negocioEJB.toCreateProduct(p);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New product",
					"Product created sucessfully");
			FacesContext.getCurrentInstance().addMessage(null, message);

			return "CRUDProduct";
		} catch (RepeatedProductException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Product Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public Type[] getListTypes() {
		return Type.values();
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

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(Date limit_date) {
		this.limit_date = limit_date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
