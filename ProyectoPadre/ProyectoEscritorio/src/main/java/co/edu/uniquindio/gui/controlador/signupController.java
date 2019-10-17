package co.edu.uniquindio.gui.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gui.modelo.PruebaDelegado;
import javafx.fxml.Initializable;

public class signupController implements Initializable {

	private PruebaDelegado pruebaDelegado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pruebaDelegado = PruebaDelegado.pruebaDelegado;
	}

}
