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
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;

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

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	public void probarPersistenciaPersoDatena() {
//
//		Person personaPrueba = new Person();
//		personaPrueba.setID;("12345");
//		personaPrueba.setF;("Alejandra");
//		personaPrueba.setApellido("Caicedo");
//		personaPrueba.setFechaNacimiento(new Date());
//		personaPrueba.setGenero(Genero.FEMENINO);
//
//		entityManager.persist(personaPrueba);
//
//	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaAdmin() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "user.json" })
	public void persistenciaCommentary() {
		Product product = entityManager.find(Product.class, "CCDJDJD-988992");

		// entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaProduct() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaPurchase() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaPurchaseDetail() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaRate() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void persistenciaUser() {
		Admin prueba = new Admin("0000", "Admin 1.0", "contrasena");

		entityManager.persist(prueba);
	}

	@Test
	@UsingDataSet({ "marca.json", "vehiculo.json" })
	@Transactional(value = TransactionMode.ROLLBACK)
	public void probarAlgo() {

		Vehiculo v = entityManager.find(Vehiculo.class, "7862");

		Assert.assertEquals("cafe bro", v.getColor());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "marca.json", "vehiculo.json" })
	public void probarLlaveCompuesta() {

		PuntoPK ppk = new PuntoPK();
		ppk.setLatitud(1.4563);
		ppk.setLongitud(5.36);

		Punto p = entityManager.find(Punto.class, ppk);

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "marca.json", "vehiculo.json" })
	public void probarEliminacionVehiculo() {

		Vehiculo v = entityManager.find(Vehiculo.class, "7813");

		entityManager.remove(v);

		Vehiculo borrado = entityManager.find(Vehiculo.class, "7813");

		Assert.assertNull(borrado);

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "marca.json", "vehiculo.json" })
	public void probarActualizarVehiculo() {

		Vehiculo v = entityManager.find(Vehiculo.class, "7813");
		v.setColor("VERDE");

		entityManager.merge(v);

		Vehiculo registrado = entityManager.find(Vehiculo.class, "7813");

		Assert.assertEquals("VERDE", registrado.getColor());

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "marca.json", "vehiculo.json" })
	public void probarListaVehiculos() {

		Query q = entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS); // Nombre
		// de la variable estatica
		// Ya se realizó la consulta

		List l = q.getResultList();

		System.out.println(l); // Este print, nos va a mostrar los vehiculos que se
		// encuentra en la tabla,
		// directamente en la consola

		TypedQuery<Vehiculo> tq = entityManager.createNamedQuery(Vehiculo.TODOS_VEHICULOS_COLOR, Vehiculo.class);
		tq.setParameter("color", "AZULBLUE");

		l = tq.getResultList();

		System.out.println(l);

		// Este tipo de consulta al ser NamedQuery devuelve un object y por lo tanto
		// no
		// se pueden acceder a los datos de vehiculos, para esto podemos hacer un
		// TypedQuery.
	}

	@Test
	public void probar500() {

	}

}
