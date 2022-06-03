package com.miravent.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.miravent.modelo.bd.InteraccionesBD;
import com.miravent.modelo.componentes.registros.Registro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorListaPuntuaciones implements Initializable {

	@FXML
	private ListView<Registro> lista;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			
			
			ObservableList<Registro> elementos = FXCollections.observableList(InteraccionesBD.obtenerMejoresPuntuaciones());
			FXCollections.sort(elementos);
			lista.setItems(elementos);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		
	}
	
	@FXML
	private void volverAPuntuaciones() {
		
		Stage stage = (Stage) lista.getScene().getWindow();
		try {
			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/miravent/vista/VentanaPuntuacion.fxml"));
			stage.setScene(new Scene(root));

			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}


	
	
	
}
