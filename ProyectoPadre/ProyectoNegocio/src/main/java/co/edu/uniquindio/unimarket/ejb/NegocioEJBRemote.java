package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;

@Remote
public interface NegocioEJBRemote {

	Person autenticarPerson(String email, String password);

	List<Product> listarProductosDisponibles();

	List<Commentary> listarComentariosProducto(String codeProducto);

	void crearProducto(Product p) throws RepeatedProductException;

	void registrarUsuario(User u) throws RepeatedIDException, RepeatedEmailException;

	Product editarProduct(Product p);

}
