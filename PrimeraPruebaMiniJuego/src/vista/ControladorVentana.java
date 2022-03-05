package vista;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modelo.Jugador;
import modelo.Pelota;


public class ControladorVentana implements Initializable{

	
	@FXML Canvas fondoCanvas;
	@FXML Rectangle rectangulo;
	@FXML Circle circulo;
	
	private Pelota bola;
	private Jugador jugador;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		jugador = new Jugador(rectangulo, fondoCanvas);
		bola = new Pelota(circulo, fondoCanvas, jugador);
	
		
	}
	
	/**
	 * Método que gestiona los eventos al pulsar las teclas de las flechas laterales para el movimiento
	 * del jugador.
	 */
	private void gestionEventos() {
		/*
		 * Se utilizan dos booleanos que se les da el valor de verdadero para que en el método perteneciente
		 * al jugador encargado del movimiento, que irá dentro del Anmation Timer para que se ejecute la acción
		 * en todo momento y se vea fluido el movimiento.
		 * Parará de moverse en el momento de soltar la tecla, pues se cambiará el valor de booleano a falso, por lo
		 * que ya no se moverá
		 */
		fondoCanvas.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode().equals(KeyCode.RIGHT)) {
					
					jugador.setDerecha(true);
					
				}else if(e.getCode().equals(KeyCode.LEFT)) {
					
					jugador.setIzquierda(true);
					
				}
				
				
			}
		});
		
		fondoCanvas.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode().equals(KeyCode.RIGHT)) {
					
					jugador.setDerecha(false);
					
				}else if(e.getCode().equals(KeyCode.LEFT)) {
					
					jugador.setIzquierda(false);
					
				}
				
			}
		});
	}
	
	
	/**
	 * Método encargado del ciclo de juego.
	 */
	public void cicloJuego() {
		
		/*
		 *  Se llama a la gestión de eventos para establecer los eventos al pulsar las teclas.
		 *  (No se realiza en el método inicialize porque se establecen en la escena y en ese momento no ha sido cargada)
		 */
		gestionEventos();
		
		AnimationTimer timer = new AnimationTimer() {
			long tiempoInicio = System.nanoTime();
			@Override
			public void handle(long tiempoActual) {
				
				double segundos = (tiempoActual - tiempoInicio) / 1000000000.0;
				System.out.println(segundos);
				bola.movimientoPelota();
				jugador.movimientoJugador();
				
				
			}
		};
			
		timer.start();
		
	}
	
	
	
	@FXML
	private void foco() {
		fondoCanvas.requestFocus();
		cicloJuego();
	
	}
	

	
	
	
	
	
	
	
}
