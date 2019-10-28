package co.edu.uniquindio.gui.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class usersController {

	private ManejadorEscenarios manejadorEscenarios;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
	}

	@FXML
	private Pane panelPrincipal;

	@FXML
	private Pane panelTabla;

	@FXML
	private Button buttonSearch;

	@FXML
	private JFXTextField textSearch;

	@FXML
	private TableView<?> tableUsers;

	@FXML
	private Pane panelSuperior;

	@FXML
	private JFXButton buttonNewUser;

	@FXML
	private JFXButton buttonListSellers;

	@FXML
	private JFXButton buttonListShoppers;

	@FXML
	private Button buttonUpDate;

	@FXML
	private Button buttonRemove;

	@FXML
	void action_list_sellers(ActionEvent event) {

	}

	@FXML
	void action_list_shoppers(ActionEvent event) {

	}

	@FXML
	void action_new_user(ActionEvent event) {
		manejadorEscenarios.showSignUp();
	}

	@FXML
	void action_search_user(ActionEvent event) {

	}

	@FXML
	void action_remove(ActionEvent event) {

	}

	@FXML
	void action_upDate(ActionEvent event) {

	}

}
