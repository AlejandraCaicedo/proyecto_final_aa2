package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sun.security.ntlm.Client;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.PurchaseDetail;
import co.edu.uniquindio.uniMarket.entidades.Type;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
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
	public List<Product> toListAvailableProducts() {
//		TypedQuery<Product> productos = entityManager.createNamedQuery(Product.ALL_PRODUCT_AVAILABLE, Product.class);
//		productos.setParameter("fechaActual", "new Date() --- new SimpleFormat()");
//		return productos.getResultList();
		return null;
	}

	@Override
	public Person autentifyPerson(String email, String password) {

		TypedQuery<Person> p = entityManager.createNamedQuery(Person.AUTENTIFY_PERSON, Person.class);
		p.setParameter("password", password);
		p.setParameter("email", email);

		List<Person> list = p.getResultList();

		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Commentary> toListProductsComments(String codeProducto) {
		TypedQuery<Commentary> c = entityManager.createNamedQuery(Commentary.COMMENTS_PRODUCT, Commentary.class);
		c.setParameter("codeProduct", codeProducto);
		return c.getResultList();
	}

	@Override
	public void toCreateProduct(Product p) throws RepeatedProductException {

		if (entityManager.find(Product.class, p.getCode()) != null) {
			throw new RepeatedProductException("El producto ya se encuentra registrado");
		}

		entityManager.persist(p);

	}

	@Override
	public Product toEditProduct(Product p) {
		entityManager.merge(p);
		return p;
	}

	@Override
	public void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException {

		if (entityManager.find(User.class, u.getID()) != null) {
			throw new RepeatedIDException("El usuario ya se encuentra registrado");
		}

		if (findUser(u.getEmail()) != null) {
			throw new RepeatedEmailException("El email ya se encuentra en uso");
		}

		entityManager.persist(u);
	}

	@Override
	public void toLogginAdmin(String ID, String password) throws NotFoundAdminException {

		if (findAdmin(ID, password) == null) {
			throw new NotFoundAdminException("El ID o la Contrasenia son incorrectos");
		}
	}

	public List<User> toListSellers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.ALL_SELLING_USERS, User.class);
		return p.getResultList();
	}

	public List<User> toListShoppers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.All_SHOPPERS_USERS, User.class);
		return p.getResultList();
	}

	public List<User> toListUsers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.ALL_USERS, User.class);
		return p.getResultList();
	}

	public List<Product> toListProductsByType() {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.PRODUCTS_BY_TYPE, Product.class);
		return p.getResultList();
	}

	public List<Product> toListProductsByType(Type type) {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.PRODUCTS_BY_GIVEN_TYPE, Product.class);
		p.setParameter("type", type);
		return p.getResultList();
	}

	public String toGiveProductDescription(String code) {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.DESCRIPTION, Product.class);
		p.setParameter("code", code);

		return p.getResultList().get(0).getDescription();
	}

	private User findUser(String email) {
		TypedQuery<User> q = entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class);
		List<User> listUsers = q.getResultList();

		if (listUsers.isEmpty()) {
			return null;
		}

		return listUsers.get(0);
	}

	private Admin findAdmin(String ID, String password) {
		TypedQuery<Admin> p = entityManager.createNamedQuery(Admin.FIND_ADMIN, Admin.class);
		p.setParameter("ID", ID);
		p.setParameter("password", password);

		return p.getResultList().get(0);
	}

}
