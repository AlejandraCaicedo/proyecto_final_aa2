package co.edu.uniquindio.gui.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.User;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

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
	private TableView<User> tableUsers;

	@FXML
	private TableColumn<User, String> columID;

	@FXML
	private TableColumn<User, String> columnName;

	@FXML
	private TableColumn<User, String> columnAdress;

	@FXML
	private TableColumn<User, String> columnCellPhone;

	@FXML
	private TableColumn<User, String> columnEmail;

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

	@FXML
	private void initialize() {
//		columID.setCellValueFactory(cellData -> cellData.getValue().getID());
//		columnName.setCellValueFactory(cellData -> cellData.getValue().getFullName());
	}
}
