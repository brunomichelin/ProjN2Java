package principal;

import java.time.ZoneId;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class telaPecasController {

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
	private DatePicker txtDataComprada;
	@FXML
	private TextField txtGarantia;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtMarca;
	@FXML
	private ComboBox<Fornecedor> cmbFornecedores;
	@FXML
	private TableView<Peca> tbvPecas;
	
	Peca peca = new Peca();
	
	public telaPecasController() {
		recarregarTbvClientes();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvClientes() {
		tbvPecas.setItems((ObservableList<Peca>) (new PecaDAO()).BuscarPecas());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		peca.setNome(txtNome.getText());
		peca.setValor(Double.valueOf(txtValor.getText()));
		peca.setMarca(txtMarca.getText());
		peca.setGarantia(Double.valueOf(txtGarantia.getText()));
		peca.setFornecedor(cmbFornecedores.getValue());
		peca.setDataComprada(Date.from(txtDataComprada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		PecaDAO pecaDAO = new PecaDAO();
		
		boolean successInclusao = pecaDAO.Incluir(peca);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Peça inserido com sucesso" : "Erro ao inserir peça");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		if (peca.getCodigo() == 0)
			return;
		
		peca.setNome(txtNome.getText());
		peca.setValor(Double.valueOf(txtValor.getText()));
		peca.setMarca(txtMarca.getText());
		peca.setGarantia(Double.valueOf(txtGarantia.getText()));
		peca.setFornecedor(cmbFornecedores.getValue());
		peca.setDataComprada(Date.from(txtDataComprada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		PecaDAO pecaDAO = new PecaDAO();
		
		boolean successAlterar = pecaDAO.Alterar(peca);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successAlterar ? "Peça alterada com sucesso" : "Erro ao alterar peça");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		
		if (peca.getCodigo() == 0)
			return;
		
		PecaDAO pecaDAO = new PecaDAO();
		
		boolean sucessoAlterar = pecaDAO.Excluir(peca.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Peça excluída com sucesso" : "Erro ao excluir peça");
		alerta.show();
	}
	
}
