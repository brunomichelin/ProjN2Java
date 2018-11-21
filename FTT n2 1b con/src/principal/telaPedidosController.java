package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class telaPedidosController {

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
	private Button btnIncluirServico;
	@FXML
	private TextField txtOrdem;
	@FXML
	private DatePicker txtDataPedido;
	@FXML
	private DatePicker txtDataFinalizado;
	@FXML
	private CheckBox chkPago;
	@FXML
	private TextField txtCliente;
	@FXML
	private ComboBox<Veiculo> cmbVeiculos;
	@FXML
	private TextField txtCusto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtHoras;
	@FXML
	private TableView<Pedido> tbvPedidos;
	@FXML
	private TableView<Servico> tbvServicos;
	
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
	
	@FXML
	protected void btnIncluirServico_OnClick(ActionEvent event) {
		
	}
}
