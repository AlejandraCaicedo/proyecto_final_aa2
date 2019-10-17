package co.edu.uniquindio.unimarket.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.uniMarket.entidades.Admin;

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
			Admin admin = new Admin("123", "Administrador 1", "admin@gmail.com", "123456789", "Calle 45", "admin123");

			entityManager.persist(admin);
		}
	}
}
