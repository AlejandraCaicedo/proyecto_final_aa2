package co.edu.uniquindio.gui.controlador;

import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class adminController {

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
	private Pane panelSuperior;

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
	private Text textTittle;
}
