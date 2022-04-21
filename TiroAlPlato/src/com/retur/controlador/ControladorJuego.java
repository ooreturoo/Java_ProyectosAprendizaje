package com.retur.controlador;


import com.retur.modelo.juego.Juego;
import com.retur.modelo.juego.clases.Jugador;
import com.retur.vista.VentanaJuego;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ControladorJuego{

	public final VentanaJuego VJ;
	public final Juego JUEGO;
	public final Stage STAGE;
	
	public ControladorJuego(Stage stage) {
		
		STAGE = stage;
		VJ = new VentanaJuego(STAGE.getWidth(), STAGE.getHeight());
		JUEGO = new Juego(VJ);
		crearEventos();
		
	}
	
	
	private void crearEventos() {
	
		VJ.CANVAS.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				Jugador jugador = JUEGO.getJugador();

				jugador.MIRILLA.disparar();
				
			}
			
			
			
		});;
		
		VJ.CANVAS.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				JUEGO.getJugador().MIRILLA.mover(e.getX(), e.getY());
				
			}
		});
		
	}
	
	public void iniciarJuego() {
		
		JUEGO.start();

		
		
		
	}

	public void mostrarPuntuacion() {
		
		new ControladorPuntuacion();
		
	}
	
}
