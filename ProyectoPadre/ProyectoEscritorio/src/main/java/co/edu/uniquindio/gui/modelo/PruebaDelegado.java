package co.edu.uniquindio.gui.modelo;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;
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

	public Person autentifyPerson(String email, String password) {
		return negocioEJB.autentifyPerson(email, password);
	}

	public List<Product> toListAvailableProducts() {
		return negocioEJB.toListAvailableProducts();
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

	public void toLogginAdmin(String ID, String password) throws NotFoundAdminException {
		negocioEJB.toLogginAdmin(ID, password);
	}

	public Product toEditProduct(Product p) {
		return negocioEJB.toEditProduct(p);
	}

}
