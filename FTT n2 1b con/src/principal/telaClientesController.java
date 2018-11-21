package principal;

import com.sun.security.ntlm.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class telaClientesController {
	
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
	private Button btnIncluirVeiculo;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtCelular;
	@FXML
	private TextField txtTelefone;
	@FXML
	private DatePicker txtDataNascimento;
	@FXML
	private TableView<Cliente> tbvClientes;
	
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
	protected void btnIncluirVeiculo_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela("telaVeiculos.fxml", "telaVeiculos.css", "Veículos");
	}
}
