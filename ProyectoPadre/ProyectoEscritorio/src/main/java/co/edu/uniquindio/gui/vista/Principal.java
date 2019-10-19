package co.edu.uniquindio.gui.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Principal extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/signin.fxml"));

		Parent p = loader.load();
		Scene scene = new Scene(p);

		primaryStage.setScene(scene);
		primaryStage.setTitle("LOGIN ADMIN");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

		// run as Java applicationd
	}

}
