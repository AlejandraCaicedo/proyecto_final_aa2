package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Producto
 *
 */

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Product.ALL_PRODUCTS, query = "select p from Product p"),
		@NamedQuery(name = Product.AVG_RATING, query = "select AVG(r.rate) from Product p INNER JOIN p.listRates r group by p"),
		@NamedQuery(name = Product.AVG_RATING_INCLUSIVE, query = "select AVG(r.rate) from Product p LEFT JOIN p.listRates r group by p"),
		@NamedQuery(name = Product.AVG_RATING_PRODUCT, query = "select AVG(r.rate) from Product p INNER JOIN p.listRates r where p.code =:code group by p"),
		@NamedQuery(name = Product.AVG_RATING_DTO, query = "select new co.edu.uniquindio.uniMarket.dto.AVG_RATING( avg(r.rate), p.code ) from Product p INNER JOIN p.listRates r group by p"),
		@NamedQuery(name = Product.NUMBER_TYPES_PRODUCTS, query = "select count (p) from Product p group by p.type"),
		@NamedQuery(name = Product.EMPTY_COMMENTARY, query = "select p from Product p where p.listCommentaries is empty"),
		@NamedQuery(name = Product.MOST_EXPENSIVE_PRODUCT, query = "select p from Product p where p =select MAX(p.price) from Product p"),
		@NamedQuery(name = Product.MOST_EXPENSIVE_PRODUCT_BY_TYPE, query = "select MAX(p.price) from Product p group by p.type"),
		@NamedQuery(name = Product.ALL_PRODUCT_AVAILABLE, query = "select p from Product p where p.availability>0 and p.limit_Date >= :fechaActual"),
		@NamedQuery(name = Product.PRODUCTS_BY_TYPE, query = "select p from Product p group by p.type"),
		@NamedQuery(name = Product.INFORMATION, query = "select new co.edu.uniquindio.uniMarket.dto.PRODUCT_INFORMATION(p.code, p.name, p.description, p.price, p.availability, p.type, p.limit_Date) from Product p where p.code=:code"),
		@NamedQuery(name = Product.PRODUCTS_BY_GIVEN_TYPE, query = "select p from Product p where p.type =:type"),
		@NamedQuery(name = Product.EXPIRED_PRODUCTS, query = "select p from Product p where p.limit_Date < CURRENT_DATE"),
		@NamedQuery(name = Product.NOT_EXPIRED_PRODUCTS, query = "select p from Product p where p.limit_Date > CURRENT_DATE") })
public class Product implements Serializable {

	@Id
	@Column(name = "code", length = 10, nullable = false)
	private String code; // Codigo que tendra un producto especifico, no puede ser uin campo nulo

	@Column(name = "name", length = 20, nullable = false)
	private String name; // Nombre que recibe un producto

	@Column(name = "description", length = 100, nullable = true)
	private String description; // Descripcion proveida sobre un producto en particular

	@Column(name = "price")
	private double price; // Precio que tiene el producto

	@Column(name = "availability", nullable = false)
	private int availability; // Cantidad existente de un producto

	@ManyToOne
	private TypeProduct type; // Clasificacion del producto

	@Temporal(TemporalType.TIMESTAMP)
	private Date limit_Date; // Fecha limite para la que puede estar un producto en UniMarket

	@ElementCollection
	private List<String> images; // litsa de imagenes que puede existir sobre un producto

	@OneToMany(mappedBy = "product")
	private List<Rate> listRates; // Es la lista de calificaciones que le pueden dar ciertos usuarios a un
									// producto

	@OneToMany(mappedBy = "product")
	private List<Commentary> listCommentaries;

	@OneToMany
	private List<PurchaseDetail> listPurchaseDetails; // Lista de detalles de compra sobre un producto

	@ManyToOne
	private User user; // Usuario que ha publicado el producto

	// Query que retorna todas las calificaciones de un producto
	public static final String ALL_PRODUCT_RATINGS = "TODAS_CALIFICACIONES_PRODUCTO";

	// Query que retorna todos los productos en UniMarket
	public static final String ALL_PRODUCTS = "ALL_PRODUCTS";

	public static final String ALL_PRODUCT_AVAILABLE = "ALL_PRODUCT_AVAILABLE";

	// Query que retorna el rating promedio de cada producto
	public static final String AVG_RATING = "AVG_RATING";

	// Query que retorna el rating promedio de cada producto incluyendo aquellos que
	// no tienen rating
	public static final String AVG_RATING_INCLUSIVE = "AVG_RATING_INCLUSIVE";

	// Query que retorna el rating promedio de un producto al especificar su codigo
	public static final String AVG_RATING_PRODUCT = "AVG_RATING_PRODUCT";

	// query que retorna un dto
	public static final String AVG_RATING_DTO = "AVG_RATING_DTO";

	// Query que retorna el numero de productos que hay por categoría (Type)
	public static final String NUMBER_TYPES_PRODUCTS = "NUMBER_TYPES_PRODUCTS";

	// Query que retorna los productos que no tienen comentarios
	public static final String EMPTY_COMMENTARY = "EMPTY_COMMENTARY";

	// Query que retorna el producto mas costoso del uniMarket
	public static final String MOST_EXPENSIVE_PRODUCT = "MOST_EXPENSIVE_PRODUCT";

	// Query que retorna el producto mas costoso por tipo
	public static final String MOST_EXPENSIVE_PRODUCT_BY_TYPE = "MOST_EXPENSIVE_PRODUCT_BY_TYPE";

	// Query que retorna los productos seg�n su tipo
	public static final String PRODUCTS_BY_TYPE = "PRODUCTS_BY_TYPE";

	// Query que retorna una lista de productos dato el tipo de estos.
	public static final String PRODUCTS_BY_GIVEN_TYPE = "PRODUCTS_BY_GIVEN_TYPE";

