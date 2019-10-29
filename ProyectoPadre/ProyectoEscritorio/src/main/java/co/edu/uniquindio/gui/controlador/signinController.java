package co.edu.uniquindio.gui.controlador;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import co.edu.uniquindio.gui.modelo.EmailClient;
import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class signinController {

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
	private TextField textEmail;

	@FXML
	private PasswordField textPassword;

	@FXML
	private Button butonSignIn;

	@FXML
	private Text textForgotPassword;

	@FXML
	private Text buttonClickHere;

	@FXML
	void action_click_here(MouseEvent event) {

		try {
			EmailClient.toRecoverPasswordAdmin(textEmail.getText());
			JOptionPane.showMessageDialog(null, "The email have been send", "Forgotten Password",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			manejadorEscenarios.showErrorMessage("No se ha podido enviar el correo, asegurese de que sea correcto",
					"Error al enviar el correo");
		} catch (NotFoundAdminException e1) {
			// TODO: handle exception
			manejadorEscenarios.showErrorMessage(e1.getMessage(), "Error al enviar el correo");
		}
	}

	@FXML
	void action_sign_in(ActionEvent event) {
		String email = textEmail.getText();
		String password = textPassword.getText();

		if (!email.isEmpty() && !password.isEmpty()) {
			try {
				Admin admin = manejadorEscenarios.toLogginAdmin(email, password);
				manejadorEscenarios.showPrincipal();
				manejadorEscenarios.showMessage("Welcome " + admin.getFullName(), "Confirmed data");
			} catch (NotFoundAdminException e) {
				manejadorEscenarios.showErrorMessage(e.getMessage(), "Not found admin");
			}
		} else {

		}
	}

//	@FXML
//	void action_sign_up(MouseEvent event) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource("/signup.fxml"));
//		Node node = (Node) event.getSource();
//		Stage stage = (Stage) node.getScene().getWindow();
//		stage.setScene(new Scene(root));
//	}

}
