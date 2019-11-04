package co.edu.uniquindio.gui.controlador;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signupController {

	private ManejadorEscenarios manejadorEscenarios;
	private usersController usersController;
	private Stage stage;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
	}

	public usersController getUsersController() {
		return usersController;
	}

	public void setUsersController(usersController usersController) {
		this.usersController = usersController;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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
	private Button buttonSignUp;

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
			try {
				User user = new User(ID, name, email, cellPhoneNumer, adress, password);
				manejadorEscenarios.toRegisterUser(user);
				manejadorEscenarios.showMessage("new user " + user.getFullName() + " created", "Confirmed data");
				manejadorEscenarios.closeSign(stage);
				usersController.actualizarTabla();
			} catch (RepeatedIDException e) {
				manejadorEscenarios.showErrorMessage(e.getMessage(), "");
			} catch (RepeatedEmailException e) {
				manejadorEscenarios.showErrorMessage(e.getMessage(), "");
			}
		}

	}

}