	// Query que retorna la informacion de un producto dado su codigo
	public static final String INFORMATION = "INFORMATION";

	// Query que retorna los productos vencidos
	public static final String EXPIRED_PRODUCTS = "EXPIRED_PRODUCTS";

	// Query que retorna los productos que aun no han expirado
	public static final String NOT_EXPIRED_PRODUCTS = "NOT_EXPIRED_PRODUCTS";

	public static final String SEARCH_PRODUCT = "SEARCH_PRODUCT";

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase producto
	 */
	public Product() {
		super();
	}

	/**
	 * Constructor del producto con los campos que se van a rellenar para crear
	 * alguno
	 * 
	 * @param name,         nombre del producto a ser agregado
	 * @param description,  descripcion proveida sobre el producto
	 * @param price,        precio que tendra el producto en la tienda
	 * @param code,         codigo que identificara cada producto, no se puede
	 *                      repetir
	 * @param availability, disponibilidad de un producto
	 * @param type,         Clasificacion del producto
	 * @param limit_Date,   fecha limite hasta la que un producto se va a encontrar
	 *                      publicado en la tienda
	 */
	public Product(String code, String name, String description, double price, int availability, TypeProduct type,
			Date limit_Date) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
		this.type = type;
		this.limit_Date = limit_Date;
	}

	/**
	 * Metodo para obtener un nomnbre de un producto
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite asignar un nombre a un producto
	 * 
	 * @param name, nombre que se le va a asignar al producto
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo para obtener la descripcion de un producto
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metodo para asignar una descripcion a un producto especifico
	 * 
	 * @param description, es la descripcion que va a ser asignada a un producto
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metodo para obtener el precio de un producto creado
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metodo para asignar un precio a in producto
	 * 
	 * @param price, precio que va a tener el producto creado
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metodo para obtener la lista de imagenes que va a tener un producto en
	 * especfico
	 * 
	 * @return images
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * Metodo para poner un listado de imagenes a un producto
	 * 
	 * @param images, imagenes a ser publicada sobre un producto
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}

	/**
	 * Metodo para obtener el codigo de un producto creado
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Metodo para poner un codigo a un producto
	 * 
	 * @param code, codigo que va a ser asignado al producto creado
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Metodo para obtener el codigo de un producto
	 * 
	 * @return availability
	 */
	public int getAvailability() {
		return availability;
	}

	/**
	 * Metodo para asignar la cantidad existente de un producto
	 * 
	 * @param availability, cantidad de productos disponibles
	 */
	public void setAvailability(int availability) {
		this.availability = availability;
	}

	/**
	 * Metodo para obtener la fecha limite de publicacion de un producto en la
	 * tienda
	 * 
	 * @return limit_Date
	 */
	public Date getLimit_Date() {
		return limit_Date;
	}

	/**
	 * Metodo para poner una fecha limite a un producto
	 * 
	 * @param limit_Date, fecha limite de publicacion de un producto
	 */
	public void setLimit_Date(Date limit_Date) {
		this.limit_Date = limit_Date;
	}

	/**
	 * Metodo para obtener el listado de calificaciones de un producto
	 * 
	 * @return rates
	 */
	public List<Rate> getRates() {
		return listRates;
	}

	/**
	 * Metodo para poner un listado de calificaciones de un producto
	 * 
	 * @param rates, es el listado de calificaciones del producto
	 */
	public void setRates(List<Rate> rates) {
		this.listRates = rates;
	}

	/**
	 * Metodo para obtener el listado de detalles de compra de un producto
	 * 
	 * @return listPurchaseDetails
	 */
	public List<PurchaseDetail> getListPurchaseDetails() {
		return listPurchaseDetails;
	}

	/**
	 * Metodo para poner un listado de detalles de compra de un producto
	 * 
	 * @param listPurchaseDetails, listado de detalles de compra de un producto
	 */
	public void setListPurchaseDetails(List<PurchaseDetail> listPurchaseDetails) {
		this.listPurchaseDetails = listPurchaseDetails;
	}

	/**
	 * Metodo que retorna el Type de un producto (Categoria)
	 * 
	 * @return El Type de un Producto
	 */
	public TypeProduct getType() {
		return type;
	}

	/**
	 * Metodo para poner un Type de un producto
	 * 
	 * @param type el Type que se ha de poner
	 */
	public void setType(TypeProduct type) {
		this.type = type;
	}

	/**
	 * Metodo que retorna el ID de un usuario
	 * 
	 * @return el ID de un Usuario
	 */
	public String getUserID() {
		return user.getID();
	}

	public void setListRates(List<Rate> listRates) {
		this.listRates = listRates;
	}

	public void setListCommentaries(List<Commentary> listCommentaries) {
		this.listCommentaries = listCommentaries;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Metodo que asigna una forma standar a la hora de mostrar la informacion sobre
	 * un producto
	 */
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", availability=" + availability + ", type=" + type + ", limit_Date=" + limit_Date + ", images="
				+ images + ", user=" + user + "]";
	}

	/**
	 * Metodo hashCode para los productos
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availability;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((limit_Date == null) ? 0 : limit_Date.hashCode());
		result = prime * result + ((listPurchaseDetails == null) ? 0 : listPurchaseDetails.hashCode());
		result = prime * result + ((listRates == null) ? 0 : listRates.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Metodo que permite comprar dos producto a traves de su llave primaria
	 */
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
		if (listPurchaseDetails == null) {
			if (other.listPurchaseDetails != null)
				return false;
		} else if (!listPurchaseDetails.equals(other.listPurchaseDetails))
			return false;
		if (listRates == null) {
			if (other.listRates != null)
				return false;
		} else if (!listRates.equals(other.listRates))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
