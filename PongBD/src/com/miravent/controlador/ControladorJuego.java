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

/**
 * Contola los eventos correspondiente al juego.
 * @author Sergio
 *
 */
public class ControladorJuego implements Initializable {

	@FXML
	private Canvas zonaJuego;
	
	private Juego JUEGO;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Se crea el juego.
		JUEGO = new Juego(zonaJuego);	
		//Se establece el foco en el canvas.
		zonaJuego.requestFocus();
		//Se establece el hilo como un thread daemon, para que al cerrar la aplicación el hilo termine con esta.
		JUEGO.setDaemon(true);
		//Se inicia el juego.
		JUEGO.start();
	}
	
	
	/**
	 * Capturador de evento al pulsar las teclas de movimiento(Flechas izquierda y derecha)
	 * @param event
	 */
	@FXML
	private void pulsarTeclaMovimiento(KeyEvent event) {
		
		Pala palaJugador = JUEGO.JUGADOR.getPalaJugador();
		
		/*
		 * Si la tecla pulsada es la izquierda, se comprueba si el valor variable correspondiente a la tecla derecha
		 * es true, es decir, si la tecla derecha está pulsada. Si la tecla derecha está pulsada, 
		 * se establecerá el valor a false y el valor de la variable correspondiente a la tecla izquierda a true.
		 */
		if(event.getCode().equals(KeyCode.LEFT)) {
			
			if(palaJugador.isDerecha()) {
				
				palaJugador.setDerecha(false);
				
			}
			
			palaJugador.setIzquierda(true);

		// Ocurre lo mismo que lo comentado anteriormente pero con el lado contrarío.
		}else if (event.getCode().equals(KeyCode.RIGHT)) {
			
			if(palaJugador.isIzquierda()) {
				
				palaJugador.setIzquierda(false);
				
			}
			
			palaJugador.setDerecha(true);
			
		}
		
	}
	
	/**
	 * Capturador de evento al soltar las teclas de movimiento(Flechas izquierda y derecha)
	 * @param event
	 */
	@FXML
	private void soltarTeclaMovimiento(KeyEvent event) {
		
		Pala palaJugador = JUEGO.JUGADOR.getPalaJugador();
		
		//Cambia el valor de la variable correspondiente a la tecla soltada.
		
		if(event.getCode().equals(KeyCode.LEFT)) {
			
			palaJugador.setIzquierda(false);
			
		}else if (event.getCode().equals(KeyCode.RIGHT)) {
			
			palaJugador.setDerecha(false);
			
		}
		
	}
	

	
}
