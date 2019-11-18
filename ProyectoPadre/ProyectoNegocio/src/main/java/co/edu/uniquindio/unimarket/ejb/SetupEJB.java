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
import co.edu.uniquindio.uniMarket.entidades.TypeProduct;
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
			Admin admin = new Admin("A001", "Administrador", "admin@admin.com", "7894132", "Adress Admin 1", "admin");
			entityManager.persist(admin);

			User u1 = new User("U001", "Usuario 1", "user1@user.com", "243435532", "Calle 23", "user");
			entityManager.persist(u1);

			User u2 = new User("U002", "Usuario 2", "user2@user.com", "243995832", "Calle 24", "user");
			entityManager.persist(u2);

			TypeProduct t1 = new TypeProduct("BOOKS");
			entityManager.persist(t1);

			TypeProduct t2 = new TypeProduct("TECHNOLOGY");
			entityManager.persist(t2);

			Product p1 = new Product("P001", "Product 1", "new product", 6666, 10, t1, new Date(), u1);
			entityManager.persist(p1);

			Product p2 = new Product("P002", "Product 2", "new product", 6766, 5, t2, new Date(), u1);
			entityManager.persist(p2);
		}
	}
}