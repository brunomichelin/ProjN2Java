package principal;

import java.time.ZoneId;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class telaPedidosController {

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
	private Button btnIncluirServico;
	@FXML
	private TextField txtOrdem;
	@FXML
	private DatePicker txtDataPedido;
	@FXML
	private DatePicker txtDataFinalizado;
	@FXML
	private CheckBox chkPago;
	@FXML
	private TextField txtCliente;
	@FXML
	private ComboBox<Veiculo> cmbVeiculos;
	@FXML
	private TextField txtCusto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtHoras;
	@FXML
	private TableView<Pedido> tbvPedidos;
	@FXML
	private TableView<Servico> tbvServicos;
	
	private Pedido pedido = new Pedido();
	
	public telaPedidosController() {
		recarregarTbvPedidos();
	}
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	private void recarregarTbvPedidos() {
		tbvPedidos.setItems((ObservableList<Pedido>) (new PedidoDAO()).BuscarPedidos());
	}
	
	@FXML
	protected void btnIncluir_OnClick(ActionEvent event) {

		
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		boolean successInclusao = pedidoDAO.Incluir(pedido);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(successInclusao ? "Pedido inserido com sucesso" : "Erro ao inserir pedido");
		alerta.show();
	}
	
	@FXML
	protected void btnAlterar_OnClick(ActionEvent event) {

		if (pedido.getCodigo() == 0)
			return;

		
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		boolean sucessoAlterar = pedidoDAO.Alterar(pedido);
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Pedido alterado com sucesso" : "Erro ao alterar pedido");
		alerta.show();
	}
	
	@FXML
	protected void btnConsultar_OnClick(ActionEvent event) {

	}
	
	@FXML
	protected void btnExcluir_OnClick(ActionEvent event) {

		if (pedido.getCodigo() == 0) {
			//não dá para excluir sem estar consultado
			return;
		}
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		boolean sucessoAlterar = pedidoDAO.Excluir(pedido.getCodigo());
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Informação");
		alerta.setContentText(sucessoAlterar ? "Pedido excluido com sucesso" : "Erro ao excluir pedido");
		alerta.show();
	}
	
	@FXML
	protected void btnIncluirServico_OnClick(ActionEvent event) {
		
	}
}
