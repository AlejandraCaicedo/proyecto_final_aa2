package co.edu.uniquindio.gui.controlador;

import java.util.Date;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.entidades.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class productsController {

	private ManejadorEscenarios manejadorEscenarios;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
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
	private TableView<Product> tableProducts;

	@FXML
	private TableColumn<Product, String> columnCode;

	@FXML
	private TableColumn<Product, String> columnName;

	@FXML
	private TableColumn<Product, String> columnDescription;

	@FXML
	private TableColumn<Product, Double> columnPrice;

	@FXML
	private TableColumn<Product, Integer> columnAvailability;

	@FXML
	private TableColumn<Product, String> columnType;

	@FXML
	private TableColumn<Product, String> columnLimit_Date;

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
		List<Product> type = manejadorEscenarios.toListByType(textType.getText());
		ObservableList<Product> newList = manejadorEscenarios.listToObservableProduct(type);
		manejadorEscenarios.setProductList(newList);

		tableProducts.setItems(newList);
	}

	@FXML
	void action_search_product(ActionEvent event) {

	}

	@FXML
	void action_select_image(ActionEvent event) {

	}

	@FXML
	private void initialize() {

		columnCode.setCellValueFactory(celldata -> celldata.getValue().getCodeProperty());
		columnName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		columnAvailability.setCellValueFactory(celldata -> celldata.getValue().getAvailabilityProperty().asObject());
		columnDescription.setCellValueFactory(celldata -> celldata.getValue().getDescriptionProperty());
		columnLimit_Date.setCellValueFactory(celldata -> celldata.getValue().getDateProperty());
		columnPrice.setCellValueFactory(celldata -> celldata.getValue().getPriceProperty().asObject());
		columnType.setCellValueFactory(celldata -> celldata.getValue().getTypeProperty());

	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;

		tableProducts.setItems(manejadorEscenarios.getProductList());
	}

}
