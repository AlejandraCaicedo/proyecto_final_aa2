package co.edu.uniquindio.gui.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import co.edu.uniquindio.gui.modelo.PruebaDelegado;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class signupController implements Initializable {

	private PruebaDelegado pruebaDelegado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pruebaDelegado = PruebaDelegado.pruebaDelegado;
	}

	@FXML
	private Text textTittle;

	@FXML
	private TextField textFullName;

	@FXML
	private TextField textID;

	@FXML
	private TextField textAdress;

	@FXML
	private TextField textCellPhoneNumber;

	@FXML
	private TextField textEmail;

	@FXML
	private PasswordField textPassword;

	@FXML
	void action_sign_up(ActionEvent event) {

		String name = textFullName.getText();
		String ID = textID.getText();
		String adress = textAdress.getText();
		String cellPhoneNumer = textCellPhoneNumber.getText();
		String email = textEmail.getText();
		String password = textPassword.getText();

		if (name.isEmpty() || ID.isEmpty() || adress.isEmpty() || cellPhoneNumer.isEmpty() || email.isEmpty()
				|| password.isEmpty()) {
			pruebaDelegado.showErrorMessage("There are empty fields");
		} else {
			User user = new User(ID, name, email, cellPhoneNumer, adress, password);
			try {
				pruebaDelegado.toRegisterUser(user);
			} catch (RepeatedIDException e) {
				pruebaDelegado.showErrorMessage(e.getMessage());
			} catch (RepeatedEmailException e) {
				pruebaDelegado.showErrorMessage(e.getMessage());
			}
		}

	}

}
