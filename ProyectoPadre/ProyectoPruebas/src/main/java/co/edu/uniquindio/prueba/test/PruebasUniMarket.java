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

import co.edu.uniquindio.uniMarket.entidades.Person;

@RunWith(Arquillian.class)
public class PruebasUniMarket {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo que crea el archivo de pruebas
	 * 
	 * @return archivo de cualquier tipo
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "prueba.war").addPackage(Person.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	/**
	 * Crea las tablas necesarias para la base de datos de la tienda
	 */
	@Test
	public void crearTablas() {

	}

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "rate.json" })
//	public void probarAVG_RATE() {
//
//	}
//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "purchase.json", "rate.json" })
//	public void probarAVG() {
//
//	}

}
