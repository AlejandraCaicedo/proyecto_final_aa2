package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sun.security.ntlm.Client;

import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;

/**
 * Session Bean implementation class PruebaEJB
 */
@Stateless
@LocalBean
public class NegocioEJB implements NegocioEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public NegocioEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> listarProductosDisponibles() {
//		TypedQuery<Product> productos = entityManager.createNamedQuery(Product.ALL_PRODUCT_AVAILABLE, Product.class);
//		productos.setParameter("fechaActual", "new Date() --- new SimpleFormat()");
//		return productos.getResultList();
		return null;
	}

	@Override
	public Person autenticarPerson(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commentary> listarComentariosProducto(String codeProducto) {
		TypedQuery<Commentary> c = entityManager.createNamedQuery(Commentary.COMMENTS_PRODUCT, Commentary.class);
		c.setParameter("codeProduct", codeProducto);
		return c.getResultList();
	}

	@Override
	public void crearProducto(Product p) throws RepeatedProductException {

		if (entityManager.find(Product.class, p.getCode()) != null) {
			throw new RepeatedProductException("El producto ya se encuentra registrado");
		}

		entityManager.persist(p);

	}

	@Override
	public Product editarProduct(Product p) {
		entityManager.merge(p);
		return p;
	}

	@Override
	public void registrarUsuario(User u) throws RepeatedIDException, RepeatedEmailException {

		if (entityManager.find(User.class, u.getID()) != null) {
			throw new RepeatedIDException("El usuario ya se encuentra registrado");
		}

		if (findUser(u.getEmail()) != null) {
			throw new RepeatedEmailException("El email ya se encuentra en uso");
		}

		entityManager.persist(u);
	}

	private User findUser(String email) {

//		TypedQuery<User> q = entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class);
//		List<User> listUsers = q.getResultList();
//
//		if (listUsers.isEmpty()) {
//			return null;
//		}
//
//		return listUsers.get(0);
		return null;
	}

}
