package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.Remote;

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

@Remote
public interface NegocioEJBRemote {

	String JDNI = "java:global/ProyectoEAR/ProyectoNegocio/NegocioEJB!co.edu.uniquindio.unimarket.ejb.NegocioEJBRemote";

	User autentifyUser(String email, String password);

	List<Commentary> toListProductsComments(String codeProducto);

	void toCreateProduct(Product p) throws RepeatedProductException;

	void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException;

	void toCreateCommentary(Commentary c);

	void toCreatePurchase(Purchase p);

	void toCreateRate(Rate r);

	Admin toLogginAdmin(String email, String password) throws NotFoundAdminException;

//	Product toEditProduct(Product p, String code);

}
