package co.edu.uniquindio.gui.vista;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.gui.controlador.appController;
import co.edu.uniquindio.gui.controlador.productsController;
import co.edu.uniquindio.gui.controlador.usersController;
import co.edu.uniquindio.gui.modelo.EscritorioDelegado;
import co.edu.uniquindio.uniMarket.entidades.Admin;
import co.edu.uniquindio.uniMarket.entidades.Commentary;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.Purchase;
import co.edu.uniquindio.uniMarket.entidades.Rate;
import co.edu.uniquindio.uniMarket.entidades.User;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundAdminException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedEmailException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedIDException;
import co.edu.uniquindio.uniMarket.excepciones.RepeatedProductException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManejadorEscenarios implements Initializable {

	private BorderPane pantallaBase;
	private Stage stageBase;

	private EscritorioDelegado escritorioDelegado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		escritorioDelegado = EscritorioDelegado.escritorioDelegado;
	}

	public ManejadorEscenarios(Stage primaryStage) {
		this.stageBase = primaryStage;

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/app.fxml"));

			pantallaBase = (BorderPane) loader.load();

			appController appController = loader.getController();
			appController.setManejadorEscenarios(this);

			Scene scene = new Scene(pantallaBase);
			stageBase.setScene(scene);
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

	public User autentifyUser(String email, String password) {
		return escritorioDelegado.autentifyUser(email, password);
	}

	public List<Commentary> toListProductsComments(String codeProducto) {
		return escritorioDelegado.toListProductsComments(codeProducto);
	}

	public void toCreateProduct(Product p) throws RepeatedProductException {
		escritorioDelegado.toCreateProduct(p);
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

	public void showErrorMessage(String message) {
		escritorioDelegado.showErrorMessage(message);
	}
}
