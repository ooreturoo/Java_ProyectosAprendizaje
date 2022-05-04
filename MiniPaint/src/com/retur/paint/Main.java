package com.retur.paint;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/com/retur/paint/vista/VistaPaint.fxml"));
			Scene scene = new Scene(root);
			scene.onMouseDraggedProperty().set(null);

			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
