package com.retur.paint.controlador;




import java.net.URL;
import java.util.ResourceBundle;

import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;

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
	
	private ObservableList<Button> coloresPredeterminados;
	private ObservableList<Button> coloresAjustables;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/*
		 * Obtenemos los hijos del grid donde se alamcenan los colores que servirán para cambiar
		 * el color con el que se dibuja, se recorren y se separan los que serán colores por defectos
		 * y en los que se cambiarán los valores.
		 */
		
		for(Node nodo : gridBotonesColores.getChildren()) {
			
			if(nodo instanceof Button) {
				
				Button boton = (Button) nodo;
				
				if(boton.getText().isEmpty()) {
					
					coloresAjustables.add(boton);
					
				}else {
					
					coloresPredeterminados.add(boton);
					
				}
				
			}
			
			
		}
		
		
		
		
		
		
		
	};
	
	
	@FXML
	private void crearLienzo(ActionEvent e) {
		
		
		
	};
	
	

	
	
	
}
