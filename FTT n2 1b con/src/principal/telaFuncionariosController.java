package principal;

import java.time.ZoneId;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class telaFuncionariosController {

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
	private TextField txtCelular;
	@FXML
	private TextField txtTelefone;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtCPF;
	@FXML
	private TextField txtCidade;
	@FXML
	private TextField txtEstado;
	@FXML
	private TextField txtBairro;
	@FXML
	private TextField txtEndereco;
	@FXML
	private TextField txtNumero;
	@FXML
	private TextField txtSalario;
	@FXML
	private DatePicker txtDataNascimento;
	@FXML
	private TableView<Funcionario> tbvFuncionarios;
	
	private Funcionario funcionario = new Funcionario();
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvFuncionarios() {
		tbvFuncionarios.setItems((ObservableList<Funcionario>) (new FuncionarioDAO()).BuscarFuncionarios());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		funcionario.setBairro(txtBairro.getText());
		funcionario.setCelular(txtCelular.getText());
		funcionario.setCidade(txtCidade.getText());
		funcionario.setCpf(txtCPF.getText());
		funcionario.setDataNascimento(Date.from(txtDataNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		funcionario.setEmail(txtEmail.getText());
		funcionario.setEndereco(txtEndereco.getText());
		funcionario.setEstado(txtEstado.getText());
		funcionario.setNome(txtNome.getText());
		funcionario.setNumero(Integer.valueOf(txtNumero.getText()));
		funcionario.setTelefone(txtTelefone.getText());
		funcionario.setSalario(Double.valueOf(txtSalario.getText()));
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		boolean successInclusao = funcionarioDAO.Incluir(funcionario);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Funcionário inserido com sucesso" : "Erro ao inserir funcionário");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		if (funcionario.getCodigo() == 0) {
			//não dá para alterar inclusao.
			return;
		}
		
		funcionario.setBairro(txtBairro.getText());
		funcionario.setCelular(txtCelular.getText());
		funcionario.setCidade(txtCidade.getText());
		funcionario.setCpf(txtCPF.getText());
		funcionario.setDataNascimento(Date.from(txtDataNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		funcionario.setEmail(txtEmail.getText());
		funcionario.setEndereco(txtEndereco.getText());
		funcionario.setEstado(txtEstado.getText());
		funcionario.setNome(txtNome.getText());
		funcionario.setNumero(Integer.valueOf(txtNumero.getText()));
		funcionario.setTelefone(txtTelefone.getText());
		funcionario.setSalario(Double.valueOf(txtSalario.getText()));
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		boolean sucessoAlterar = funcionarioDAO.Alterar(funcionario);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Funcionário alterado com sucesso" : "Erro ao alterar funcionário");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		if (funcionario.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		boolean sucessoAlterar = funcionarioDAO.Excluir(funcionario.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Funcionário excluido com sucesso" : "Erro ao excluir funcionário");
		alerta.show();
	}
	
}
