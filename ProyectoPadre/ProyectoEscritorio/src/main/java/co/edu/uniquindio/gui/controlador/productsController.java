package co.edu.uniquindio.gui.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class productsController {

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
	private JFXButton buttonListByType;

	@FXML
	private Button buttonSearch;

	@FXML
	private JFXTextField textSearch;

	@FXML
	private TableView<?> tableProducts;

	@FXML
	private Pane panelSuperior;

	@FXML
	private JFXTextField textName;

	@FXML
	private JFXTextField textDescription;

	@FXML
	private JFXTextField textLimitDate;

	@FXML
	private JFXTextField textCode;

	@FXML
	private JFXTextField textAvailability;

	@FXML
	private JFXTextField textUserID;

	@FXML
	private JFXTextField textPrice;

	@FXML
	private JFXTextField textType;

	@FXML
	private Button buttonSelectImage;

	@FXML
	private ImageView image;

	@FXML
	void action_list_by_type(ActionEvent event) {

	}

	@FXML
	void action_search_product(ActionEvent event) {

	}

	@FXML
	void action_select_image(ActionEvent event) {

	}

}
