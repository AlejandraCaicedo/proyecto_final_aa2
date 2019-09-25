package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Compra
 *
 */
@Entity

public class Purchase implements Serializable {

	@Id
	@Column(name = "purchaseCode")
	private String purchaseCode;

	@ManyToOne
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	@OneToMany(mappedBy = "purchase")
	private List<PurchaseDetail> listPurchaseDetails;

	private static final long serialVersionUID = 1L;

	public Purchase() {
		super();
	}

	public Purchase(String purchaseCode, User user, Date purchaseDate, PaymentMethod paymentMethod) {
		super();
		this.purchaseCode = purchaseCode;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.paymentMethod = paymentMethod;
	}

	public String getPurchaseCode() {
		return this.purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<PurchaseDetail> getListPurchaseDetails() {
		return listPurchaseDetails;
	}

	public void setListPurchaseDetails(ArrayList<PurchaseDetail> listPurchaseDetails) {
		this.listPurchaseDetails = listPurchaseDetails;
	}

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

	@Override
	public String toString() {
		return "Purchase [purchaseCode=" + purchaseCode + ", user=" + user.getFullName() + ", purchaseDate="
				+ purchaseDate + ", paymentMethod=" + paymentMethod.toString();
	}

}
