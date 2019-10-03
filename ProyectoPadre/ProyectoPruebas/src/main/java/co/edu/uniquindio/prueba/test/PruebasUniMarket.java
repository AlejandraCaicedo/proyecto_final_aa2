package co.edu.uniquindio.prueba.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;

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

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void pobrarQueryProductos() {

		TypedQuery<Product> list = entityManager.createNamedQuery(Product.ALL_PRODUCTS, Product.class);
		Assert.assertEquals(4, list.getResultList().size());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "rate.json" })
	public void pobrarAVG_RATING() {

		TypedQuery<Double> avg = entityManager.createNamedQuery(Product.AVG_RATING, Double.class);
		Assert.assertEquals(1, avg.getResultList().size());
		NumberFormat formatter = new DecimalFormat("#0.0");
		Assert.assertEquals("3,5", formatter.format(avg.getResultList().get(0)));
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "rate.json" })
	public void probarAVG_INCLUSIVE() {

		TypedQuery<Double> avg = entityManager.createNamedQuery(Product.AVG_RATING_INCLUSIVE, Double.class);
		Assert.assertEquals(4, avg.getResultList().size());

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json", "rate.json" })
	public void probarAVG_Codigo() {

		TypedQuery<Double> avg = entityManager.createNamedQuery(Product.AVG_RATING_PRODUCT, Double.class);
		avg.setParameter("code", "HHDJCN");

		Assert.assertEquals(0, avg.getResultList().size());
	}

//
//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "product.json", "rate.json" })
//	public void probarAVG_RATE() {
//
//		Query avg = entityManager.createNamedQuery(Product.AVG_RATING);
//
//		Double media = (Double) avg.getSingleResult();
//
//		Assert.assertEquals(new Double(media), new Double(3));
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
