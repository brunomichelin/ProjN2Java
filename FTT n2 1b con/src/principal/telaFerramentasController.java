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

public class telaFerramentasController {

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
	private TextField txtGarantia;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtMarca;
	@FXML
	private DatePicker txtDataComprada;
	@FXML
	private ComboBox<Fornecedor> cmbFornecedor;
	@FXML
	private TableView<Ferramenta> tbvFerramentas;
	
	private Ferramenta ferramenta = new Ferramenta();
	
	public telaFerramentasController() {
		recarregarTbvFerramenta();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvFerramenta() {
		tbvFerramentas.setItems((ObservableList<Ferramenta>) (new FerramentaDAO()).BuscarFerramentas());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		ferramenta.setGarantia(Double.valueOf(txtGarantia.getText()));
		ferramenta.setNome(txtNome.getText());
		ferramenta.setMarca(txtMarca.getText());
		ferramenta.setValor(Double.valueOf(txtValor.getText()));
		ferramenta.setDataComprada(Date.from(txtDataComprada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		ferramenta.setFornecedor(cmbFornecedor.getValue());
		
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		
		boolean successInclusao = ferramentaDAO.Incluir(ferramenta);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Ferramenta inserida com sucesso" : "Erro ao inserir ferramenta");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {

		if (ferramenta.getCodigo() == 0) {
			//não dá para alterar inclusao.
			return;
		}
		
		ferramenta.setGarantia(Double.valueOf(txtGarantia.getText()));
		ferramenta.setNome(txtNome.getText());
		ferramenta.setMarca(txtMarca.getText());
		ferramenta.setValor(Double.valueOf(txtValor.getText()));
		ferramenta.setDataComprada(Date.from(txtDataComprada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		ferramenta.setFornecedor(cmbFornecedor.getValue());
		
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		
		boolean sucessoAlterar = ferramentaDAO.Alterar(ferramenta);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Ferramenta alterada com sucesso" : "Erro ao alterar ferramenta");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		
		if (ferramenta.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		
		boolean sucessoAlterar = ferramentaDAO.Excluir(ferramenta.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Ferramenta excluida com sucesso" : "Erro ao excluir ferramenta");
		alerta.show();
	}
	
}
