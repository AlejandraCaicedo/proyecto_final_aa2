package co.edu.uniquindio.gui.vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		new ManejadorEscenarios(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
