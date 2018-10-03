package principal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ajudante {

	public void AbrirTela(String fxml, String css, String titulo) {
		BorderPane root;
		
		try {
			Stage primaryStage = new Stage();
			
			root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
			
			Scene scene = new Scene(root, 1024, 800);
			
			scene.getStylesheets().add(getClass().getResource(css).toExternalForm());
			
			primaryStage.setTitle(titulo);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
