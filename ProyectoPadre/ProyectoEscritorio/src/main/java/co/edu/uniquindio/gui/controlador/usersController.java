package co.edu.uniquindio.gui.controlador;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class usersController {

	private ManejadorEscenarios manejadorEscenarios;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
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
	private JFXTextField textFullName;

	@FXML
	private JFXTextField textID;

	@FXML
	private JFXTextField textAdress;

	@FXML
	private JFXTextField textCellPhoneNumber;

	@FXML
	private JFXTextField textEmail;

	@FXML
	void action_list_sellers(ActionEvent event) {
		List<User> list = manejadorEscenarios.toListSellers();
		ObservableList<User> observableList = manejadorEscenarios.listToObservable(list);
		manejadorEscenarios.setUserList(observableList);

		tableUsers.setItems(observableList);

	}

	@FXML
	void action_list_shoppers(ActionEvent event) {
		List<User> list = manejadorEscenarios.toListShoppers();
		ObservableList<User> observableList = manejadorEscenarios.listToObservable(list);
		manejadorEscenarios.setUserList(observableList);

		tableUsers.setItems(observableList);
	}

	@FXML
	void action_new_user(ActionEvent event) {
		manejadorEscenarios.showSignUp();
	}

	@FXML
	void action_search_user(ActionEvent event) {
		User user = manejadorEscenarios.searchUser(textSearch.getText());
		ObservableList<User> newList = FXCollections.observableArrayList();
		newList.add(user);
		manejadorEscenarios.setUserList(newList);

		tableUsers.setItems(newList);
	}

	@FXML
	void action_remove(ActionEvent event) {
		User user = tableUsers.getSelectionModel().getSelectedItem();
		manejadorEscenarios.removeUser(user.getID());
	}

	@FXML
	void action_upDate(ActionEvent event) {

	}

	@FXML
	private void initialize() {

		columID.setCellValueFactory(celldata -> celldata.getValue().getIDProperty());
		columnName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		columnAdress.setCellValueFactory(celldata -> celldata.getValue().getAdressProperty());
		columnEmail.setCellValueFactory(celldata -> celldata.getValue().getEmailProperty());
		columnCellPhone.setCellValueFactory(celldata -> celldata.getValue().getCellphoneNumberProperty());

	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;

		tableUsers.setItems(manejadorEscenarios.getUserList());
	}
}
