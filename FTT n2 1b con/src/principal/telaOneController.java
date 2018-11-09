package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class telaOneController {

	@FXML //Annotation
	private Label labelStatus;
	@FXML
	private Button btnRelatorios;
	@FXML
	private Button btnCaixa;
	@FXML
	private Button btnClientes;
	@FXML
	private Button btnFuncionarios;
	@FXML
	private Button btnFornecedores;
	@FXML
	private Button btnPecas;
	@FXML
	private Button btnPedidos;
	@FXML
	private Button btnServicos;
	@FXML
	private Button btnFerramentas;
	@FXML
	private BorderPane raiz;
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
	}
	
	@FXML
	protected void btnClientes_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaClientes.fxml", "telaClientes.css", "Clientes");
	}
	
	@FXML
	protected void btnFuncionarios_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaFuncionarios.fxml", "telaFuncionarios.css", "Funcionários");
	}
	
	@FXML
	protected void btnFornecedores_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaFornecedores.fxml", "telaFornecedores.css", "Fornecedores");
	}
	
	@FXML
	protected void btnPecas_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaPecas.fxml", "telaPecas.css", "Peças");
	}
	
	@FXML
	protected void btnPedidos_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaPedidos.fxml", "telaPedidos.css", "Pedidos");
	}
	
	@FXML
	protected void btnServicos_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaServicos.fxml", "telaServicos.css", "Serviços");
	}
	
	@FXML
	protected void btnFerramentas_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaFerramentas.fxml", "telaFerramentas.css", "Ferramentas");
	}
	
	@FXML
	protected void btnRelatorios_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaMenuRelatorios.fxml", "telaMenuRelatorios.css", "Relatórios");
	}
	
	@FXML
	protected void btnCaixa_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela(raiz, "telaCaixa.fxml", "telaCaixa.css", "Caixa");
	}
}
