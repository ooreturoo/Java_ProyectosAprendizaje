package modelo.juego;



import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import modelo.componentes.Jugador;
import modelo.componentes.Pelota;

public class Juego {

	private static AnchorPane RAIZ;
	private static AnimationTimer timer;
	private static Pelota pelota;
	private static Jugador jugador;
	private static boolean iniciado;
	private static double temporizador;
	private static int puntos;
	
	
	private static void gameLoop() {
		
		timer = new AnimationTimer() {
			
			@Override
			public void handle(long tiempoEjecucion) {
				
				pelota.movimientoPelota();
				
			}
		};
		
		timer.start();
		
	}
	
	
	public static void inicioJuego() {
		
		iniciado = true;
		gameLoop();
		
	}
	
	public static void finJuego() {
		
		timer.stop();
		Button restart = new Button("RESTART");
		restart.resize(100, 100);
		restart.setLayoutX(RAIZ.getWidth()/2 - restart.getWidth());
		restart.setLayoutY(RAIZ.getHeight()/2 - restart.getHeight());
		RAIZ.getChildren().add(restart);
		
	}
	
	public static void pausaJuego() {
		
	}


	public static void setPelota(Pelota pelota) {
		Juego.pelota = pelota;
	}


	public static void setJugador(Jugador jugador) {
		Juego.jugador = jugador;
	}
	

	public static void setRAIZ(AnchorPane rAIZ) {
		RAIZ = rAIZ;
	}


	public static boolean isIniciado() {
		return iniciado;
	}


	
	
	
	
	
	
	
	
}
