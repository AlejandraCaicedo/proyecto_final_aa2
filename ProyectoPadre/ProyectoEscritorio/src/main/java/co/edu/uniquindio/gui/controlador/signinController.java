package co.edu.uniquindio.gui.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gui.modelo.PruebaDelegado;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Person;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signinController implements Initializable {

	private PruebaDelegado pruebaDelegado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pruebaDelegado = PruebaDelegado.pruebaDelegado;
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
	private Text textSingUp;

	@FXML
	void action_sign_in(ActionEvent event) {

		String email = textEmail.getText();
		String password = textPassword.getText();

		if (!email.isEmpty() && !password.isEmpty()) {

			Admin admin;
			try {
				admin = pruebaDelegado.toLogginAdmin(email, password);
				System.out.println(admin);
			} catch (NotFoundAdminException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@FXML
	void action_sign_up(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/signup.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene(root));
	}

}
