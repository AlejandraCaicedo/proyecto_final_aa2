package co.edu.uniquindio.gui.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gui.modelo.PruebaDelegado;
import co.edu.uniquindio.uniMarket.entidades.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class IniciarSesionController implements Initializable {

	private PruebaDelegado pruebaDelegado;

	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtPassword;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pruebaDelegado = PruebaDelegado.pruebaDelegado;
	}

	@FXML
	public void validarDatos(ActionEvent e) {
		String email = txtEmail.getText();
		String password = txtPassword.getText();

		if (!email.isEmpty() && !password.isEmpty()) {

			Person p = pruebaDelegado.autentifyPerson(email, password);
			System.out.println(p);
		}
	}

}
