package co.edu.uniquindio.gui.controlador;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import co.edu.uniquindio.gui.vista.ManejadorEscenarios;
import co.edu.uniquindio.uniMarket.entidades.Product;
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
	private TableColumn<Product, String> columnUserID;

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
//		Product product = manejadorEscenarios.searchProduct(textCode.getText());
//		ObservableList<Product> productList = FXCollections.observableArrayList();
//		productList.add(product);
//		manejadorEscenarios.setProductList(productList);
//
//		tableProducts.setItems(productList);
//
//		textAvailability.setText(product.getAvailability() + "");
//		textCode.setText(product.getCode());
//		textDescription.setText(product.getDescription());
//		textLimitDate.setText(product.getDateProperty().getValue());
//		textName.setText(product.getName());
//		textPrice.setText(product.getPrice() + "");
//		textType.setText(product.getTypeProperty().getValue());
//		textUserID.setText(product.getUserID());
	}

	@FXML
	void action_select_image(ActionEvent event) {

	}

	@FXML
	private void initialize() {

		columnCode.setCellValueFactory(new PropertyValueFactory<Product, String>("code"));
		columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		columnAvailability.setCellValueFactory(new PropertyValueFactory<Product, Integer>("availability"));
		columnLimit_Date.setCellValueFactory(new PropertyValueFactory<Product, String>("limit_Date"));
		columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		columnType.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
		columnUserID.setCellValueFactory(new PropertyValueFactory<Product, String>("userID"));

	}

}
