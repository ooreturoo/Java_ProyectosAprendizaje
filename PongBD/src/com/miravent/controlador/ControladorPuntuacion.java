package com.miravent.controlador;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.miravent.controlador.bd.ConexionBD;
import com.miravent.modelo.bd.InteraccionesBD;
import com.miravent.modelo.componentes.alertas.Alertas;
import com.miravent.modelo.componentes.alertas.mensajes.MensajesAlerta;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorPuntuacion implements Initializable{

	@FXML
	private Label labelPuntuacion;
	
	@FXML
	private Button registroPuntuacion;
	
	@FXML
	private Button muestraPuntuacion;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		if(ConexionBD.getConexion() == null) {
			
			registroPuntuacion.setDisable(true);
			
			muestraPuntuacion.setDisable(true);
			
		}
		
	}
	
	public void asignarPuntuacion(String puntuacion) {
		
		labelPuntuacion.setText(puntuacion);
		
	}

	@FXML
	private void registrarPuntuacion() {
		
		//Se puede registrar la puntuacion más de una vez.
		
		TextInputDialog panel = new TextInputDialog();
		panel.setHeaderText(null);
		panel.setTitle(MensajesAlerta.T_SOLICITUD_NOMBRE);
		panel.setContentText(MensajesAlerta.M_SOLICITUD_NOMBRE);
		panel.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
		panel.getEditor().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				
				if(panel.getEditor().getLength() > 50) {
					
					panel.getEditor().setText(oldValue);
					
				}
				
			}
		});
		
		Optional<String> nombre = panel.showAndWait();
		
		if(nombre.isEmpty() || nombre.get().isEmpty()) {
			
			Alertas.crearAlertaError(MensajesAlerta.T_NOMBRE_VACIO, MensajesAlerta.M_NOMBRE_VACIO);
			
		}else {
			
			try {
				
				InteraccionesBD.registrarPuntuacion(nombre.get(), Integer.parseInt(labelPuntuacion.getText()));
				Alertas.crearAlertaInformacion(MensajesAlerta.T_REGISTRO, MensajesAlerta.M_REGISTRO_REALIZADO);
				
			} catch (SQLException e) {
				
				Alertas.crearAlertaError(MensajesAlerta.T_ERROR_REGISTRO, MensajesAlerta.M_ERROR_REGISTRO);
				
			}
		
		}
		

		
	}
	
	@FXML
	private void mostrarPuntuaciones() {
		
		Stage stage = (Stage) labelPuntuacion.getScene().getWindow();

		try {
			//TODO Traspaso de la puntuacion entre escenas.
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/miravent/vista/ListaPuntuacionesMaximas.fxml"));
			stage.setScene(new Scene(root));
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}	
		
	}
	
	@FXML
	private void volverAlMenu() {
		
		Stage stage = (Stage) labelPuntuacion.getScene().getWindow();

		try {
			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/miravent/vista/VentanaInicial.fxml"));
			stage.setScene(new Scene(root));
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		
	}


	
	
}
