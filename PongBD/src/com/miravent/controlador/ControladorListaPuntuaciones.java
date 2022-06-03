package com.miravent.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.miravent.controlador.bd.ConexionBD;
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

/**
 * Controlador de la ventana que muestra la lista de puntuaciones obtenidas de la base de datos.
 * @author Sergio
 *
 */
public class ControladorListaPuntuaciones implements Initializable {

	@FXML
	private ListView<Registro> lista;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			//Se obtiene la lista de elementos de la base de datos y se transforma en una lista observable.
			ObservableList<Registro> elementos = FXCollections.observableList(InteraccionesBD.obtenerMejoresPuntuaciones(ConexionBD.getConexion()));
			//Se ordena la lista por el orden natural de los registros.
			FXCollections.sort(elementos);
			//Se añade los elementos a la ListView que los mostrará.
			lista.setItems(elementos);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	/**
	 * Captura el evento al pulsar el botón para volver a la ventana de la puntuación obtenida.
	 */
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
