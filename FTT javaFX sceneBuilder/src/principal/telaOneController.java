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
	private Button btnCadastros;
	@FXML
	private Button btnRelatorios;
	
	@FXML
	protected void handlerOpenFileButton(ActionEvent event) {
		System.out.println("Vai corinthians!");
		labelStatus.setText("Vai Corinthians!!!");
		
	}
	
	@FXML
	protected void btnCadastros_OnClick(ActionEvent event) {
		(new Ajudante()).AbrirTela("telaMenuCadastros.fxml", "telaMenuCadastros.css", "Menu de Cadastros");
	}
	
	@FXML
	protected void btnRelatorios_OnClick(ActionEvent event) {
		
	}
}
