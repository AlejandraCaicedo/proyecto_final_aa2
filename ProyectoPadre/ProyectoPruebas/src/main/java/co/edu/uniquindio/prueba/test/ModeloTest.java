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

@RunWith(Arquillian.class)
public class ModeloTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "prueba.war").addPackage(Admin.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	public void crearTablas() {

	}

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

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "person.json" })
//	public void persistenciaRate() {
//		Product product = entityManager.find(Product.class, "CCDJDJD");
//		User user = entityManager.find(User.class, "1113313495");
//		RatePK ratePK = new RatePK();
//		Rate rate = new Rate(ratePK, product, user, 3.5);
//
//		entityManager.persist(rate);
//	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void encontrarAdmin() {

		Admin admin = entityManager.find(Admin.class, "0003");
		Assert.assertEquals("Maria Alejandra", admin.getFullName());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void encontrarUser() {

		User user = entityManager.find(User.class, "0001");
		Assert.assertEquals("Juan Daivd", user.getFullName());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "commentary.json" })
	public void encontrarCommentary() {

		Commentary comment = entityManager.find(Commentary.class, "00000112");
		Assert.assertEquals("CCDJDJD", comment.getProduct().getCode());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void encontrarProduct() {

		Product product = entityManager.find(Product.class, "YYFUIWNN");
		Assert.assertEquals("The divine comedy", product.getName());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "purchase.json" })
	public void encontrarPurchase() {

		Purchase purchase = entityManager.find(Purchase.class, "1235-ABD");
		Assert.assertEquals("0001", purchase.getUser().getID());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "purchasedetail.json" })
	public void encontrarPurchaseDetail() {

		PurchaseDetail purchaseDetail = entityManager.find(PurchaseDetail.class, 2238839);
		Assert.assertEquals("IIRPOR", purchaseDetail.getProduct());
	}

	@SuppressWarnings("deprecation")
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void encontrarRate() {
		Rate rate = entityManager.find(Rate.class, "a");
		Assert.assertEquals(3.7, rate.getRate());
	}

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

	@SuppressWarnings("deprecation")
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

}
