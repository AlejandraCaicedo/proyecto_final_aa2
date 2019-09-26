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
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
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
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaAdmin() {
//		Admin prueba = new Admin();
//		prueba.setID("0000");
//		prueba.setFullName("Carlos");
//		prueba.setAdress("adress");
//		prueba.setCellphoneNumber("3154748461");
//		prueba.setEmail("algo@hotmail");
//		prueba.setPassword("12345");
//		entityManager.persist(prueba);
//	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "person.json" })
	public void persistenciaCommentary() {
		Product product = entityManager.find(Product.class, "CCDJDJD-988992");
		User user = entityManager.find(User.class, "0001");

		Commentary comment = new Commentary();
		comment.setComment("Very useful");
		comment.setID("0000");
		comment.setProduct(product);
		comment.setUser(user);

		entityManager.persist(comment);
	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaProduct() {
//		Product product = new Product("Nevera", "Esto Congela", 1345677, , a master piece on the world of literature"0000", new Date());
//
//		entityManager.persist(product);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void persistenciaPurchase() {
//		PaymentMethod paymentMethod = PaymentMethod.CASH;
//		User user = entityManager.find(User.class, "1113313495");
//		Purchase purchase = new Purchase("0000", user, new Date(), paymentMethod);
//
//		entityManager.persist(purchase);
//	}
//
//	@Test
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

	/*
	 * @Test
	 * 
	 * @UsingDataSet({ "marca.json", "vehiculo.json" })
	 * 
	 * @Transactional(value = TransactionMode.ROLLBACK) public void probarAlgo() {
	 * 
	 * Vehiculo v = entityManager.find(Vehiculo.class, "7862");
	 * 
	 * Assert.assertEquals("cafe bro", v.getColor()); }
	 * 
	 * @Test
	 * 
	 * @Transactional(value = TransactionMode.ROLLBACK)
	 * 
	 * @UsingDataSet({ "marca.json", "vehiculo.json" }) public void
	 * probarLlaveCompuesta() {
	 * 
	 * PuntoPK ppk = new PuntoPK(); ppk.setLatitud(1.4563); ppk.setLongitud(5.36);
	 * 
	 * Punto p = entityManager.find(Punto.class, ppk);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Transactional(value = TransactionMode.ROLLBACK)
	 * 
	 * @UsingDataSet({ "marca.json", "vehiculo.json" }) public void
	 * probarEliminacionVehiculo() {
	 * 
	 * Vehiculo v = entityManager.find(Vehiculo.class, "7813");
	 * 
	 * entityManager.remove(v);
	 * 
	 * Vehiculo borrado = entityManager.find(Vehiculo.class, "7813");
	 * 
	 * Assert.assertNull(borrado);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Transactional(value = TransactionMode.ROLLBACK)
	 * 
	 * @UsingDataSet({ "marca.json", "vehiculo.json" }) public void
	 * probarActualizarVehiculo() {
	 * 
	 * Vehiculo v = entityManager.find(Vehiculo.class, "7813"); v.setColor("VERDE");
	 * 
	 * entityManager.merge(v);
	 * 
	 * Vehiculo registrado = entityManager.find(Vehiculo.class, "7813");
	 * 
	 * Assert.assertEquals("VERDE", registrado.getColor());
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Transactional(value = TransactionMode.ROLLBACK)
	 * 
	 * @UsingDataSet({ "marca.json", "vehiculo.json" }) public void
	 * probarListaVehiculos() {
	 * 
	 * Query q = entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS); // Nombre
	 * // de la variable estatica // Ya se realizó la consulta
	 * 
	 * List l = q.getResultList();
	 * 
	 * System.out.println(l); // Este print, nos va a mostrar los vehiculos que se
	 * // encuentra en la tabla, // directamente en la consola
	 * 
	 * TypedQuery<Vehiculo> tq =
	 * entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS_COLOR,
	 * Vehiculo.class); tq.setParameter("color", "AZULBLUE");
	 * 
	 * l = tq.getResultList();
	 * 
	 * System.out.println(l);
	 * 
	 * // Este tipo de consulta al ser NamedQuery devuelve un object y por lo tanto
	 * // no // se pueden acceder a los datos de vehiculos, para esto podemos hacer
	 * un // TypedQuery. }
	 * 
	 * @Test public void probar500() {
	 * 
	 * }
	 */

}
