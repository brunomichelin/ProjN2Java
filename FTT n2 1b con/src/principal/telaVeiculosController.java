package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class telaVeiculosController {
	
	@FXML //Annotation
	private Label labelStatus;
	@FXML
	private Button btnIncluir;
	@FXML
	private Button btnAlterar;
	@FXML
	private Button btnConsultar;
	@FXML
	private Button btnExcluir;
	@FXML
	private TextField txtCliente;
	@FXML
	private ComboBox<Marca> cmbMarcas;
	@FXML
	private TextField txtModelo;
	@FXML
	private DatePicker txtConserto;
	@FXML
	private TextField txtAnoFabricado;
	@FXML
	private TextField txtAnoModelo;
	@FXML
	private TableView<Veiculo> tbvVeiculos;
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {

	}
	
}
