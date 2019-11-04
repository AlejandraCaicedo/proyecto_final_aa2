package co.edu.uniquindio.gui.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.uniquindio.gui.controlador.adminController;
import co.edu.uniquindio.gui.controlador.appController;
import co.edu.uniquindio.gui.controlador.productsController;
import co.edu.uniquindio.gui.controlador.signinController;
import co.edu.uniquindio.gui.controlador.signupController;
import co.edu.uniquindio.gui.controlador.usersController;
import co.edu.uniquindio.gui.modelo.EscritorioDelegado;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundTypeProduct;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ManejadorEscenarios {

	private BorderPane pantallaBase;
	private Stage stageBase;
	private EscritorioDelegado escritorioDelegado;
	private List<User> userList;
	private List<Product> productList;

	public ManejadorEscenarios(Stage primaryStage) {
		try {
			escritorioDelegado = EscritorioDelegado.escritorioDelegado;
			userList = escritorioDelegado.toListUsers();
			productList = escritorioDelegado.toListProducts();

			this.stageBase = primaryStage;

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/signin.fxml"));

			AnchorPane panel = (AnchorPane) loader.load();

			signinController signinController = loader.getController();
			signinController.setManejadorEscenarios(this);

			Scene scene = new Scene(panel);
			stageBase.setScene(scene);
			stageBase.setTitle("Login as administrator");
			stageBase.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPrincipal() {

		try {

			stageBase.close();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/app.fxml"));

			pantallaBase = (BorderPane) loader.load();

			appController appController = loader.getController();
			appController.setManejadorEscenarios(this);

			Scene scene = new Scene(pantallaBase);
			stageBase.setScene(scene);
			stageBase.setTitle("Admin menu");
			stageBase.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showUsersScene() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/users.fxml"));

			Pane panel = (Pane) loader.load();

			usersController usersController = loader.getController();
			usersController.setManejadorEscenarios(this);

			pantallaBase.setCenter(panel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showProductsScene() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/products.fxml"));

			Pane panel = (Pane) loader.load();

			productsController productsController = loader.getController();
			productsController.setManejadorEscenarios(this);

			pantallaBase.setCenter(panel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAdminScene() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/admin.fxml"));

			Pane panel = (Pane) loader.load();

			adminController adminController = loader.getController();
			adminController.setManejadorEscenarios(this);

			pantallaBase.setCenter(panel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSignUp(usersController usersController) {
		try {
			Stage stage = new Stage();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/signup.fxml"));

			Parent root = loader.load();

			signupController signupController = loader.getController();
			signupController.setManejadorEscenarios(this);
			signupController.setStage(stage);
			signupController.setUsersController(usersController);

			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeSign(Stage stage) {
		stage.close();
	}

	public void showErrorMessage(String message, String tittle) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(tittle);
		alert.setContentText(message);
		alert.initStyle(StageStyle.UTILITY);
		alert.showAndWait();
	}

	public void showMessage(String message, String tittle) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText(tittle);
		alert.setContentText(message);
		alert.initStyle(StageStyle.UTILITY);
		alert.showAndWait();
	}

	public String showChoiseMessage() {
		List<String> choices = new ArrayList<>();
		choices.add("BOOKS");
		choices.add("JEWELRY");
		choices.add("FASHION");
		choices.add("SPORTS");
		choices.add("TECHNOLOGY");
		choices.add("EXPIRED");
		choices.add("NOT EXPIRED");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("----", choices);
		dialog.setTitle("List products by types");
		dialog.setHeaderText("Product types");
		dialog.setContentText("Choose a type");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			return result.get();
		}
		return "vacio";
	}

	public List<User> getUserList() {
		userList = escritorioDelegado.toListUsers();
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public User autentifyUser(String email, String password) {
		return escritorioDelegado.autentifyUser(email, password);
	}

	public List<Commentary> toListProductsComments(String codeProducto) {
		return escritorioDelegado.toListProductsComments(codeProducto);
	}

	public List<User> toListSellers() {
		return escritorioDelegado.toListSellers();
	}

	public List<User> toListShoppers() {
		return escritorioDelegado.toListShoppers();
	}

	public List<Product> toListByType(String type) throws NotFoundTypeProduct {
		return escritorioDelegado.toListByType(type);
	}

	public void toCreateProduct(Product p) throws RepeatedProductException {
		escritorioDelegado.toCreateProduct(p);
	}

	public Product searchProduct(String ID) {
		return escritorioDelegado.searchProduct(ID);
	}

	public void toRegisterUser(User u) throws RepeatedIDException, RepeatedEmailException {
		escritorioDelegado.toRegisterUser(u);
	}

	public void toCreateCommentary(Commentary c) {
		escritorioDelegado.toCreateCommentary(c);
	}

	public void toCreatePurchase(Purchase p) {
		escritorioDelegado.toCreatePurchase(p);
	}

	public void toCreateRate(Rate r) {
		escritorioDelegado.toCreateRate(r);
	}

	public Admin toLogginAdmin(String email, String password) throws NotFoundAdminException {
		return escritorioDelegado.toLogginAdmin(email, password);
	}

	public User searchUser(String ID) {
		return escritorioDelegado.searchUser(ID);
	}

	public void removeUser(String ID) {
		escritorioDelegado.removeUser(ID);
		userList.remove(searchUser(ID));
	}

	public void updateUser(User user, String ID) {
		escritorioDelegado.updateUser(user, ID);
	}

	public Admin getAdmin() {
		return escritorioDelegado.getAdmin();
	}

	public ObservableList<User> listToObservableUser(List<User> usersList) {

		ObservableList<User> res = FXCollections.observableArrayList();
		for (int i = 0; i < usersList.size(); i++) {
			res.add(usersList.get(i));
		}

		return res;
	}

	public ObservableList<Product> listToObservableProduct(List<Product> productList) {

		ObservableList<Product> res = FXCollections.observableArrayList();
		for (int i = 0; i < productList.size(); i++) {
			res.add(productList.get(i));
		}

		return res;
	}

}
