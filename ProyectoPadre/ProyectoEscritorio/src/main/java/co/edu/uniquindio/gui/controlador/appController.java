package co.edu.uniquindio.gui.controlador;

import com.jfoenix.controls.JFXButton;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class appController {

	private ManejadorEscenarios manejadorEscenarios;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
	}

	@FXML
	private Pane panelCentral;

	@FXML
	private VBox panelLateral;

	@FXML
	private TableView<?> table;

	@FXML
	private JFXButton buttonAdmin;

	@FXML
	private JFXButton buttonUsers;

	@FXML
	private JFXButton buttonProducts;

	@FXML
	private JFXButton buttonPurchases;

	@FXML
	void action_admin(ActionEvent event) {

		manejadorEscenarios.showAdminScene();
	}

	@FXML
	void action_products(ActionEvent event) {
		manejadorEscenarios.showProductsScene();
	}

	@FXML
	void action_purchases(ActionEvent event) {

	}

	@FXML
	void action_users(ActionEvent event) {
		manejadorEscenarios.showUsersScene();
	}

}
