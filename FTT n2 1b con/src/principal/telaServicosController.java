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
	
	private Servico servico = new Servico();

	public telaServicosController() {
		recarregarTbvServicos();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvServicos() {
		tbvServicos.setItems((ObservableList<Servico>) (new ServicoDAO()).BuscarServicos());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		servico.setCusto(Double.valueOf(txtCusto.getText()));
		servico.setFerramentas(ferramentas);
		servico.setFuncionarios(funcionarios);
		servico.setHoras(Double.valueOf(txtHoras.getText()));
		servico.setNome(txtNome.getText());
		servico.setPecas(pecas);
		servico.setValor(Double.valueOf(txtValor.getText()));
		
		ServicoDAO servicoDAO = new ServicoDAO();
		
		boolean successInclusao = servicoDAO.Incluir(servico);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Serviço inserido com sucesso" : "Erro ao inserir serviço");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		if (servico.getCodigo() == 0)
			return;

		servico.setCusto(Double.valueOf(txtCusto.getText()));
		servico.setFerramentas(ferramentas);
		servico.setFuncionarios(funcionarios);
		servico.setHoras(Double.valueOf(txtHoras.getText()));
		servico.setNome(txtNome.getText());
		servico.setPecas(pecas);
		servico.setValor(Double.valueOf(txtValor.getText()));

		ServicoDAO servicoDAO = new ServicoDAO();
		
		boolean sucessoAlterar = servicoDAO.Alterar(servico);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Serviço alterado com sucesso" : "Erro ao alterar serviço");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		if (servico.getCodigo() == 0)
			return;
		
		ServicoDAO servicoDAO = new ServicoDAO();
		
		boolean sucessoAlterar = servicoDAO.Excluir(servico.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "serviço excluido com sucesso" : "Erro ao excluir serviço");
		alerta.show();
	}
	
}
