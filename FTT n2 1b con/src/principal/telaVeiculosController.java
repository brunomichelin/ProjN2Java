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

public class telaVeiculosController {
	
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
	private TextField txtCliente;
	@FXML
	private ComboBox<Marca> cmbMarcas;
	@FXML
	private TextField txtModelo;
	@FXML
	private DatePicker txtConserto;
	@FXML
	private TextField txtAnoFabricado;
	@FXML
	private TextField txtAnoModelo;
	@FXML
	private TableView<Veiculo> tbvVeiculos;
	
	private Veiculo veiculo = new Veiculo();
	
	public telaVeiculosController() {
		recarregarTbvVeiculos();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvVeiculos() {
		tbvVeiculos.setItems((ObservableList<Veiculo>) (new VeiculoDAO()).BuscarVeiculos());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		veiculo.setModelo(txtModelo.getText());
		veiculo.setAnoFabricado(Integer.valueOf(txtAnoFabricado.getText()));
		veiculo.setAnoModelo(Integer.valueOf(txtAnoModelo.getText()));
		veiculo.setMarca(cmbMarcas.getValue());
		veiculo.setConserto(Date.from(txtConserto.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		veiculo.setCliente((new ClienteDAO()).PesquisarNome(txtCliente.getText()));
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		boolean successInclusao = veiculoDAO.Incluir(veiculo);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Veículo inserido com sucesso" : "Erro ao inserir veículo");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {
		if (veiculo.getCodigo() == 0) {
			//não dá para alterar inclusao.
			return;
		}
		
		veiculo.setModelo(txtModelo.getText());
		veiculo.setAnoFabricado(Integer.valueOf(txtAnoFabricado.getText()));
		veiculo.setAnoModelo(Integer.valueOf(txtAnoModelo.getText()));
		veiculo.setMarca(cmbMarcas.getValue());
		veiculo.setConserto(Date.from(txtConserto.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		veiculo.setCliente((new ClienteDAO()).PesquisarNome(txtCliente.getText()));
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		boolean sucessoAlterar = veiculoDAO.Alterar(veiculo);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Veículo alterado com sucesso" : "Erro ao alterar veículo");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {
		if (veiculo.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		boolean sucessoAlterar = veiculoDAO.Excluir(veiculo.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Veículo excluido com sucesso" : "Erro ao excluir veículo");
		alerta.show();
	}
	
}
