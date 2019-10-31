package co.edu.uniquindio.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("holaMundoBean")
@ApplicationScoped
public class HolaMundoBean {

	private String mensaje;

	public String getMensaje() {
		mensaje = "Hola texto bean";
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
