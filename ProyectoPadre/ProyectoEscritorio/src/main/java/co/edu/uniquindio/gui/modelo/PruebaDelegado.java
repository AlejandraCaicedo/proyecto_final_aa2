package co.edu.uniquindio.gui.modelo;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;
import co.edu.uniquindio.unimarket.ejb.NegocioEJBRemote;

public class PruebaDelegado implements NegocioEJBRemote {

	private NegocioEJBRemote negocioEJB;
	public static PruebaDelegado pruebaDelegado = instancia();

	private static PruebaDelegado instancia() {
		if (pruebaDelegado == null) {
			pruebaDelegado = new PruebaDelegado();
			return pruebaDelegado;
		}
		return pruebaDelegado;
	}

	private PruebaDelegado() {
		try {
			negocioEJB = (NegocioEJBRemote) new InitialContext().lookup(NegocioEJBRemote.JDNI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public User autentifyUser(String email, String password) {
		return negocioEJB.autentifyUser(email, password);
	}

	public List<Commentary> toListProductsComments(String codeProducto) {
		return negocioEJB.toListProductsComments(codeProducto);
	}

	public void toCreateProduct(Product p) throws RepeatedProductException {
		negocioEJB.toCreateProduct(p);
	}

	public void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException {
		negocioEJB.toRegisterUser(u);
	}

	public Admin toLogginAdmin(String email, String password) throws NotFoundAdminException {
		return negocioEJB.toLogginAdmin(email, password);
	}

//	public Product toEditProduct(Product p, String code) {
//		return negocioEJB.toEditProduct(p, code);
//	}

	public void showErrorMessage(String message) {
		negocioEJB.showErrorMessage(message);
	}

	@Override
	public void toCreateCommentary(Commentary c) {
		negocioEJB.toCreateCommentary(c);
	}

	@Override
	public void toCreatePurchase(Purchase p) {
		negocioEJB.toCreatePurchase(p);
	}

	@Override
	public void toCreateRate(Rate r) {
		negocioEJB.toCreateRate(r);
	}

}
