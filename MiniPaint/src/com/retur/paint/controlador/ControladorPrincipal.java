package com.retur.paint.controlador;





import java.net.URL;
import java.util.ResourceBundle;

import com.retur.paint.modelo.elementos.herramientas.Goma;
import com.retur.paint.modelo.elementos.herramientas.Lapiz;
import com.retur.paint.modelo.elementos.pintura.Lienzo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControladorPrincipal implements Initializable {
	
	
	/*************************
	 *****Botones Colores***** 
	 *************************/
	
	@FXML
	private GridPane gridBotonesColores;
	
	
	@FXML
	private Button lapiz;
	@FXML
	private Button goma;
	
	@FXML
	private Button botonColor1;
	@FXML
	private Button botonColor2;
	
	
	@FXML
	private MenuItem nuevoLienzo;
	
	@FXML
	private ScrollPane zonaLienzo;
	
	@FXML
	private Label coordenadaLienzo;
	
	private ObservableList<Button> botonesTodosColores;
	private ObservableList<Button> botonesColoresAjustables;
	private ControladorPintar cPintar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Inicializamos todas las herramientas asignandole sus botones.
		
		Lapiz.getInstance().init(lapiz);
		Goma.getInstance().init(goma);
		
		
		
		cPintar = new ControladorPintar(botonColor1, botonColor2, coordenadaLienzo);
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
		
		//Esto ira en una ventana nueva que se arbirá al crear nuevo, en el que se introduciran las medidas del lienzo.
		cPintar.setLienzo(new Lienzo(1080, 720, zonaLienzo));
		
	};
	
	@FXML
	private void obtenerColorBoton(ActionEvent e) {
		
		Button boton = (Button) e.getSource();
		
		if(!boton.getText().isEmpty()) {
			
			cPintar.cambioColor(boton.getText());
			
		}
	
	}
	
	/**
	 * Se le asigna el disparador al Canvas del lienzo para que en el momento
	 * que se presione el raton en él se comience a pintar.
	 * @param e
	 */
	@FXML
	private void comienzoPintar(MouseEvent e) {
		
		cPintar.setPintando(true);
		cPintar.setBotonPresionado(e.getButton());
		
	}
	
	@FXML
	private void finalPintar(MouseEvent e) {
		
		cPintar.setPintando(false);
		
		
	}
	

	
	

	
	
	
}
