package co.edu.uniquindio.uniMarket.dto;

public class PUBLISHED_PRODUCTS {

	private String userID;
	private String email;
	private int totalRegistros;

	public PUBLISHED_PRODUCTS(String userID, String email, int totalRegistros) {
		super();
		this.userID = userID;
		this.email = email;
		this.totalRegistros = totalRegistros;
	}

}
