package com.miravent.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.miravent.modelo.componentes.Pala;
import com.miravent.modelo.juego.Juego;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorJuego implements Initializable {

	@FXML
	private Canvas zonaJuego;
	
	private Juego JUEGO;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		JUEGO = new Juego(zonaJuego);		
		zonaJuego.requestFocus();
		JUEGO.setDaemon(true);
		JUEGO.start();
	}
	
	@FXML
	private void pulsarTeclaMovimiento(KeyEvent event) {
		
		Pala palaJugador = JUEGO.JUGADOR.getPalaJugador();
		
		if(event.getCode().equals(KeyCode.LEFT)) {
			
			if(palaJugador.isDerecha()) {
				
				palaJugador.setDerecha(false);
				
			}
			
			palaJugador.setIzquierda(true);
			
		}else if (event.getCode().equals(KeyCode.RIGHT)) {
			
			if(palaJugador.isIzquierda()) {
				
				palaJugador.setIzquierda(false);
				
			}
			
			palaJugador.setDerecha(true);
			
		}
		
	}
	
	@FXML
	private void soltarTeclaMovimiento(KeyEvent event) {
		
		Pala palaJugador = JUEGO.JUGADOR.getPalaJugador();
		
		if(event.getCode().equals(KeyCode.LEFT)) {
			
			palaJugador.setIzquierda(false);
			
		}else if (event.getCode().equals(KeyCode.RIGHT)) {
			
			palaJugador.setDerecha(false);
			
		}
		
	}
	

	
}
