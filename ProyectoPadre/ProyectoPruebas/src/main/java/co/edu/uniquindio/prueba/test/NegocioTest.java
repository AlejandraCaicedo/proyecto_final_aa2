package co.edu.uniquindio.prueba.test;

import java.util.List;

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

import co.edu.uniquindio.uniMarket.dto.PRODUCT_INFORMATION;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
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

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void adminLogging() throws NotFoundAdminException {

		Admin a = negocioEJB.toLogginAdmin("admin@admin.com", "admin12345");

		Assert.assertNotNull(a);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void toRemoveUser() {
		User user = negocioEJB.toRemoveUser("U001");
		Assert.assertNull(user);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void toEditUser() {
		User user = new User("U001", "Nuevo", "email", "101011", "dir", "123");

		User nuevo = negocioEJB.toEditUser(user, "U001");
		Assert.assertEquals("dir", nuevo.getAdress());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "person.json" })
	public void toListSellers() {
		List<User> lista = negocioEJB.toListSellers();
		Assert.assertEquals(lista.size(), 3);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "product.json" })
	public void toGiveDetail() {
		PRODUCT_INFORMATION product_INFORMATION = negocioEJB.toGiveProductInformation("P001");

		Assert.assertEquals("Computer LENOVO", product_INFORMATION.getName());
	}

}
