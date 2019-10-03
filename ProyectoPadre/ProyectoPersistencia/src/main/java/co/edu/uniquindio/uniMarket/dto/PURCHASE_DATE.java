package co.edu.uniquindio.uniMarket.dto;

import co.edu.uniquindio.uniMarket.entidades.PaymentMethod;

public class PURCHASE_DATE {

	private String purchaseCode;
	private PaymentMethod paymentMethod;
	private String ID;
	private String email;

	public PURCHASE_DATE(String purchaseCode, PaymentMethod paymentMethod, String iD, String email) {
		super();
		this.purchaseCode = purchaseCode;
		this.paymentMethod = paymentMethod;
		ID = iD;
		this.email = email;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PURCHASE_DATE [purchaseCode=" + purchaseCode + ", paymentMethod=" + paymentMethod + ", ID=" + ID
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((purchaseCode == null) ? 0 : purchaseCode.hashCode());
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
		PURCHASE_DATE other = (PURCHASE_DATE) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (paymentMethod != other.paymentMethod)
			return false;
		if (purchaseCode == null) {
			if (other.purchaseCode != null)
				return false;
		} else if (!purchaseCode.equals(other.purchaseCode))
			return false;
		return true;
	}

}
