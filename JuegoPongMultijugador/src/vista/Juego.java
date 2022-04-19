package vista;


import javafx.animation.AnimationTimer;
import modelo.elementos.Jugador;
import modelo.elementos.Pelota;
import modelo.elementos.Temporizador;

public class Juego implements Runnable {
	
	private VistaJuego ventana;
	private Jugador jugador1;
	private Jugador jugador2;
	private Pelota pelota;
	private Temporizador tiempo;
	
	public Juego() {
		
		ventana = new VistaJuego();
		jugador1 = new Jugador("s", ventana.getPala1());
		jugador2 = new Jugador("", ventana.getPala2());
		pelota = new Pelota(ventana.getPelota());
		
	}

	@Override
	public void run() {
		
		cicloJuego();
		
	}
	
	public void start() {
		
		run();
		
	}
	
	
	public void ventanaPrincipal() {
		
		
		
		
	}
	
	public void cicloJuego() {
		
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				
				pelota.movimientoPelota(ventana.getRaiz().getLayoutX(),
						ventana.getRaiz().getLayoutY(),
						ventana.getRaiz().getWidth(),
						ventana.getRaiz().getHeight(),
						jugador1);
				
				ventana.getFondoPrincipal()
				.getGraphicsContext2D()
				.clearRect(0, 0, ventana.getRaiz().getWidth(), ventana.getRaiz().getHeight());
			}
		};
		
		timer.start();
		
	}

}
