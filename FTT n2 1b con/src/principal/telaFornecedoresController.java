package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class telaFornecedoresController {

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
	private TextField txtNome;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtCelular;
	@FXML
	private TextField txtTelefone;
	@FXML
	private TextField txtCNPJ;
	@FXML
	private TextField txtCidade;
	@FXML
	private TextField txtBairro;
	@FXML
	private TextField txtEstado;
	@FXML
	private TextField txtEndereco;
	@FXML
	private TextField txtNumero;
	@FXML
	private ComboBox<Pais> cmbPaises;
	@FXML
	private TableView<Fornecedor> tbvFornecedores;
	
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
