package co.edu.uniquindio.gui.controlador;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class signupController {

	private ManejadorEscenarios manejadorEscenarios;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
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
			manejadorEscenarios.showErrorMessage("You have to fill all the fields before continuing",
					"There are empty fields");
		} else {
			User user = new User(ID, name, email, cellPhoneNumer, adress, password);
			try {
				manejadorEscenarios.toRegisterUser(user);
			} catch (RepeatedIDException e) {
				manejadorEscenarios.showErrorMessage(e.getMessage(), "");
			} catch (RepeatedEmailException e) {
				manejadorEscenarios.showErrorMessage(e.getMessage(), "");
			}
		}

	}

}
