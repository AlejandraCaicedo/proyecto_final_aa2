package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
@NamedQueries({
		// @NamedQuery(name = "TODOS_PRODUCTOS_COMPRA_OTRO_EJEMPLO", query = "select
		// d.productoCompra from Compra c, IN( c.detalleCompra) d where c.codigo = :
		// codigo"),
		// @NamedQuery(name = "TODOS_PRODUCTOS_COMPRA", query = "select d.productoCompra
		// from Compra c inner join c.detalleCompra d where c.codigo = :codigo"),
		// @NamedQuery(name = "TODAS_COMPRAS_PERSONA", query = "select c from Compra c
		// where c.usuarioCompra.nombre = 'pepito'")
})
public class User extends Person implements Serializable {

	@ElementCollection
	@OneToMany(mappedBy = "user")
	private HashMap<String, Purchase> hmCompra;

	@OneToMany(mappedBy = "user")
	private List<Rate> rates;

	@OneToMany(mappedBy = "user")
	private List<Commentary> comments;

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
}
