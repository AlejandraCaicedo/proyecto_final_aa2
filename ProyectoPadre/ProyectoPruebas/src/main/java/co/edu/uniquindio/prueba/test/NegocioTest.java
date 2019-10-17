package co.edu.uniquindio.prueba.test;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@RunWith(Arquillian.class)
public class NegocioTest {

	@EJB
	private NegocioEJB negocioEJB;

	@Deployment
	public static Archive<?> createDeploymentPackage() {
		return ShrinkWrap.create(JavaArchive.class).addClass(NegocioEJB.class)

				.addPackage(Product.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}

//	@Test
//	@Transactional(value = TransactionMode.ROLLBACK)
//	@UsingDataSet({ "person.json" })
//	public void probarAutenticacion() {
//
//		Person p = negocioEJB.autentifyPerson("macaicedoc@uqvirtual.edu.co", "vofh");
//		Assert.assertNotNull(p);
//
//	}

}
