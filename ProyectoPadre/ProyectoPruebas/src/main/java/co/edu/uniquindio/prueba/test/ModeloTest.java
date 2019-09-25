package co.edu.uniquindio.prueba.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.prueba.entidades.Genero;
import co.edu.uniquindio.prueba.entidades.Persona_Prueba;
import co.edu.uniquindio.prueba.entidades.Punto;
import co.edu.uniquindio.prueba.entidades.PuntoPK;
import co.edu.uniquindio.prueba.entidades.Vehiculo;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.PaymentMethod;
import co.edu.uniquindio.uniMarket.entidades.Person;
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
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Persona_Prueba.class.getPackage()).addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void probarPersistenciaPersoDatena() {

		Persona_Prueba personaPrueba = new Persona_Prueba();
		personaPrueba.setCedula("12345");
		personaPrueba.setNombre("Alejandra");
		personaPrueba.setApellido("Caicedo");
		personaPrueba.setFechaNacimiento(new Date());
		personaPrueba.setGenero(Genero.FEMENINO);

		entityManager.persist(personaPrueba);

	}

	@Test
	public void test() {

	}

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "user.json" })
//	public void persistenciaCommentary() {
//		Product product = entityManager.find(Product.class, "CCDJDJD-988992");
//		User user = entityManager.find(User.class, "1113313495");
//
//		Commentary comment = new Commentary("0000", user, product, "I love the product, very useful");
//		entityManager.persist(comment);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void persistenciaProduct() {
//		Product product = new Product("Nevera", "Esto Congela", 1345677, "0000", new Date());
//
//		entityManager.persist(product);
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "user.json" })
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
//	@UsingDataSet({ "product.json", "user.json" })
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
