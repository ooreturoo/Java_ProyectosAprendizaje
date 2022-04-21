package com.retur.vista;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VentanaPrincipal {

	public final double ANCHO_VENTANA;
	public final double ALTO_VENTANA;
	public final AnchorPane RAIZ;
	public final Button BOTON_START;
	
	public VentanaPrincipal(AnchorPane raiz) {
		RAIZ  = raiz;
		RAIZ.getStyleClass().add("raiz");
		ANCHO_VENTANA = RAIZ.getWidth();
		ALTO_VENTANA = RAIZ.getHeight();
		BOTON_START = crearBoton();
		raiz.getChildren().add(BOTON_START);
		raiz.getChildren().add(crearTitulo());
		
		
	}
	
	private Button crearBoton() {
		
		Button boton = new Button();
		boton.setPrefSize(150, 75);
		AnchorPane.setBottomAnchor(boton, RAIZ.getHeight()/4);
		AnchorPane.setLeftAnchor(boton, (RAIZ.getWidth()/2) - (boton.getPrefWidth()/2));
		boton.getStyleClass().add("boton_start");
		boton.setText("Jugar");
		boton.setFont(Font.font("Elephant", FontWeight.BOLD, 30));
		
		return boton;
		
	}
	
	private Label crearTitulo() {
		
		Label titulo = new Label("TIRO AL PLATO MAL");
		titulo.setPrefSize(750, 50);
		titulo.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(titulo, (RAIZ.getHeight()/4) - (titulo.getPrefHeight()/2));
		AnchorPane.setLeftAnchor(titulo, (RAIZ.getWidth()/2) - (titulo.getPrefWidth()/2));
		titulo.getStyleClass().add("titulo");
		titulo.setFont(Font.font("Elephant", FontWeight.BOLD, 50));
		
		
		return titulo;
	}
	
	
}
