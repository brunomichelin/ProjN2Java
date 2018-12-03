package principal;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import com.sun.security.ntlm.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class telaClientesController implements Initializable {
	
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
    private TableColumn<Cliente, String> colNome;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colCelular;
    @FXML
    private TableColumn<Cliente, String> colTelefone;
    @FXML
    private TableColumn<Cliente, String> colDataNasc;
    
	private Cliente cliente = new Cliente();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colNome.setCellValueFactory(
	            new PropertyValueFactory<>("nomeC"));
		colEmail.setCellValueFactory(
	            new PropertyValueFactory<>("emailC"));
		colCelular.setCellValueFactory(
	            new PropertyValueFactory<>("celularC"));
		colTelefone.setCellValueFactory(
				new PropertyValueFactory<>("telefoneC"));
		colDataNasc.setCellValueFactory(
				new PropertyValueFactory<>("dataNascimentoC"));
		
		recarregarTbvClientes();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvClientes() {
		ObservableList<Cliente> obsClientes = FXCollections.observableArrayList((new ClienteDAO()).BuscarClientes());
		tbvClientes.setItems(obsClientes);
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		cliente.setNome(txtNome.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setCelular(txtCelular.getText());
		cliente.setDataNascimento(txtDataNascimento.getValue().toString());
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int codigoInclusao = clienteDAO.Incluir(cliente);
		
		cliente.setCodigo(codigoInclusao);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(codigoInclusao > 0 ? "Cliente inserido com sucesso" : "Erro ao inserir cliente");
		alerta.show();
		
		recarregarTbvClientes();
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
		cliente.setDataNascimento(txtDataNascimento.getValue().toString());
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int sucessoAlterar = clienteDAO.Alterar(cliente);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar > 0 ? "Cliente alterado com sucesso" : "Erro ao alterar cliente");
		alerta.show();
		
		recarregarTbvClientes();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {
		
		
		
	}
	
	@FXML
	protected void tbvCliente_OnSelectedRow() {
		if (tbvClientes.getSelectionModel().getSelectedItem() != null) {
	        cliente = tbvClientes.getSelectionModel().getSelectedItem();
	        
	        txtNome.setText(cliente.getNome());
	        txtEmail.setText(cliente.getEmail());
	        txtCelular.setText(cliente.getCelular());
	        txtTelefone.setText(cliente.getTelefone());
	        txtDataNascimento.setValue(LocalDate.parse(cliente.getDataNascimento(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	    }
	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		
		if (cliente.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int sucessoAlterar = clienteDAO.Excluir(cliente.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar > 0 ? "Cliente excluido com sucesso" : "Erro ao excluir cliente");
		alerta.show();
		
		recarregarTbvClientes();
	}
	
	@FXML
	protected void btnIncluirVeiculo_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela("telaVeiculos.fxml", "telaVeiculos.css", "Veículos");
	}

	
}
