package com.retur.controlador;


import com.retur.modelo.juego.Juego;
import com.retur.modelo.juego.clases.Jugador;
import com.retur.vista.VentanaPrincipal;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class ControladorJuego {

	
	private ControladorJuego() {}
	
	public static void asignarEventos(VentanaPrincipal vj, Juego juego) {
		
	
	
		vj.CANVAS.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				Jugador jugador = juego.getJugador();

				jugador.MIRILLA.disparar();
				
			}
			
			
			
		});;
		
		vj.CANVAS.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				juego.getJugador().MIRILLA.mover(e.getX(), e.getY());
				
			}
		});
	}

	
}
