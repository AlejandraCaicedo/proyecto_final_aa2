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
import co.edu.uniquindio.uniMarket.entidades.RatePK;
import co.edu.uniquindio.uniMarket.entidades.User;

/**
 * 
 * @author Juan David Ariza Saavedra
 * @author Maria Alejandra Caicedo Chaves
 * 
 */

@RunWith(Arquillian.class)
public class ModeloTest {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo que crea el archivo de pruebas
	 * 
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

//	/**
//	 * Metodo que realiza la persistencia al administrador
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaAdmin() {
//		Admin prueba = new Admin();
//
//		prueba.setID("0000");
//		prueba.setFullName("Carlos");
//		prueba.setAdress("adress");
//		prueba.setCellphoneNumber("3154748461");
//		prueba.setEmail("algo@hotmail");
//		prueba.setPassword("12345");
//
//		entityManager.persist(prueba);
//		Assert.assertNotNull(prueba);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia de los comentarios
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "person.json" })
//	public void persistenciaCommentary() {
//		Product product = entityManager.find(Product.class, "CCDJDJD");
//		User user = entityManager.find(User.class, "0001");
//
//		Commentary comment = new Commentary();
//		comment.setComment("Very useful");
//		comment.setID("0000");
//		comment.setProduct(product);
//		comment.setUser(user);
//
//		entityManager.persist(comment);
//		Assert.assertNotNull(comment);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia de los usuarios registrados en la base de
//	 * datos
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaUser() {
//
//		User user = new User();
//		user.setAdress("Adress Test");
//		user.setCellphoneNumber("312456789");
//		user.setEmail("prueba@correo");
//		user.setFullName("User Prueba");
//		user.setID("1111");
//		user.setPassword("iamrobot");
//
//		entityManager.persist(user);
//		Assert.assertNotNull(user);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia a los productos registrados
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaProduct() {
//
//		Product product = new Product();
//		product.setAvailability(5);
//		product.setCode("1111");
//		product.setDescription("Description Test");
//		product.setLimit_Date("yyyy-mm-dd");
//		product.setName("Product Test");
//		product.setPrice(12345);
//
//		entityManager.persist(product);
//		Assert.assertNotNull(product);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia de las compras
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void persistenciaPurchase() {
//
//		User user = entityManager.find(User.class, "0002");
//		Purchase purchase = new Purchase();
//		purchase.setPaymentMethod(PaymentMethod.CASH);
//		purchase.setPurchaseCode("1111");
//		purchase.setPurchaseDate("yyyy-mm-dd");
//		purchase.setUser(user);
//
//		entityManager.persist(purchase);
//		Assert.assertNotNull(purchase);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia de los detalles de cada compra
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "purchase.json" })
//	public void persistenciaPurchaseDetail() {
//
//		Product product = entityManager.find(Product.class, "CCDJDJD");
//		Purchase purchase = entityManager.find(Purchase.class, "1234-ABC");
//
//		PurchaseDetail purchaseDetail = new PurchaseDetail();
//
//		purchaseDetail.setID(1);
//		purchaseDetail.setPrice(0);
//		purchaseDetail.setProduct(product);
//		purchaseDetail.setPurchase(purchase);
//		purchaseDetail.setQuantity(0);
//
//		entityManager.persist(purchaseDetail);
//		Assert.assertNotNull(purchaseDetail);
//	}
//
//	/**
//	 * Metodo que realiza la persistencia de la calificacion de un producto
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "person.json" })
//	public void persistenciaRate() {
//
//		Product product = entityManager.find(Product.class, "HHDJCN");
//		User user = entityManager.find(User.class, "0001");
//
//		Rate rate = new Rate();
//		rate.setRate(3.8);
//		rate.setProduct(product);
//		rate.setUser(user);
//
//		entityManager.persist(rate);
//		Assert.assertNotNull(rate);
//	}

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void encontrarAdmin() {
//
//		Admin admin = entityManager.find(Admin.class, "0004");
//		Assert.assertEquals("Maria Alejandra", admin.getFullName());
//	}
//
//	/**
//	 * Metodo que permite hallar un usuario
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void encontrarUser() {
//
//		User user = entityManager.find(User.class, "0001");
//		Assert.assertEquals("Juan David", user.getFullName());
//	}
//
//	/**
//	 * Metodo para encontrar un comentario
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "commentary.json", "product.json" })
//	public void encontrarCommentary() {
//
//		Commentary comment = entityManager.find(Commentary.class, "00000112");
//		Assert.assertEquals("CCDJDJD", comment.getProduct().getCode());
//	}
//
//	/**
//	 * Metodo que permite buscar un producto
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json" })
//	public void encontrarProduct() {
//
//		Product product = entityManager.find(Product.class, "YYFUIWNN");
//		Assert.assertEquals("The divine comedy", product.getName());
//	}
//
//	/**
//	 * Metodo que permite encontrar una compra
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchase.json", "person.json" })
//	public void encontrarPurchase() {
//
//		Purchase purchase = entityManager.find(Purchase.class, "1235-ABD");
//		Assert.assertEquals("0001", purchase.getUser().getID());
//	}
//
//	/**
//	 * Metodo que permite hallar un detalle de compra especifico
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchasedetail.json", "product.json" })
//	public void encontrarPurchaseDetail() {
//
//		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, 3);
//		Assert.assertEquals("YYFUIWNN", purchaseDetail.getProduct().getCode());
//	}
//
//	/**
//	 * Metodo que permite encontrar una calificacion
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "rate.json" })
//	public void encontrarRate() {
//		RatePK llave = new RatePK();
//		llave.setUser("0001");
//		llave.setProduct("CCDJDJD");
//
//		Rate rate = entityManager.find(Rate.class, llave);
//		Assert.assertEquals(new Double(3.4), new Double(rate.getRate()));
//	}
//
//	/**
//	 * Metodo para realizar la actualizacion de un administrador
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void actualizarAdmin() {
//
//		Admin admin = entityManager.find(Admin.class, "0005");
//		admin.setPassword("Alajasadamavadasa");
//
//		entityManager.merge(admin);
//
//		Admin actualAdmin = entityManager.find(Admin.class, "0005");
//		Assert.assertEquals("Alajasadamavadasa", actualAdmin.getPassword());
//	}
//
//	/**
//	 * Metodo que permite actualizar un usuario
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void actualizarUser() {
//
//		User user = entityManager.find(User.class, "0002");
//		user.setFullName("Caicedo");
//
//		entityManager.merge(user);
//
//		User actualUser = entityManager.find(User.class, "0002");
//		Assert.assertEquals("Caicedo", actualUser.getFullName());
//	}
//
//	/**
//	 * Metodo que permite actualizar un comentario
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "commentary.json" })
//	public void actualizarCommentary() {
//
//		Commentary commentary = entityManager.find(Commentary.class, "000000114");
//		commentary.setComment("He sido editado");
//
//		entityManager.merge(commentary);
//
//		Commentary actualCommentary = entityManager.find(Commentary.class, "000000114");
//		Assert.assertEquals("He sido editado", actualCommentary.getComment());
//	}
//
//	/**
//	 * Metodo que permite actualizar un producto
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json" })
//	public void actualizarProduct() {
//
//		Product product = entityManager.find(Product.class, "HHDJCN");
//		product.setAvailability(1);
//
//		entityManager.merge(product);
//
//		Product actualProduct = entityManager.find(Product.class, "HHDJCN");
//		Assert.assertEquals(1, actualProduct.getAvailability());
//	}
//
//	/**
//	 * Metodo que permite actualizar una compra
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchase.json" })
//	public void actualizarPurchase() {
//
//		Purchase purchase = entityManager.find(Purchase.class, "1237-ABF");
//		purchase.setPurchaseDate("2019-02-13");
//
//		entityManager.merge(purchase);
//
//		Purchase actualPurchase = entityManager.find(Purchase.class, "1237-ABF");
//		Assert.assertEquals("2019-02-13", actualPurchase.getPurchaseDate());
//	}
//
//	/**
//	 * Metodo que permite actualizar un detalle de compra
//	 */
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "purchasedetail.json" })
//	public void actualizarPurchaseDetail() {
//
//		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, 1);
//		purchaseDetail.setPrice(1300);
//
//		entityManager.merge(purchaseDetail);
//
//		PurchaseDetail actualPurchaseDetail = entityManager.find(PurchaseDetail.class, 1);
//		Assert.assertEquals(new Double(1300), new Double(actualPurchaseDetail.getPrice()));
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void removeAdmin() {
//		Admin admin = entityManager.find(Admin.class, "0003");
//		entityManager.remove(admin);
//
//		Admin actualAdmin = entityManager.find(Admin.class, "0003");
//		Assert.assertNull(actualAdmin);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "commentary.json" })
//	public void removeCommentary() {
//		Commentary commentary = entityManager.find(Commentary.class, "00000112");
//		entityManager.remove(commentary);
//
//		Commentary actualCommentary = entityManager.find(Commentary.class, "00000112");
//		Assert.assertNull(actualCommentary);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json" })
//	public void removeProduct() {
//		Product product = entityManager.find(Product.class, "HHDJCN");
//		entityManager.remove(product);
//
//		Product actualProduct = entityManager.find(Product.class, "HHDJCN");
//		Assert.assertNull(actualProduct);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchase.json" })
//	public void removePurchase() {
//		Purchase purchase = entityManager.find(Purchase.class, "1236-ABE");
//		entityManager.remove(purchase);
//
//		Purchase actualPurchase = entityManager.find(Purchase.class, "1236-ABE");
//		Assert.assertNull(actualPurchase);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchasedetail.json" })
//	public void removePurchaseDetail() {
//		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, 1);
//		entityManager.remove(purchaseDetail);
//
//		PurchaseDetail actualPurchaseDetail = entityManager.find(PurchaseDetail.class, 1);
//		Assert.assertNull(actualPurchaseDetail);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "rate.json" })
//	public void removeRate() {
//		RatePK ratePK = new RatePK();
//		ratePK.setProduct("CCDJDJD");
//		ratePK.setUser("0001");
//
//		Rate rate = entityManager.find(Rate.class, ratePK);
//		entityManager.remove(rate);
//
//		Rate actualRate = entityManager.find(Rate.class, ratePK);
//		Assert.assertNull(actualRate);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void removeUser() {
//
//		User user = entityManager.find(User.class, "0001");
//		entityManager.remove(user);
//
//		User actualUser = entityManager.find(User.class, "0001");
//		Assert.assertNull(actualUser);
//	}

}
