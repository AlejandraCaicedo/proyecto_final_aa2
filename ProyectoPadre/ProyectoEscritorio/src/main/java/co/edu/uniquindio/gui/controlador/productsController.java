package co.edu.uniquindio.gui.controlador;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.Product;
import co.edu.uniquindio.uniMarket.excepciones.NotFoundTypeProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class productsController {

	private ManejadorEscenarios manejadorEscenarios;
	private ObservableList<Product> productsObservableList;

	public ManejadorEscenarios getManejadorEscenarios() {
		return manejadorEscenarios;
	}

	public void setManejadorEscenarios(ManejadorEscenarios manejadorEscenarios) {
		this.manejadorEscenarios = manejadorEscenarios;
		productsObservableList = FXCollections.observableArrayList(manejadorEscenarios.getProductList());
		tableProducts.setItems(productsObservableList);
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
	private TableColumn<Product, Integer> columnAvailability;

	@FXML
	private TableColumn<Product, Double> columnPrice;

	@FXML
	private TableColumn<Product, String> columnType;

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
		String type = manejadorEscenarios.showChoiseMessage();
		List<Product> list;
		try {
			list = manejadorEscenarios.toListByType(type);
			ObservableList<Product> observableList = FXCollections.observableArrayList(list);
			manejadorEscenarios.setProductList(list);

			tableProducts.setItems(observableList);
		} catch (NotFoundTypeProduct e) {
			manejadorEscenarios.showErrorMessage(e.getMessage(), "Not found product type");
		}
	}

	@FXML
	void action_search_product(ActionEvent event) {
		Product product = manejadorEscenarios.searchProduct(textSearch.getText());
		List<Product> list = Arrays.asList(product);
		ObservableList<Product> productList = FXCollections.observableArrayList(list);
		manejadorEscenarios.setProductList(list);

		tableProducts.setItems(productList);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		textAvailability.setText(product.getAvailability() + "");
		textCode.setText(product.getCode());
		textDescription.setText(product.getDescription());
		textLimitDate.setText(dateFormat.format(product.getLimit_Date()));
		textName.setText(product.getName());
		textPrice.setText(product.getPrice() + "");
		textType.setText(product.getType().name());
		textUserID.setText(product.getUserID());
	}

	@FXML
	void action_select_image(ActionEvent event) {

	}

	@FXML
	private void initialize() {

		columnCode.setCellValueFactory(new PropertyValueFactory<Product, String>("code"));
		columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		columnAvailability.setCellValueFactory(new PropertyValueFactory<Product, Integer>("availability"));
		columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		columnType.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));

	}

}
