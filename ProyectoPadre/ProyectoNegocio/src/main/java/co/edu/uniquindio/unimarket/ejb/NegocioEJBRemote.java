package co.edu.uniquindio.unimarket.ejb;

import javax.ejb.Remote;

import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.entidades.User;

@Remote
public interface NegocioEJBRemote {

	public Person autenticaUser(String email, String key);

}
