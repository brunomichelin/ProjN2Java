package principal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ajudante {
	
	public void AbrirTela(BorderPane raiz, String fxml, String css, String titulo) {
		BorderPane root;
		
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
		
			try {
				raiz.getChildren().remove(0);
			} catch(Exception e) {}
			
			raiz.getChildren().add(root);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AbrirTela(String fxml, String css, String titulo) {
		BorderPane root;
		
		try {
			Stage primaryStage = new Stage();
			
			root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
			
			Scene scene = new Scene(root, 1024, 800);
			
			scene.getStylesheets().add(getClass().getResource(css).toExternalForm());
		
			primaryStage.setTitle(titulo);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
