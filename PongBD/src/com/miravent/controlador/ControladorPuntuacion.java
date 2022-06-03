package com.miravent.controlador;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.miravent.controlador.bd.ConexionBD;
import com.miravent.modelo.bd.InteraccionesBD;
import com.miravent.modelo.componentes.Puntuacion;
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

/**
 * Controlador de la ventana que muestra la lista de puntuaciones obtenidas de la base de datos.
 * @author Sergio
 *
 */
public class ControladorPuntuacion implements Initializable{

	@FXML
	private Label labelPuntuacion;
	
	@FXML
	private Button registroPuntuacion;
	
	@FXML
	private Button muestraPuntuacion;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Asgina el valor que mostrar al label con los puntos obtenidos.
		labelPuntuacion.setText(String.valueOf(Puntuacion.INSTANCE.getPuntos()));;
		
		/*
		 * Si la conexión no pudo ser iniciada, se deshabilitaran los botones que obtienen o registran datos
		 * en la base de datos.
		 */
		if(ConexionBD.getConexion() == null) {
			
			registroPuntuacion.setDisable(true);
			
			muestraPuntuacion.setDisable(true);
			
		}
		
		/*
		 * Comprueba si la puntuación ya a sido registrada y deshabilita el botón "Registrar". Necesarío para no poder
		 * volver a registrar la puntuación al volver de la ventana donde se muestra la Lista de Puntuaciones.
		 */		
		if(Puntuacion.INSTANCE.isRegistrado()) {
			
			registroPuntuacion.setDisable(true);
			
		}
		
	}

	
	/**
	 * Registra la puntuación al pulsar el botón "Registrar".
	 */
	@FXML
	private void registrarPuntuacion() {
		
		//Se crea una ventana emergente donde introducir el nombre a registrar.
		TextInputDialog panel = new TextInputDialog();
		panel.setHeaderText(null);
		panel.setTitle(MensajesAlerta.T_SOLICITUD_NOMBRE);
		panel.setContentText(MensajesAlerta.M_SOLICITUD_NOMBRE);
		panel.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true);
		
		//TODO Estabelcer apra crear la tabla al iniciar ael programa y cambiar el valor 25 por una constante de la clase.
		//Se limita la cantidad máxima de caracteres para introducir a 25
		panel.getEditor().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				
				if(panel.getEditor().getLength() > InteraccionesBD.MAX_VARCHAR) {
					
					panel.getEditor().setText(oldValue);
					
				}
				
			}
		});
		
		Optional<String> nombre = panel.showAndWait();
		
		//Si no se introduce nombre ninguno aparecerá una ventana emergente avisando al usuario.
		if(nombre.isEmpty() || nombre.get().isEmpty()) {
			
			Alertas.crearAlertaError(MensajesAlerta.T_NOMBRE_VACIO, MensajesAlerta.M_NOMBRE_VACIO);
			
		}else {
			
			/*
			 * Se registra la puntuación en la base de datos, se cambia el valor de la instancia de puntuación a 
			 * registrado y se deshabilita el botón registrar para que no se pueda volvera a registrar la misma
			 * puntuación.
			 */
			try {
				
				InteraccionesBD.registrarPuntuacion(nombre.get().toUpperCase(), Puntuacion.INSTANCE.getPuntos(),ConexionBD.getConexion());
				Puntuacion.INSTANCE.setRegistrado(true);
				registroPuntuacion.setDisable(true);
				Alertas.crearAlertaInformacion(MensajesAlerta.T_REGISTRO, MensajesAlerta.M_REGISTRO_REALIZADO);
				
			} catch (SQLException e) {
				

				Alertas.crearAlertaError(MensajesAlerta.T_ERROR_REGISTRO, MensajesAlerta.M_ERROR_REGISTRO);
				
			}
		
		}
		

		
	}
	
	/**
	 * Accede a la ventana donde se mostrará toda la lista de puntuaciones obtenida de la base de datos.
	 */
	@FXML
	private void mostrarPuntuaciones() {
		
			

			try {
				
				//Verifica que se puede establecer al conexión con la base de datos antes de cambiar de ventana.
				if(ConexionBD.getConexion().isValid(2)) {
					
					Stage stage = (Stage) labelPuntuacion.getScene().getWindow();
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/miravent/vista/ListaPuntuacionesMaximas.fxml"));
					stage.setScene(new Scene(root));
				
				}else {
					
					Alertas.crearAlertaError(MensajesAlerta.T_ERROR_CONEXION, MensajesAlerta.M_ERROR_OBTENER_REGISTROS);
					
					
				}
				
			} catch (IOException | SQLException e) {

				e.printStackTrace();
				
			}
			
		
	}
	
	
	/**
	 * Vuelve a la ventana inicial al pulsar el botón "Salir".
	 */
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
