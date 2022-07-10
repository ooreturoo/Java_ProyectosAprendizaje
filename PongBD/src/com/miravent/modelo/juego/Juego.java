package com.miravent.modelo.juego;


import java.io.IOException;


import com.miravent.modelo.componentes.Jugador;
import com.miravent.modelo.componentes.Pala;
import com.miravent.modelo.componentes.Pelota;
import com.miravent.modelo.interfaces.Movible;
import com.miravent.modelo.interfaces.Pintable;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * Realiza todas las acciones desde el inicio hasta el final del juego en un nuevo hilo.
 * @author Sergio
 *
 */
public class Juego extends Thread{

	private static final int PUNTOS_GOLPEO = 100; 
	private static final int FPS = 60;
	private static final int APS = 60;
	
	private final Canvas ZONA_JUEGO;
	private final Pelota PELOTA;
	
	public final Jugador JUGADOR;
	
	private static boolean iniciado;
	
	private long tiempoDeJuego;
	
	public Juego(Canvas zonaJuego) {
		
		this.ZONA_JUEGO = zonaJuego;
		this.JUGADOR = new Jugador(posInicioJugador());
		this.PELOTA = new Pelota(posInicioPelota());
		
		
	}
	
	@Override
	public void run() {
		
		pintarTodo();
		try {
			
			sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		bucleJuego();
		finalJuego();
		
	}
	
	
	/**
	 * Es el elemento principal del juego, el cuál desde que se incia hasta que la pelota cae, se encarga del movimiento,
	 * las comprobaciones y el pintado de los componentes del juego.
	 */
	private void bucleJuego() {
		
		iniciado = true;
		
		double nsPorSegundoFPS = 1000000000/FPS;
		double nsPorSegundoAPS = 1000000000/APS;
		
		double render = 0;
		double delta = 0;
	
		long tiempoActual;
		long tiempoTranscurrido = System.nanoTime();
		long inicioJuego = System.currentTimeMillis()/1000;
		
		while(iniciado) {
			tiempoDeJuego = (System.currentTimeMillis() / 1000) - inicioJuego ;
			
			
			//Almacena el tiempo de la vuelta del bucle.
			tiempoActual = System.nanoTime();
			/*
			 * Almacenamos la cantidad de Frames y de Actualizaciones que corresponden dependiendo
			 * del tiempo transcurrido entre vueltas de bucle para obtener las cantidades límites
			 * establecidas.
			 */
			delta += (tiempoActual - tiempoTranscurrido) / nsPorSegundoAPS;
			render += ((tiempoActual - tiempoTranscurrido) / nsPorSegundoFPS);
			tiempoTranscurrido = tiempoActual;
			

			
			/*
			 * Cuando el valor de delta corresponda a una actualización o más se ejecutará el búcle
			 * actualizando los elementos la cantidad de veces almacenadas.
			 */
			while(delta >= 1) {
				
				movimientoElementos();
				delta--;
				
			}
			
			/*
			 * Cuando el valor de delta corresponda a una impresión o más se ejecutará el búcle
			 * dibujando los elementos la cantidad de veces almacenadas.
			 */
			while(render >= 1) {
				
				pintarTodo();
				render--;
				
			}
			
			//Se duerme el hilo para aumentar la eficiencia y reducir el consumo de recursos.
			
			try {
				
				sleep(0,(int) ((delta)*100000));
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			
			
		}
		
	}
	
	/**
	 * Se debe llamar a este método al finalizar el juego para que antes de acabar la ejecución del hilo,
	 * se cambie la ventana del juego por el menú de puntuciones.
	 */
	private void finalJuego() {
		
		//Ejecuta un subhilo perteneciente al hilo principal de JavaFX para que pueda ser cambiada la escena de la interfaz.
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				
				Stage stage = (Stage) ZONA_JUEGO.getScene().getWindow();
				
				try {
				
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/miravent/vista/VentanaPuntuacion.fxml"));
					stage.setScene(new Scene(root));
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	/**
	 * Agrupa todas las llamadas al método mover de la interfaz {@link Movible} de los elementos del juego
	 * y además comprueba que si en esos movimientos llega a ser golpeada la pelota por la pala.
	 */
	private void movimientoElementos() {
		
		PELOTA.mover(ZONA_JUEGO);
		JUGADOR.getPalaJugador().mover(ZONA_JUEGO);
		comprobacionGolpeo();
		
	}
	
	/**
	 * Agrupa el dibujado de todos los elementos que implementas la interfaz {@link Pintable} y los demás
	 * elementos que se dibujarán en el juego.
	 */
	private void pintarTodo() {
		
		GraphicsContext gc = ZONA_JUEGO.getGraphicsContext2D();
		
		gc.setFill(Color.GREY);
		gc.fillRect( 0, 0, ZONA_JUEGO.getWidth(), ZONA_JUEGO.getHeight());
		
		JUGADOR.getPalaJugador().pintar(gc);
		PELOTA.pintar(gc);
		
		pintarPuntuacion(gc);
		pintarTemporizador(gc);
		
	}
	
	/**
	 * Pinta la puntuación del jugador en la parte superior derecha del juego.
	 * @param gc
	 */
	private void pintarPuntuacion(GraphicsContext gc) {
		
		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.RIGHT);
		gc.fillText(String.valueOf(JUGADOR.getPuntuacion().getPuntos()), ZONA_JUEGO.getWidth() - 10, 15);
		
	}
	
	/**
	 * Pinta el tiempo que se lleva jugando en la parte superior izquierda del juego.
	 * @param gc
	 */
	private void pintarTemporizador(GraphicsContext gc) {

		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.LEFT);
		gc.fillText(obtenerFormatoTiempoJuego(), 10, 15);
		
	}
	
	

	/**
	 * Formatea el tiempo que lleva el juego iniciado(en milisegundos) a un formato
	 * de horas:minutos:segundos.
	 * @return
	 */
	private String obtenerFormatoTiempoJuego() {
		
		int segundos = (int) (tiempoDeJuego % 60);
		int minutos = (int) (tiempoDeJuego / 60) % 60;
		int horas = (int) (tiempoDeJuego / 120) % 60;
		
		String formato = "%02d:%02d:%02d";
		formato = String.format(formato, horas, minutos, segundos);
		
		return formato;
		
	}
	
	/**
	 * Se encarga de subir la dificultad del juego. A partir de la puntuación del jugador.
	 * Por cada 500 puntos que gane el jugador se decrementara el tamaño de la pelota y de la pala.
	 * Por cada 1000 puntos que gane el jugador se incrementara la velocidad de la pelota y de la pala.
	 */
	private void subidaNivel() {
		
		if(JUGADOR.getPuntuacion().getPuntos() % 500 == 0) {
			
			PELOTA.decrementarRadio();
			JUGADOR.getPalaJugador().decrementarLongitud();
			
		}
		
		if(JUGADOR.getPuntuacion().getPuntos() % 1000 == 0) {
			
			PELOTA.incrementarVelocidad();
			JUGADOR.getPalaJugador().incrementarVelocidad();
			
		}
		
	}
	
	
	/**
	 * Comprueba cada golpeo de la pelota y una vez se produce se suman los puntos al jugador y llama al
	 * método encargado de la subida de la dificultad.
	 */
	private void comprobacionGolpeo() {
		
		boolean golpeado = JUGADOR.getPalaJugador().golpeo(PELOTA);
		
		if(golpeado) {
			
			JUGADOR.sumarPuntosGolpeo(PUNTOS_GOLPEO);
			subidaNivel();

		}
	}

	
	/**
	 * Crea y devuelve la posición donde comienza el jugador.
	 * @return
	 */
	private Point2D posInicioJugador() {
		
		double x = ZONA_JUEGO.getWidth()/2 - Pala.LONGITUD_INICIAL/2;
		double y = ZONA_JUEGO.getHeight() - (ZONA_JUEGO.getHeight()/12 - Pala.ANCHO/2);
		
		return new Point2D(x, y);
		
	}

	
	/**
	 * Crea y devuelve la posición donde comienza la pelota.
	 * @return
	 */
	private Point2D posInicioPelota() {
		
		double x = ZONA_JUEGO.getWidth()/2  - Pelota.RADIO_INICIAL;
		double y = ZONA_JUEGO.getHeight()/12;
		
		return new Point2D(x, y);
		
	}

	public static void setIniciado(boolean iniciado) {
		
		Juego.iniciado = iniciado;
		
	}
	
	
}
