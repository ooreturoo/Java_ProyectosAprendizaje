package com.retur;
	
import java.io.File;

import com.retur.controlador.ControladorMenuInicial;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Principal extends Application {
	
	
	@Override
	public void start(Stage stage) {
		try {
			
			AnchorPane anchor = new AnchorPane();
			Scene scene = new Scene(anchor);
			scene.getStylesheets().add(new File("src/resources/application.css").toURI().toString());
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
			new ControladorMenuInicial(stage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
