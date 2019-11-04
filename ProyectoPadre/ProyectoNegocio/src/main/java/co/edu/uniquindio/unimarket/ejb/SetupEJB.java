package co.edu.uniquindio.unimarket.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.RatePK;
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
			Admin admin = new Admin("A001", "Administrador", "admin@admin.com", "7894132", "Adress Admin 1", "admin");
			entityManager.persist(admin);

			User u = new User("U001", "Usuario 1", "user1@user.com", "243435532", "Calle 23", "user");

			List<Product> listProducts = new ArrayList<Product>();

			Product product = new Product("P001", "Producto 1", "a new product", 2566.0, 10, Type.JEWELRY, new Date());
			product.setUser(u);

			List<String> images = new ArrayList<String>();
			String img1 = "";
			String img2 = "";
			images.add(img1);
			images.add(img2);
			product.setImages(images);

			List<Rate> rates = new ArrayList<Rate>();

			RatePK rateID = new RatePK(product.getCode(), u.getID());
			Rate r1 = new Rate(rateID, product, u, 3.5);

			rates.add(r1);
			product.setListRates(rates);
			u.setListRates(rates);

			listProducts.add(product);
			u.setListProducts(listProducts);

			entityManager.persist(r1);
			entityManager.persist(product);
			entityManager.persist(u);
		}
	}
}