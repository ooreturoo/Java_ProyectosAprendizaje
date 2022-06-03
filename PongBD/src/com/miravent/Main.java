package com.miravent;
	

import java.sql.SQLException;

import com.miravent.controlador.bd.ConexionBD;
import com.miravent.modelo.bd.InteraccionesBD;
import com.miravent.modelo.componentes.alertas.Alertas;
import com.miravent.modelo.componentes.alertas.mensajes.MensajesAlerta;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("PONG");
		
		try {
			primaryStage.setResizable(false);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/com/miravent/vista/VentanaInicial.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setOnHidden(event -> {
				
				if(ConexionBD.getConexion() != null) {
					
					try {
						
						ConexionBD.cerrarConexion();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			});
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			try {
				
				ConexionBD.establecerConexion();
				InteraccionesBD.creacionTabla(ConexionBD.getConexion());
				
			} catch (SQLException e) {
				
				Alertas.crearAlertaError(MensajesAlerta.T_ERROR_CONEXION, MensajesAlerta.M_ERROR_CONEXION);
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
