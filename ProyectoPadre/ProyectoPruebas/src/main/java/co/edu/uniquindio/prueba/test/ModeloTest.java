package co.edu.uniquindio.prueba.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.PaymentMethod;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.PurchaseDetail;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.User;

/**
 * 
 * @author Juan David Ariza
 * @author Alejandra Caicedo Chaves
 * @author Alejandro Gutierrez Velez
 * 
 */

@SuppressWarnings("deprecation")
@RunWith(Arquillian.class)
public class ModeloTest {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo que crea el archivo de pruebas
	 * @return archivo de cualquier tipo
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "prueba.war").addPackage(Admin.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	/**
	 * Crea las tablas necesarias para la base de datos de la tienda
	 */
	@Test
	public void crearTablas() {

	}

	/**
	 * Metodo que realiza la persistencia al administrador
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaAdmin() {
		Admin prueba = new Admin();
		prueba.setID("0000");
		prueba.setFullName("Carlos");
		prueba.setAdress("adress");
		prueba.setCellphoneNumber("3154748461");
		prueba.setEmail("algo@hotmail");
		prueba.setPassword("12345");
		entityManager.persist(prueba);
	}

	/**
	 * Metodo que realiza la persistencia de los comentarios
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "person.json" })
	public void persistenciaCommentary() {
		Product product = entityManager.find(Product.class, "CCDJDJD");
		User user = entityManager.find(User.class, "0001");

		Commentary comment = new Commentary();
		comment.setComment("Very useful");
		comment.setID("0000");
		comment.setProduct(product);
		comment.setUser(user);

		entityManager.persist(comment);
	}

	/**
	 * Metodo que realiza la persistencia de los usuarios registrados en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaUser() {

		User user = new User();
		user.setAdress("Adress Test");
		user.setCellphoneNumber("312456789");
		user.setEmail("prueba@correo");
		user.setFullName("User Prueba");
		user.setID("1111");
		user.setPassword("iamrobot");

		entityManager.persist(user);
	}

	/**
	 * Metodo que realiza la persistencia a los productos registrados
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaProduct() {

		Product product = new Product();
		product.setAvailability(5);
		product.setCode("1111");
		product.setDescription("Description Test");
		product.setLimit_Date("yyyy-mm-dd");
		product.setName("Product Test");
		product.setPrice(12345);

		entityManager.persist(product);
	}

	/**
	 * Metodo que realiza la persistencia de las compras
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void persistenciaPurchase() {

		User user = entityManager.find(User.class, "0002");
		Purchase purchase = new Purchase();
		purchase.setPaymentMethod(PaymentMethod.CASH);
		purchase.setPurchaseCode("1111");
		purchase.setPurchaseDate("yyyy-mm-dd");
		purchase.setUser(user);

		entityManager.persist(purchase);
	}

	/**
	 * Metodo que realiza la persistencia de los detalles de cada compra
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "purchase.json" })
	public void persistenciaPurchaseDetail() {

		Product product = entityManager.find(Product.class, "CCDJDJD");
		Purchase purchase = entityManager.find(Purchase.class, "1234-ABC");

		PurchaseDetail purchaseDetail = new PurchaseDetail();

		purchaseDetail.setID(0);
		purchaseDetail.setPrice(0);
		purchaseDetail.setProduct(product);
		purchaseDetail.setPurchase(purchase);
		purchaseDetail.setQuantity(0);

		entityManager.persist(purchaseDetail);
	}

// @Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaPurchaseDetail() {
//		PurchaseDetail purchaseDetail = new PurchaseDetail(1, 4, 3200);
//
//		entityManager.persist(purchaseDetail);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "person.json" })
//	public void persistenciaRate() {
//		Product product = entityManager.find(Product.class, "CCDJDJD-988992");
//		User user = entityManager.find(User.class, "1113313495");
//		RatePK ratePK = new RatePK();
//		Rate rate = new Rate(ratePK, product, user, 3.5);
//
//		entityManager.persist(rate);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaUser() {
//		User user = new User("0000", "Carlos Mario", "algo@hotmail.com", "3127309219", "Algun lugar", "contrasena");
//
//		entityManager.persist(user);
//	}

//	@Test
//
//	@UsingDataSet({ "marca.json", "vehiculo.json" })
//
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void probarAlgo() {
//
//		Vehiculo v = entityManager.find(Vehiculo.class, "7862");
//
//		Assert.assertEquals("cafe bro", v.getColor());
//	}

	/**
	 * Metodo que sirve para hacer la busqueda de un administrador
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void encontrarAdmin() {

		Admin admin = entityManager.find(Admin.class, "0003");
		Assert.assertEquals("Maria Alejandra", admin.getFullName());
	}

	/**
	 * Metodo que permite hallar un usuario
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void encontrarUser() {

		User user = entityManager.find(User.class, "0001");
		Assert.assertEquals("Juan Daivd", user.getFullName());
	}

	/**
	 * Metodo para encontrar un comentario
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "commentary.json" })
	public void encontrarCommentary() {

		Commentary comment = entityManager.find(Commentary.class, "00000112");
		Assert.assertEquals("CCDJDJD", comment.getProduct().getCode());
	}

	/**
	 * Metodo que permite buscar un producto
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void encontrarProduct() {

		Product product = entityManager.find(Product.class, "YYFUIWNN");
		Assert.assertEquals("The divine comedy", product.getName());
	}

	/**
	 * Metodo que permite encontrar una compra
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "purchase.json" })
	public void encontrarPurchase() {

		Purchase purchase = entityManager.find(Purchase.class, "1235-ABD");
		Assert.assertEquals("0001", purchase.getUser().getID());
	}

	/**
	 * Metodo que permite hallar un detalle de compra especifico
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "purchasedetail.json" })
	public void encontrarPurchaseDetail() {

		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, 2238839);
		Assert.assertEquals("IIRPOR", purchaseDetail.getProduct());
	}

	/**
	 * Metodo que permite encontrar una calificacion
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void encontrarRate() {
		Rate rate = entityManager.find(Rate.class, "a");
		Assert.assertEquals(3.7, rate.getRate());
	}

	/**
	 * Metodo para realizar la actualizacion de un administrador
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void actualizarAdmin() {

		Admin admin = entityManager.find(Admin.class, "0005");
		admin.setPassword("Alajasadamavadasa");

		entityManager.merge(admin);

		Admin actualAdmin = entityManager.find(Admin.class, "0005");
		Assert.assertEquals("Alajasadamavadasa", actualAdmin.getPassword());
	}

	/**
	 * Metodo que permite actualizar un usuario
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void actualizarUser() {

		User user = entityManager.find(User.class, "0002");
		user.setFullName("Caicedo");

		entityManager.merge(user);

		User actualUser = entityManager.find(User.class, "0002");
		Assert.assertEquals("Caicedo", actualUser.getFullName());
	}

	/**
	 * Metodo que permite actualizar un comentario
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "commentary.json" })
	public void actualizarCommentary() {

		Commentary commentary = entityManager.find(Commentary.class, "000000114");
		commentary.setComment("He sido editado");

		entityManager.merge(commentary);

		Commentary actualCommentary = entityManager.find(Commentary.class, "000000114");
		Assert.assertEquals("He sido editado", actualCommentary.getComment());
	}

	/**
	 * Metodo que permite actualizar un producto
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void actualizarProduct() {

		Product product = entityManager.find(Product.class, "HHDJCN");
		product.setAvailability(1);

		entityManager.merge(product);

		Product actualProduct = entityManager.find(Product.class, "HHDJCN");
		Assert.assertEquals(1, actualProduct.getAvailability());
	}

	/**
	 * Metodo que permite actualizar una compra
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void actualizarPurchase() {

		Purchase purchase = entityManager.find(Purchase.class, "1237-ABF");
		purchase.setPurchaseDate("2019-02-13");

		entityManager.merge(purchase);

		Purchase actualPurchase = entityManager.find(Purchase.class, "HHDJCN");
		Assert.assertEquals("2019-02-13", actualPurchase.getPurchaseDate());
	}
	
	/**
	 * Metodo que permite actualizar un detalle de compra
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void actualizarPurchaseDetail() {

		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, "1237-ABF");
		purchaseDetail.setPrice(1300);

		entityManager.merge(purchaseDetail);

		PurchaseDetail actualPurchaseDetail = entityManager.find(PurchaseDetail.class, "1237-ABF");
		Assert.assertEquals(1300, actualPurchaseDetail.getPrice());
	}

//	@Test
//
//	@Transactional(value = TransactionMode.ROLLBACK)
//
//	@UsingDataSet({ "marca.json", "vehiculo.json" })
//	public void probarActualizarVehiculo() {
//
//		Vehiculo v = entityManager.find(Vehiculo.class, "7813");
//		v.setColor("VERDE");
//
//		entityManager.merge(v);
//
//		Vehiculo registrado = entityManager.find(Vehiculo.class, "7813");
//
//		Assert.assertEquals("VERDE", registrado.getColor());
//
//	}

//	@Test
//
//	@Transactional(value = TransactionMode.ROLLBACK)
//
//	@UsingDataSet({ "marca.json", "vehiculo.json" })
//	public void probarLlaveCompuesta() {
//
//		PuntoPK ppk = new PuntoPK();
//		ppk.setLatitud(1.4563);
//		ppk.setLongitud(5.36);
//
//		Punto p = entityManager.find(Punto.class, ppk);
//
//	}

//	@Test
//
//	@Transactional(value = TransactionMode.ROLLBACK)
//
//	@UsingDataSet({ "marca.json", "vehiculo.json" })
//	public void probarEliminacionVehiculo() {
//
//		Vehiculo v = entityManager.find(Vehiculo.class, "7813");
//
//		entityManager.remove(v);
//
//		Vehiculo borrado = entityManager.find(Vehiculo.class, "7813");
//
//		Assert.assertNull(borrado);
//
//	}

//	@Test
//
//	@Transactional(value = TransactionMode.ROLLBACK)
//
//	@UsingDataSet({ "marca.json", "vehiculo.json" })
//	public void probarListaVehiculos() {
//
//		Query q = entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS); // Nombre
//		// de la variable estatica // Ya se realizó la consulta
//
//		List l = q.getResultList();
//
//		System.out.println(l); // Este print, nos va a mostrar los vehiculos que se
//		// encuentra en la tabla, // directamente en la consola
//
//		TypedQuery<Vehiculo> tq = entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS_COLOR, Vehiculo.class);
//		tq.setParameter("color", "AZULBLUE");
//
//		l = tq.getResultList();
//
//		System.out.println(l);
//
//		// Este tipo de consulta al ser NamedQuery devuelve un object y por lo tanto
//		// no // se pueden acceder a los datos de vehiculos, para esto podemos hacer
//		// TypedQuery.
//	}

}
