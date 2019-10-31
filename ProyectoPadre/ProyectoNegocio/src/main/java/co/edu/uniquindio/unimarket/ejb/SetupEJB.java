package co.edu.uniquindio.unimarket.ejb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Type;
import co.edu.uniquindio.uniMarket.entidades.User;

/**
 * Session Bean implementation class SetupEJB
 */
@Singleton
@LocalBean
@Startup
public class SetupEJB {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SetupEJB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void config() {
		TypedQuery<Admin> q = entityManager.createNamedQuery(Admin.GET_ADMIN, Admin.class);

		if (q.getResultList().isEmpty()) {
			Admin admin = new Admin("A001", "Administrador", "admin@admin.com", "7894132", "Adress Admin 1",
					"admin12345");
			entityManager.persist(admin);

//			User user = new User("U001", "Usuario 1", "user@user.com", "93476294", "Calle 57 A", "user1");
//			entityManager.persist(user);

//			Product product = new Product("P001", "Producto 1", "new product", 5500.0, 10, Type.FASHION, new Date());
//			entityManager.persist(product);
//
//			Product product2 = new Product("P002", "Producto 2", "new product", 7500.0, 10, Type.BOOKS, new Date());
//			entityManager.persist(product2);
//
//			Product product3 = new Product("P003", "Producto 3", "new product", 9500.0, 10, Type.SPORTS, new Date());
//			entityManager.persist(product3);

		}
	}
}