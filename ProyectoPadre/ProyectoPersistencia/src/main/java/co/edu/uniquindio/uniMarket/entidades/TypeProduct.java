package co.edu.uniquindio.uniMarket.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeProduct
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = TypeProduct.LIST_TYPES, query = "select t from TypeProduct t"),
		@NamedQuery(name = TypeProduct.FIND_TYPE, query = "select t from TypeProduct t where t.code=:code") })
public class TypeProduct implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int code;

	private String name;

	public TypeProduct(String name) {
		super();
		this.name = name;
	}

	@OneToMany(mappedBy = "type")
	private ArrayList<Product> listProducts;

	public static final String LIST_TYPES = "LIST_TYPES";

	public static final String FIND_TYPE = "FIND_TYPE";

	private static final long serialVersionUID = 1L;

	public TypeProduct() {
		super();
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeProduct other = (TypeProduct) obj;
		if (code != other.code)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeProduct [code=" + code + ", name=" + name + "]";
	}

}
