package co.edu.uniquindio.gui.controlador;

import java.util.Arrays;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class usersController {

	private ManejadorEscenarios manejadorEscenarios;
	private ObservableList<User> userObservableList;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
		userObservableList = FXCollections.observableArrayList(manejadorEscenarios.getUserList());
		tableUsers.setItems(userObservableList);
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
		ObservableList<User> observableList = FXCollections.observableArrayList(list);
		manejadorEscenarios.setUserList(list);

		tableUsers.setItems(observableList);

	}

	@FXML
	void action_list_shoppers(ActionEvent event) {
		List<User> list = manejadorEscenarios.toListShoppers();
		ObservableList<User> observableList = FXCollections.observableArrayList(list);
		manejadorEscenarios.setUserList(list);

		// Sos re grosa Aleja te amo att: sinónimo xxdXDdxd jsjsjsjs
		tableUsers.setItems(observableList);
	}

	@FXML
	void action_new_user(ActionEvent event) {
		manejadorEscenarios.showSignUp(this);
	}

	@FXML
	void action_search_user(ActionEvent event) {
		User user;
		try {
			user = manejadorEscenarios.searchUser(textSearch.getText());
			List<User> list = Arrays.asList(user);
			ObservableList<User> observableList = FXCollections.observableArrayList(list);
			manejadorEscenarios.setUserList(list);

			tableUsers.setItems(observableList);

			textID.setText(user.getID());
			textAdress.setText(user.getAdress());
			textCellPhoneNumber.setText(user.getCellphoneNumber());
			textEmail.setText(user.getEmail());
			textFullName.setText(user.getFullName());
		} catch (NullPointerException e) {
			manejadorEscenarios.showErrorMessage("To search you must enter the user identifier", "Empty fields");
		}

	}

	@FXML
	void action_remove(ActionEvent event) {
		String ID = textID.getText();
		manejadorEscenarios.removeUser(ID);

		manejadorEscenarios.showMessage("User successfully removed", "User");
		actualizarTablaBorrar(ID);
	}

	@FXML
	void action_upDate(ActionEvent event) {

		User updatedUser = new User(textID.getText(), textFullName.getText(), textEmail.getText(),
				textCellPhoneNumber.getText(), textAdress.getText(), "");
		manejadorEscenarios.updateUser(updatedUser, textID.getText());

		manejadorEscenarios.showMessage("User successfully updated", "User");
	}

	@FXML
	private void initialize() {
		columID.setCellValueFactory(new PropertyValueFactory<User, String>("ID"));
		columnName.setCellValueFactory(new PropertyValueFactory<User, String>("fullName"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		columnCellPhone.setCellValueFactory(new PropertyValueFactory<User, String>("cellphoneNumber"));
		columnAdress.setCellValueFactory(new PropertyValueFactory<User, String>("adress"));
	}

	public void actualizarTabla(User u) {
		ObservableList<User> userList = FXCollections.observableArrayList(manejadorEscenarios.getUserList());
		userList.add(u);
		manejadorEscenarios.setUserList(userList);
		tableUsers.setItems(userList);
	}

	public void actualizarTablaBorrar(String ID) {
		ObservableList<User> userList = FXCollections.observableArrayList(manejadorEscenarios.getUserList());
		User user = manejadorEscenarios.searchUser(ID);
		userList.remove(user);
		manejadorEscenarios.setUserList(userList);
		tableUsers.setItems(userList);
	}

}
