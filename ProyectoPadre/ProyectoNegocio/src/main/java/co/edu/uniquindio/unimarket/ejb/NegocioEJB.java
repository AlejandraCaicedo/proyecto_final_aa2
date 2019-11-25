package co.edu.uniquindio.unimarket.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.uniMarket.dto.PRODUCT_INFORMATION;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.PurchaseDetail;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.TypeProduct;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.BusinessException;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundTypeProduct;
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
			throw new NotFoundAdminException("Email or password incorrect");
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

	// ----------------------------------------
	// M E T O D O S - P E R S I S T E N C I A
	// ----------------------------------------

	/**
	 * Metodo que realiza la persistencia de los comentarios
	 */
	@Override
	public void toCreateCommentary(Commentary comment) {
		User user = comment.getUser();
		Product product = comment.getProduct();

		user.getComments().add(comment);
		product.getListCommentaries().add(comment);
		toEditUser(user, user.getID());
		toEditProduct(product, product.getCode());

		entityManager.persist(comment);
	}

	/**
	 * Metodo que realiza la persistencia de la calificacion de un producto
	 */
	@Override
	public void toCreateRate(Rate rate) {
		User user = rate.getUser();
		Product product = rate.getProduct();

		user.getRates().add(rate);
		product.getRates().add(rate);
		toEditUser(user, user.getID());
		toEditProduct(product, product.getCode());

		entityManager.persist(rate);
	}

	/**
	 * Metodo que realiza la persistencia de las compras
	 */
	@Override
	public void toCreatePurchase(Purchase p) {
		User user = p.getUser();
		List<PurchaseDetail> purchaseDetails = p.getListPurchaseDetails();
		user.getListPurchases().add(p);
		for (int i = 0; i < purchaseDetails.size(); i++) {
			toCreatePurchaseDetail(purchaseDetails.get(i));
		}
		user.getListPurchases().add(p);
		toEditUser(user, user.getID());
		entityManager.persist(p);
	}

	/**
	 * Metodo que realiza la persistencia a los productos registrados
	 */
	@Override
	public void toCreateProduct(Product p) throws RepeatedProductException {

		if (entityManager.find(Product.class, p.getCode()) != null) {
			throw new RepeatedProductException("The product is already registered");
		}
		entityManager.persist(p);
	}

	/**
	 * Metodo que realiza la persistencia de los usuarios registrados en la base de
	 * datos
	 * 
	 * @throws BusinessException
	 */
	@Override
	public void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException, BusinessException {

		if (entityManager.find(User.class, u.getID()) != null) {
			throw new RepeatedIDException("The user is already registered");
		}

		if (findUser(u.getEmail()) != null) {
			throw new RepeatedEmailException("Email is already in use");
		}

		if (!validarCedula(u.getID())) {
			throw new BusinessException("La cedula ingresada no es válida\n solo debe contener números");
		}

		if (!validarNombre(u.getFullName())) {
			throw new BusinessException("El nombre ingresado no es válido\n solo debe contener letras");
		}

		if (!validarCedula(u.getCellphoneNumber())) {
			throw new BusinessException("El telefono celular ingresado no es válido\n solo debe contener números");
		}

		entityManager.persist(u);
	}

	/**
	 * Método que valida si el nombre no contiene caracteres numéricos.
	 * 
	 * @param nombre
	 * @return true || false
	 */
	private boolean validarNombre(String nombre) {
		boolean salida = true;
		char[] c = nombre.toCharArray();
		for (int i = 0; i < c.length && salida == true; i++) {
			char car = c[i];
			if (Character.isDigit(car)) {
				salida = false;
			}
		}
		return salida;
	}

	/**
	 * Método que valida si la cedula contiene solamente caracteres numéricos.
	 * 
	 * @param cc
	 * @return true || false
	 */
	private boolean validarCedula(String cc) {
		boolean salida = true;
		char[] c = cc.toCharArray();
		for (int i = 0; i < c.length && salida == true; i++) {
			char car = c[i];
			if (!Character.isDigit(car)) {
				salida = false;
			}
		}
		return salida;
	}

	/**
	 * Metodo que realiza la persistencia de los detalles de cada compra
	 */
	private void toCreatePurchaseDetail(PurchaseDetail purchaseDetail) {
		Product product = purchaseDetail.getProduct();
		product.getListPurchaseDetails().add(purchaseDetail);

		toEditProduct(product, product.getCode());
		entityManager.persist(purchaseDetail);
	}

	// --------------------------------------------------
	// M E T O D O S - A C T U A L I Z A R - E D I T A R
	// --------------------------------------------------

	/**
	 * M�todo que edita los datos de un usuario
	 * 
	 * @param user Usuario con los datos modificados
	 * @param ID   id del Usuario que se va a modificar
	 * @return usuario Editado
	 */
	public User toEditUser(User user, String ID) {

		User actual = entityManager.find(User.class, ID);
		actual.setAdress(user.getAdress());
		actual.setCellphoneNumber(user.getCellphoneNumber());
		actual.setEmail(user.getEmail());
		actual.setFullName(user.getFullName());
		actual.setID(user.getID());
		actual.setPassword(user.getPassword());
		actual.setListFavorites(user.getListFavorites());
		actual.setComments(user.getComments());

		entityManager.merge(actual);

		return entityManager.find(User.class, ID);
	}

	@Override
	public void updateUser(User user, String ID) {
		User actual = entityManager.find(User.class, ID);
		actual.setAdress(user.getAdress());
		actual.setCellphoneNumber(user.getCellphoneNumber());
		actual.setEmail(user.getEmail());
		actual.setFullName(user.getFullName());

		entityManager.merge(actual);
	}

	public Product toEditProduct(Product p, String code) {

		Product actual = entityManager.find(Product.class, code);
		actual.setAvailability(p.getAvailability());
		actual.setDescription(p.getDescription());
		actual.setLimit_Date(p.getLimit_Date());
		actual.setName(p.getName());
		actual.setPrice(p.getPrice());
		actual.setListCommentaries(p.getListCommentaries());
		actual.setListPurchaseDetails(p.getListPurchaseDetails());
		actual.setListRates(p.getRates());

		entityManager.merge(actual);
		return p;
	}

	public void toEditPurchase(Purchase purchase, String code) {
		Purchase actual = entityManager.find(Purchase.class, code);
		actual.setListPurchaseDetails(purchase.getListPurchaseDetails());
		actual.setPaymentMethod(purchase.getPaymentMethod());
		actual.setPurchaseDate(purchase.getPurchaseDate());
		actual.setUser(purchase.getUser());

		entityManager.merge(actual);
	}

	// ----------------------------------------
	// M E T O D O S - E L I M I N A R
	// ----------------------------------------

	public User toRemoveUser(String ID) {
		User user = entityManager.find(User.class, ID);
		entityManager.remove(user);

		return entityManager.find(User.class, ID);
	}

	@Override
	public void removeUser(String ID) {
		entityManager.createNamedQuery(User.DELETE_PRODUCTS).executeUpdate();
		entityManager.createNamedQuery(User.DELETE_RATES).executeUpdate();
		entityManager.createNamedQuery(User.DELETE_COMMENTARIES).executeUpdate();
		User user = entityManager.find(User.class, ID);
		entityManager.remove(user);
	}

	// --------------------------------------------------
	// M E T O D O S - E N C O N T R A R - O B T E N E R
	// --------------------------------------------------

	@Override
	public User findUser(String email) {
		TypedQuery<User> q = entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class);
		q.setParameter("email", email);
		List<User> listUsers = q.getResultList();

		if (!listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}

	@Override
	public User searchUser(String ID) {
		User user = entityManager.find(User.class, ID);
		return user;
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

	public TypeProduct findTypeProduct(int code) {

		TypeProduct tp = entityManager.find(TypeProduct.class, code);

		if (tp != null) {
			return tp;
		}

		return null;
	}

	public Product findProduct(String code) {
		Product product = entityManager.find(Product.class, code);

		if (product != null) {
			return product;
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

	@Override
	public Product searchProduct(String ID) {
		Product product = entityManager.find(Product.class, ID);
		return product;
	}

	// ----------------------------------------
	// M E T O D O S - P A R A - L I S T A R
	// ----------------------------------------

	public List<Product> toListFavorites(String ID) {
		TypedQuery<Product> favorites = entityManager.createNamedQuery(User.ALL_FAVORITES, Product.class);
		return favorites.getResultList();
	}

	@Override
	public List<User> toListSellers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.ALL_SELLING_USERS, User.class);
		return p.getResultList();
	}

	@Override
	public List<User> toListUsers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.ALL_USERS, User.class);
		return p.getResultList();
	}

	@Override
	public List<User> toListShoppers() {
		TypedQuery<User> p = entityManager.createNamedQuery(User.All_SHOPPERS_USERS, User.class);
		return p.getResultList();
	}

	public List<Product> toListProductsByType() {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.PRODUCTS_BY_TYPE, Product.class);
		return p.getResultList();
	}

	public List<Product> toListProductsByType(String name) {
		TypedQuery<Product> p = entityManager.createNamedQuery(Product.PRODUCTS_BY_GIVEN_TYPE, Product.class);
		p.setParameter("name", name);
		return p.getResultList();
	}

	@Override
	public List<Product> toListProducts() {
		TypedQuery<Product> q = entityManager.createNamedQuery(Product.ALL_PRODUCTS, Product.class);
		return q.getResultList();
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

	public Product[] listToArrayProduct(List<Product> list) {
		Product[] res = new Product[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	public Purchase[] listToArrayPurchase(List<Purchase> list) {
		Purchase[] res = new Purchase[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	@Override
	public List<TypeProduct> listTypes() {
		TypedQuery<TypeProduct> q = entityManager.createNamedQuery(TypeProduct.LIST_TYPES, TypeProduct.class);
		return q.getResultList();
	}

	@Override
	public List<Product> toListByType(String type) throws NotFoundTypeProduct {

		if (!type.equals("vacio") && !type.equals("----")) {
			if (type.equals("EXPIRED")) {
				return toListExpiredProducts();
			} else if (type.equals("NOT EXPIRED")) {
				return toListNotExpiredProducts();
			} else {
				return toListProductsByType(type);
			}
		} else {
			throw new NotFoundTypeProduct("You must select some type of product");
		}
	}

	@Override
	public Admin getAdmin() {
		TypedQuery<Admin> admin = entityManager.createNamedQuery(Admin.GET_ADMIN, Admin.class);

		return admin.getResultList().get(0);
	}

}