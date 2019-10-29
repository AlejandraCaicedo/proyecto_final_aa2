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

public class EscritorioDelegado implements NegocioEJBRemote {

	private NegocioEJBRemote negocioEJB;
	public static EscritorioDelegado escritorioDelegado = instancia();

	private static EscritorioDelegado instancia() {
		if (escritorioDelegado == null) {
			escritorioDelegado = new EscritorioDelegado();
			return escritorioDelegado;
		}
		return escritorioDelegado;
	}

	private EscritorioDelegado() {
		try {
			negocioEJB = (NegocioEJBRemote) new InitialContext().lookup(NegocioEJBRemote.JDNI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User autentifyUser(String email, String password) {
		return negocioEJB.autentifyUser(email, password);
	}

	@Override
	public List<Commentary> toListProductsComments(String codeProducto) {
		return negocioEJB.toListProductsComments(codeProducto);
	}

	@Override
	public void toCreateProduct(Product p) throws RepeatedProductException {
		negocioEJB.toCreateProduct(p);
	}

	@Override
	public void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException {
		negocioEJB.toRegisterUser(u);
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

	@Override
	public Admin toLogginAdmin(String email, String password) throws NotFoundAdminException {
		return negocioEJB.toLogginAdmin(email, password);
	}

	@Override
	public List<User> toListSellers() {
		return negocioEJB.toListSellers();
	}

	@Override
	public List<User> toListShoppers() {
		return negocioEJB.toListShoppers();
	}

	@Override
	public User searchUser(String ID) {
		return negocioEJB.searchUser(ID);
	}

	@Override
	public void removeUser(String ID) {
		negocioEJB.removeUser(ID);
	}

	@Override
	public void updateUser(User user, String ID) {
		negocioEJB.updateUser(user, ID);
	}

	@Override
	public List<Product> toListByType(String type) {
		return negocioEJB.toListByType(type);
	}

	@Override
	public Product searchProduct(String ID) {
		return negocioEJB.searchProduct(ID);
	}
}
