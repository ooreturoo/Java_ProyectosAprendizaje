package com.retur.pong.vista;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class VentanaPrincipal {

	public static final double ANCHO_VENTANA = 1080;
	public static final double ALTO_VENTANA = 720;
	
	public final Scene ESCENA_INICIO;
	private final AnchorPane RAIZ;
	public final TextField NOMBRE_J1;
	public final TextField NOMBRE_J2;
	public final Button BOTON_JUGAR;
	
	
	public VentanaPrincipal() {
	
		this.RAIZ = new AnchorPane();
		this.ESCENA_INICIO = new Scene(RAIZ, ANCHO_VENTANA, ALTO_VENTANA);
		this.BOTON_JUGAR = crearBotonJugar();
		this.NOMBRE_J1 = crearCampoNombreJ1();
		this.NOMBRE_J2 = crearCampoNombreJ2();
		
		crearTitulo();
		crearLabelsNombreJugadores();
		
		RAIZ.getChildren().add(NOMBRE_J1);
		RAIZ.getChildren().add(NOMBRE_J2);
		RAIZ.getChildren().add(BOTON_JUGAR);
		
	}
	
	private void crearTitulo() {
		
		Label titulo = new Label();
		
		titulo.setText("PONG MULTIJUGADOR");
		titulo.setFont(new Font("Arial", 72));
		titulo.setAlignment(Pos.CENTER);
		titulo.setLayoutX(149);
		titulo.setLayoutY(89);
		
		RAIZ.getChildren().add(titulo);
		
	}
	
	private void crearLabelsNombreJugadores() {
		
		Label j1 = new Label();
		Label j2 = new Label();
		
		Font fuente = new Font("Tahoma", 14);
		
		j1.setText("Jugador 1:");
		j1.setLayoutX(149);
		j1.setLayoutY(267);
		j1.setFont(fuente);
		
		j2.setText("Jugador 2:");
		j2.setLayoutX(710);
		j2.setLayoutY(267);
		j2.setFont(fuente);
		
		RAIZ.getChildren().add(j1);
		RAIZ.getChildren().add(j2);
		
	}
	
	private Button crearBotonJugar() {
		
		Button boton = new Button("JUGAR");
		boton.setFont(new Font("Impact", 50));
		boton.setLayoutX(337);
		boton.setLayoutY(510);
		boton.setPrefWidth(406);
		boton.setPrefHeight(103);
		
		return boton;
		
		
	}
	
	private TextField crearCampoNombreJ1() {
		
		TextField campo = new TextField();
		
		campo.setPrefWidth(149);
		campo.setLayoutX(223);
		campo.setLayoutY(264);
		
		return campo;
		
	}
	
	private TextField crearCampoNombreJ2() {
		
		TextField campo = new TextField();
		
		campo.setPrefWidth(149);
		campo.setLayoutX(783);
		campo.setLayoutY(264);
		
		return campo;
		
	}
	
}
