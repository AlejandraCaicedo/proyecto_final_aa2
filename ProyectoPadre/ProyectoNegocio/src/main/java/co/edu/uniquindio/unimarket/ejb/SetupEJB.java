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
			
//			TypedQuery<Persona> q = entityManager.createNamedQuery(Persona.OBTENER_ADMINISTRADOR, Persona.class);
//
//			if (q.getResultList().isEmpty()) {
//			Administrador a = new Administrador();
//			a.setNombre("lucho");
//			a.setEmail("pacho@gmail.com");
//			a.setDireccion("calle 12");
//			a.setCedula("1213");
//			a.setPassword("123");
//			a.setTelefono("3012509304");
//			a.setPassword("123");
//
//			entityManager.persist(a);
//
//			Usuario u = new Usuario();
//			u.setCedula("123");
//			u.setEmail("usuario1@gmail.com");
//			u.setNombre("usuario");
//			u.setTelefono("3012509403");
//			u.setDireccion("las colinas");
//			// u.setRol(Rol.VENDEDOR);
//			u.setPassword("1234");
//
//			entityManager.persist(u);
//
//			Usuario u2 = new Usuario();
//			u2.setCedula("1234");
//			u2.setEmail("usuario2@gmail.com");
//			u2.setNombre("usuario2");
//			u2.setTelefono("3012509403");
//			u2.setDireccion("norte");
//			// u.setRol(Rol.VENDEDOR);
//			u2.setPassword("1234");
//
//			entityManager.persist(u2);
//
//			List<Producto> productos = new ArrayList<Producto>();
//
//			Producto producto = new Producto();
//			producto.setNombre("Huawei Mate 20pro");
//			producto.setIdProducto(1);
//			producto.setTipo(Tipo.TECNOLOGIA);
//			producto.setUsuario(u);
//			producto.setPrecio(33);
//			producto.setDescripcion("optimo");
//			producto.setFechaLimite(new Date());
//			producto.setCantidad(10);
//
//			List<String> imagenes = new ArrayList<String>();
//			String img1 = "http://localhost:8080/mate201.jpg";
//			String img2 = "http://localhost:8080/mate202.jpg";
//			imagenes.add(img1);
//			imagenes.add(img2);
//
//			List<Calificacion> calificaciones = new ArrayList<Calificacion>();
//
//			Calificacion c1 = new Calificacion();
//			c1.setIdCalificacion(1);
//			c1.setCalificacion(3.5);
//			c1.setProducto(producto);
//			c1.setUsuario(u2);
//
//			Calificacion c2 = new Calificacion();
//			c2.setIdCalificacion(2);
//			c2.setCalificacion(4.0);
//			c2.setProducto(producto);
//			c2.setUsuario(u2);
//
//			calificaciones.add(c1);
//			calificaciones.add(c2);
//
//			producto.setImagenes(imagenes);
//			producto.setCalificaciones(calificaciones);
//			u2.setCalificaciones(calificaciones);
//			productos.add(producto);
//			u.setProductos(productos);
//			entityManager.persist(c1);
//			entityManager.persist(c2);
//			entityManager.persist(producto);


		}
	}
}