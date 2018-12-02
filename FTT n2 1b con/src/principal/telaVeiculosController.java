package principal;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaVeiculosController implements Initializable {
	
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
	@FXML
    private TableColumn<Veiculo, String> colCliente;
    @FXML
    private TableColumn<Veiculo, String> colMarca;
    @FXML
    private TableColumn<Veiculo, String> colModelo;
    @FXML
    private TableColumn<Veiculo, String> colAnoFabricado;
    @FXML
    private TableColumn<Veiculo, String> colAnoModelo;
    @FXML
    private TableColumn<Veiculo, String> colConserto;
    
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
		tbvVeiculos.setItems(FXCollections.observableArrayList((new VeiculoDAO()).BuscarVeiculos()));
	}
	
	@FXML
	protected void tbvVeiculos_OnSelectedRow() {
		if (tbvVeiculos.getSelectionModel().getSelectedItem() != null) {
	        veiculo = tbvVeiculos.getSelectionModel().getSelectedItem();
	        
	        txtCliente.setText(veiculo.getCliente().getNome());
	        txtAnoFabricado.setText(String.valueOf(veiculo.getAnoFabricado()));
	        txtAnoModelo.setText(String.valueOf(veiculo.getAnoModelo()));
	        txtModelo.setText(veiculo.getModelo());
	        cmbMarcas.setValue(veiculo.getMarca());
	        txtConserto.setValue(LocalDate.parse(veiculo.getConserto(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	    }
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {
		
		veiculo.setModelo(txtModelo.getText());
		veiculo.setAnoFabricado(Integer.valueOf(txtAnoFabricado.getText()));
		veiculo.setAnoModelo(Integer.valueOf(txtAnoModelo.getText()));
		veiculo.setMarca(cmbMarcas.getValue());
		veiculo.setConserto(txtConserto.toString());
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
		veiculo.setConserto(txtConserto.getValue().toString());
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colCliente.setCellValueFactory(
	            new PropertyValueFactory<>("nomeClienteC"));
		colMarca.setCellValueFactory(
	            new PropertyValueFactory<>("marcaC"));
		colModelo.setCellValueFactory(
	            new PropertyValueFactory<>("modeloC"));
		colAnoFabricado.setCellValueFactory(
				new PropertyValueFactory<>("noFabricadoC"));
		colAnoModelo.setCellValueFactory(
				new PropertyValueFactory<>("noModeloC"));
		colConserto.setCellValueFactory(
				new PropertyValueFactory<>("consertoC"));
		
		recarregarTbvVeiculos();
	}
	
}
