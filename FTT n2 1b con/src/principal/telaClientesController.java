package principal;

import java.time.ZoneId;
import java.util.Date;

import com.sun.security.ntlm.Client;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
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
	
	private Cliente cliente = new Cliente();
	
	public telaClientesController() {
		recarregarTbvClientes();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvClientes() {
		tbvClientes.setItems((ObservableList<Cliente>) (new ClienteDAO()).BuscarClientes());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		cliente.setNome(txtNome.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setCelular(txtCelular.getText());
		cliente.setDataNascimento(Date.from(txtDataNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		boolean successInclusao = clienteDAO.Incluir(cliente);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Cliente inserido com sucesso" : "Erro ao inserir cliente");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		
		if (cliente.getCodigo() == 0) {
			//não dá para alterar inclusao.
			return;
		}
		
		cliente.setNome(txtNome.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setCelular(txtCelular.getText());
		cliente.setDataNascimento(Date.from(txtDataNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		boolean sucessoAlterar = clienteDAO.Alterar(cliente);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Cliente alterado com sucesso" : "Erro ao alterar cliente");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {
		
		
		
	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		
		if (cliente.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		boolean sucessoAlterar = clienteDAO.Excluir(cliente.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Cliente excluido com sucesso" : "Erro ao excluir cliente");
		alerta.show();
	}
	
	@FXML
	protected void btnIncluirVeiculo_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela("telaVeiculos.fxml", "telaVeiculos.css", "Veículos");
	}
}
