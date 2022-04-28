package com.retur.paint.controlador;




import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class ControladorPrincipal implements Initializable {
	
	
	/*************************
	 *****Botones Colores***** 
	 *************************/
	
	@FXML
	private GridPane gridBotonesColores;
	
	
	@FXML
	private Button botonColor1;
	@FXML
	private Button botonColor2;
	
	
	@FXML
	private MenuItem nuevoLienzo;
	
	@FXML
	private ScrollPane zonaLienzo;
	
	private ObservableList<Button> botonesTodosColores;
	private ObservableList<Button> botonesColoresAjustables;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		botonesTodosColores = FXCollections.observableArrayList();
		botonesColoresAjustables = FXCollections.observableArrayList();
		/*
		 * Obtenemos los hijos del grid donde se alamcenan los colores que servirán para cambiar
		 * el color con el que se dibuja, se recorren y se separan los que serán colores por defectos
		 * y en los que se cambiarán los valores.
		 */
		
		for(Node nodo : gridBotonesColores.getChildren()) {
			
			if(nodo instanceof Button) {
				
				Button boton = (Button) nodo;
				
				botonesTodosColores.add(boton);
				
				if(boton.getText().isEmpty()) {
					
					botonesColoresAjustables.add(boton);
					
				}
				
			}
			
			
		}
		
		
	};
	
	
	@FXML
	private void crearLienzo(ActionEvent e) {
		
		
		
	};
	
	@FXML
	private void obtenerColorBoton(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj instanceof Button) {
			
			Button botonActivado = (Button) obj;
			boolean encontrado = false;
			
			for(int i = 0; i < botonesTodosColores.size() && !encontrado; i++) {
				
				Button boton = botonesTodosColores.get(i);
				
				if(botonActivado.equals(boton) && !boton.getText().isEmpty()) {
					
					//TODO Añadir el método cambio de color de controlador pintar.
					
					encontrado = true;
					
				}
				
			}
			
			
		}
		
		
	}
	
	

	
	
	
}
