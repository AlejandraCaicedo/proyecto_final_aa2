package co.edu.uniquindio.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.TypeProduct;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("productBean")
@ApplicationScoped
public class ProductBean {

	@EJB
	private NegocioEJB negocioEJB;

	@ManagedProperty(value = "#{securityBean.user}")
	@Inject
	private User seller;

	private String code, name, description;
	private int availability;
	private double price;
	private Date limit_date;
	private TypeProduct type;
	private List<TypeProduct> listTypes;
	private List<Product> listProducts;
	private UploadedFile image;
	private boolean escogido;
	private Product selectedProduct;

	@PostConstruct
	public void inicializar() {
		this.listTypes = negocioEJB.listTypes();
		this.listProducts = negocioEJB.toListProducts();
		this.escogido = false;
	}

	public String createProduct() {

		System.out.println(escogido);
		try {
//			User seller = negocioEJB.findUser("user1@user.com");

			Product p = new Product(code, name, description, price, availability, type, limit_date, seller);

			negocioEJB.toCreateProduct(p);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New product",
					"Product created sucessfully");
			FacesContext.getCurrentInstance().addMessage(null, message);

			return "CRUDProduct?faces-redirect=true";
		} catch (RepeatedProductException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Repeated Product Exception",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
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

	public TypeProduct getType() {
		return type;
	}

	public void setType(TypeProduct type) {
		this.type = type;
	}

	public List<TypeProduct> getListTypes() {
		return listTypes;
	}

	public void setListTypes(List<TypeProduct> listTypes) {
		this.listTypes = listTypes;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public boolean getEscogido() {
		System.out.println("Holi");
		return escogido;
	}

	public void setEscogido(boolean newProduct) {
		this.escogido = newProduct;
	}

	public void isEscogido() {
		System.out.println("Holo");
		this.escogido = true;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

}
