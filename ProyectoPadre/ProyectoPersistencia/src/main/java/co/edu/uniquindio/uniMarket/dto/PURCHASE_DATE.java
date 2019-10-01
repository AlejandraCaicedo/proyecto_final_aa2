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

}
