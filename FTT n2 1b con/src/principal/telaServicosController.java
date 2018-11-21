package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class telaServicosController {

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
	private Button btnIncluirFuncionario;
	@FXML
	private Button btnIncluirFerramenta;
	@FXML
	private Button btnIncluirPeca;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtCusto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtHoras;
	@FXML
	private ComboBox<Funcionario> cmbFuncionarios;
	@FXML
	private ComboBox<Ferramenta> cmbFerramentas;
	@FXML
	private ComboBox<Peca> cmbPecas;
	@FXML
	private TableView<Servico> tbvServicos;
	@FXML
	private TableView<Peca> tbvPecas;
	@FXML
	private TableView<Ferramenta> tbvFerramentas;
	@FXML
	private TableView<Funcionario> tbvFuncionarios;
	
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
