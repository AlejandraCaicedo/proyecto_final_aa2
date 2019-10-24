package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import co.edu.uniquindio.uniMarket.dto.PRODUCT_INFORMATION;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.PurchaseDetail;
import co.edu.uniquindio.uniMarket.entidades.Rate;
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
	public Admin toLogginAdmin(String email, String password) throws NotFoundAdminException {

		Admin admin = findAdmin(email, password);

		if (admin == null) {
			throw new NotFoundAdminException("El email o la contrasenia son incorrectos");
		} else {
			return admin;
		}
	}

	@Override
	public User autentifyUser(String email, String password) {

		TypedQuery<User> p = entityManager.createNamedQuery(User.AUTENTIFY_USER, User.class);
		p.setParameter("password", password);
		p.setParameter("email", email);

		List<User> list = p.getResultList();

		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

//	@Override
//	public List<Product> toListAvailableProducts() {
////		TypedQuery<Product> productos = entityManager.createNamedQuery(Product.ALL_PRODUCT_AVAILABLE, Product.class);
////		productos.setParameter("fechaActual", "new Date() --- new SimpleFormat()");
////		return productos.getResultList();
//		return null;
//	}

	// METODOS DE PERSISTENCIA

	/**
	 * Metodo que realiza la persistencia de los comentarios
	 */
	@Override
	public void toCreateCommentary(Commentary c) {
		entityManager.persist(c);
	}

	/**
	 * Metodo que realiza la persistencia de la calificacion de un producto
	 */
	@Override
	public void toCreateRate(Rate r) {
		entityManager.persist(r);
	}

	/**
	 * Metodo que realiza la persistencia de las compras
	 */
	@Override
	public void toCreatePurchase(Purchase p) {
		entityManager.persist(p);
	}

	/**
	 * Metodo que realiza la persistencia a los productos registrados
	 */
	@Override
	public void toCreateProduct(Product p) throws RepeatedProductException {

		if (entityManager.find(Product.class, p.getCode()) != null) {
			throw new RepeatedProductException("El producto ya se encuentra registrado");
		}
		entityManager.persist(p);
	}

	/**
	 * Metodo que realiza la persistencia de los usuarios registrados en la base de
	 * datos
	 */
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

	/**
	 * Metodo que realiza la persistencia de los detalles de cada compra
	 */
	public void persistenciaPurchaseDetail(Product product, Purchase purchase) {
		PurchaseDetail purchaseDetail = new PurchaseDetail();
		entityManager.persist(purchaseDetail);
	}

	// METODOS DE EDITAR O ACTUALIZAR

	public User toEditUser(User user, String ID) {

		User actual = entityManager.find(User.class, ID);
		actual.setAdress(user.getAdress());
		actual.setCellphoneNumber(user.getCellphoneNumber());
		actual.setEmail(user.getEmail());
		actual.setFullName(user.getFullName());
		actual.setID(user.getID());
		actual.setPassword(user.getPassword());

		entityManager.merge(actual);

		return entityManager.find(User.class, ID);
	}

//	@Override
//	public Product toEditProduct(Product p, String code) {
//
//		Product actual = entityManager.find(Product.class, code);
//		actual.setAvailability(p.getAvailability());
//		actual.setDescription(p.getDescription());
//		actual.setLimit_Date(p.getLimit_Date());
//		actual.setName(p.getName());
//		actual.setPrice(p.getPrice());
//
//		entityManager.merge(actual);
//		return p;
//	}

	// METODOS DE ELIMINAR

	public User toRemoveUser(String ID) {
		User user = entityManager.find(User.class, ID);
		entityManager.remove(user);

		return entityManager.find(User.class, ID);
	}

	// METODOS DE ENCONTRAR U OBTENER

	private User findUser(String email) {
		TypedQuery<User> q = entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class);
		q.setParameter("email", email);
		List<User> listUsers = q.getResultList();

		if (!listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}

	private Admin findAdmin(String email, String password) {
		TypedQuery<Admin> p = entityManager.createNamedQuery(Admin.FIND_ADMIN, Admin.class);
		p.setParameter("email", email);
		p.setParameter("password", password);

		if (!p.getResultList().isEmpty()) {
			return p.getResultList().get(0);
		}
		return null;
	}

	public PRODUCT_INFORMATION toGiveProductInformation(String code) {
		TypedQuery<PRODUCT_INFORMATION> p = entityManager.createNamedQuery(Product.INFORMATION,
				PRODUCT_INFORMATION.class);
		p.setParameter("code", code);

		return p.getResultList().get(0);
	}

	public User toGiveUser(String ID) {
		User user = entityManager.find(User.class, ID);
		return user;
	}

	// METODOS DE LISTAR

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

	public List<Product> toListExpiredProducts() {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.EXPIRED_PRODUCTS, Product.class);
		return p.getResultList();
	}

	public List<Product> toListNotExpiredProducts() {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.NOT_EXPIRED_PRODUCTS, Product.class);
		return p.getResultList();
	}

	public List<Commentary> toListProductsComments(String codeProducto) {
		TypedQuery<Commentary> c = entityManager.createNamedQuery(Commentary.COMMENTS_PRODUCT, Commentary.class);
		c.setParameter("codeProduct", codeProducto);
		return c.getResultList();
	}

	// OTROS

	@Override
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.WARNING_MESSAGE);
	}
}
