package principal;

import java.time.ZoneId;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
	
	private Fornecedor fornecedor = new Fornecedor(); 
	
	public telaFornecedoresController() {
		recarregarTbvFornecedores();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvFornecedores() {
		tbvFornecedores.setItems((ObservableList<Fornecedor>) (new FornecedorDAO()).BuscarFornecedores());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		fornecedor.setNome(txtNome.getText());
		fornecedor.setBairro(txtBairro.getText());
		fornecedor.setCelular(txtCelular.getText());
		fornecedor.setCidade(txtCidade.getText());
		fornecedor.setCnpj(txtCNPJ.getText());
		fornecedor.setEmail(txtEmail.getText());
		fornecedor.setEndereco(txtEndereco.getText());
		fornecedor.setEstado(txtEstado.getText());
		fornecedor.setNumero(Integer.valueOf(txtNumero.getText()));
		fornecedor.setPais(cmbPaises.getValue());
		fornecedor.setTelefone(txtTelefone.getText());
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		boolean successInclusao = fornecedorDAO.Incluir(fornecedor);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Fornecedor inserido com sucesso" : "Erro ao inserir fornecedor");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		if (fornecedor.getCodigo() == 0) {
			//não dá para alterar inclusao.
			return;
		}
		
		fornecedor.setNome(txtNome.getText());
		fornecedor.setBairro(txtBairro.getText());
		fornecedor.setCelular(txtCelular.getText());
		fornecedor.setCidade(txtCidade.getText());
		fornecedor.setCnpj(txtCNPJ.getText());
		fornecedor.setEmail(txtEmail.getText());
		fornecedor.setEndereco(txtEndereco.getText());
		fornecedor.setEstado(txtEstado.getText());
		fornecedor.setNumero(Integer.valueOf(txtNumero.getText()));
		fornecedor.setPais(cmbPaises.getValue());
		fornecedor.setTelefone(txtTelefone.getText());
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		boolean sucessoAlterar = fornecedorDAO.Alterar(fornecedor);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Fornecedor alterado com sucesso" : "Erro ao alterar fornecedor");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		if (fornecedor.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		boolean sucessoAlterar = fornecedorDAO.Excluir(fornecedor.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Fornecedor excluido com sucesso" : "Erro ao excluir fornecedor");
		alerta.show();
	}
	
}
