package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Compra
 *
 */

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Purchase.ALL_PURCHASES, query = "select p from Purchase p"),
		@NamedQuery(name = Purchase.PURCHASE_DATE, query = "select p.purchaseCode, p.paymentMethod, p.user.ID, p.user.email from Purchase p where p.purchaseDate = :purchaseDate "),
		@NamedQuery(name = Purchase.PURCHASE_DATE_DTO, query = "select new co.edu.uniquindio.uniMarket.dto.PURCHASE_DATE(p.purchaseCode,p.paymentMethod,p.user.ID,p.user.email) from Purchase p where p.purchaseDate =:purchaseDate"),
		@NamedQuery(name = Purchase.UNIQUE_PURCHASES, query = "select count(p) from Purchase p"),
		@NamedQuery(name = Purchase.PURCHASE_DATE_PAYMENT, query = "select p.listPurchaseDetails from Purchase p where p.purchaseDate between :fechaInicio and :fechaFinal and p.paymentMethod=:paymentMethod"),
		@NamedQuery(name = Purchase.USER_PURCHASES, query = "select p, d from Purchase p INNER JOIN p.listPurchaseDetails d where p.user.ID =:ID") })
public class Purchase implements Serializable {

	@Id
	@Column(name = "purchaseCode")
	private String purchaseCode; // Codigo asignado a una compra

	private Date purchaseDate; // Fecha en la que se realiza dicha compra

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod; // Enumeracion que corresponde al metodo de pago

	@ManyToOne
	private User user; // Usuario que realiza una compra

	@OneToMany(mappedBy = "purchase")
	private List<PurchaseDetail> listPurchaseDetails; // Lista de los detalles de venta por cada venta de un producto

	private static final long serialVersionUID = 1L;

	// Query que retorna la lista de todas las compras
	public static final String ALL_PURCHASES = "ALL_PURCHASES";

	// Query que retorna los codigos, los metodos de pago, las ID y los email de los
	// usuarios que hicieron una compra en una fecha especificada
	public static final String PURCHASE_DATE = "PURCHASE_DATE";

	// Query que retorna lo mismo del query PURCHASE_DATE usando DTO
	public static final String PURCHASE_DATE_DTO = "PURCHASE_DATE_DTO";

	// Query que retorna el numero de compras unicas
	public static final String UNIQUE_PURCHASES = "UNIQUE_PURCHASES";

	// Query que retorna una lista de Detalle Compra dadas 2 fechas y un metodo de
	// pago
	public static final String PURCHASE_DATE_PAYMENT = "PURCHASE_DATE_PAYMENT";

	// Query que retorna las compras de un usuario y sus detalles de compra
	public static final String USER_PURCHASES = "USER_PURCHASES";

	/**
	 * Constructor vacio para la clase compra
	 */
	public Purchase() {
		super();
	}

	/**
	 * Constructor con los atributos para crear una compra
	 * 
	 * @param purchaseCode,  registro unico que tiene cada compra
	 * @param user,          usuario que realiza una compra en especifico
	 * @param purchaseDate,  fecha en la que el usuario tramita la compra
	 * @param paymentMethod, metodo de pago por el cual cancelara el usuario
	 */
	public Purchase(String purchaseCode, User user, Date purchaseDate, PaymentMethod paymentMethod) {
		super();
		this.purchaseCode = purchaseCode;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Metodo para obtener el codigo de una compra
	 * 
	 * @return purchaseCode
	 */
	public String getPurchaseCode() {
		return this.purchaseCode;
	}

	/**
	 * Metodo que permite asignar un codigo a una compra
	 * 
	 * @param purchaseCode, codigo de la compra que se realiza
	 */
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	/**
	 * Metodo que permite obtener el usuario que realiza una compra
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Metodo que permite asignar un usuario a una compra
	 * 
	 * @param user, es el usuario que realiza una compra
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Metodo que permite obtener una fecha de una compra
	 * 
	 * @return purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Metodo que permite poner un valor sobre la fecha de una compra
	 * 
	 * @param purchaseDate, fecha en que se tramita una compra
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Metodo que permite listar todos los detalles de una compra
	 * 
	 * @param listPurchaseDetails, es el listado de detalles de compra
	 */
	public void setListPurchaseDetails(List<PurchaseDetail> listPurchaseDetails) {
		this.listPurchaseDetails = listPurchaseDetails;
	}

	/**
	 * Metodo que obtiene el metodo de pago con el que se tramito una compra
	 * 
	 * @return paymentMethod
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Metodo que permite poner un valor a un metodo de pago
	 * 
	 * @param paymentMethod, es el metodo con el que se efectua dicha compra
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Metodo que permite obtener el listado de los detalles de una compra
	 * 
	 * @return listPurchaseDetails
	 */
	public List<PurchaseDetail> getListPurchaseDetails() {
		return listPurchaseDetails;
	}

	/**
	 * Metodo hashCode para una compra
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listPurchaseDetails == null) ? 0 : listPurchaseDetails.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((purchaseCode == null) ? 0 : purchaseCode.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Metodo que permite comparar a traves de una llave primaria si 2 compras son
	 * iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (listPurchaseDetails == null) {
			if (other.listPurchaseDetails != null)
				return false;
		} else if (!listPurchaseDetails.equals(other.listPurchaseDetails))
			return false;
		if (paymentMethod != other.paymentMethod)
			return false;
		if (purchaseCode == null) {
			if (other.purchaseCode != null)
				return false;
		} else if (!purchaseCode.equals(other.purchaseCode))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/**
	 * Metodo que asigna una forma standar a la hora de buscar la informacion sobre
	 * una compra
	 */
	@Override
	public String toString() {
		return "Purchase [purchaseCode=" + purchaseCode + ", user=" + user.getFullName() + ", purchaseDate="
				+ purchaseDate + ", paymentMethod=" + paymentMethod.toString();
	}

}
