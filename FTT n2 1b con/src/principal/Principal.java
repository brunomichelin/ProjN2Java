package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application {

	public static void main(String[] args) {
		
		System.out.println(new Date());
		
		/*
		People p = new People(100, "ZeSilva");
		
		System.out.println(p);
		
		
		String connectionString =
				"jdbc:sqlserver://localhost:1433;" +
				"database=db_java;" +
				"user=sa;" +
				"password=;";
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(connection.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement stm = connection.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM PEOPLE;");
			
			while (rs.next()) {
				System.out.println(rs.getInt("ID"));
				System.out.println(" - " + rs.getString("NAME"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		*/
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root;
		
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("telaOne.fxml"));
			
			Scene scene = new Scene(root, 1024, 800);
			
			scene.getStylesheets().add(getClass().getResource("telaOne.css").toExternalForm());
			
			primaryStage.setTitle("Menu Principal");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
