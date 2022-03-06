package modelo.juego;




import controlador.ControladorVentana;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import modelo.componentes.Jugador;
import modelo.componentes.Pelota;

public class Juego {

	private ControladorVentana controlador;
	private Canvas canvas;
	private AnimationTimer timer;
	private Pelota pelota;
	private Jugador jugador;
	private boolean pausado;
	
	public Juego(ControladorVentana controlador, Pelota pelota, Jugador jugador) {
		
		this.controlador = controlador;
		this.canvas = controlador.getFondoCanvas();
		this.pelota = pelota;
		this.jugador = jugador;
		
	}
	
	private void gameLoop() {
		
		long tiempoInicio = System.nanoTime();
		timer = new AnimationTimer() {
			
			
			
			@Override
			public void handle(long tiempoActual) {
				long tiempo = (tiempoActual - tiempoInicio) / 1000000000;
				
				temporizador(tiempo);
				controlador.getPuntuacion().setText(jugador.getPuntos() +"");
				
				
				ColisionesObjetos.colisionesPelota(pelota, jugador, canvas, Juego.this);
				ColisionesObjetos.colisionesJugador(jugador, canvas);
				
			}
		};
		
		timer.start();
		
	}
	
	
	public void inicioJuego() {

		gameLoop();
		
	}
	
	
	public void finJuego() {
		timer.stop();
		
		String puntuacionDerrota = controlador.getPuntuacionD().getText();
		puntuacionDerrota = puntuacionDerrota.replace("X", jugador.getPuntos() +"");
		controlador.getPuntuacionD().setText(puntuacionDerrota);
		controlador.getbRestart().setVisible(true);
		controlador.gettDerrota().setVisible(true);
		controlador.getPuntuacionD().setVisible(true);
		
		
		
	}
	
//	public void pausaJuego() throws InterruptedException {
//		
//	
//	}
	
	
	public void restartJuego() {
		
		controlador.gettDerrota().setVisible(false);
		controlador.getPuntuacionD().setVisible(false);
		controlador.getbRestart().setVisible(false);
		resetearPuntos();
		
		
		inicioJuego();
		
	}
	
	private void resetearPuntos() {
		
		jugador.setPuntos(0);
		controlador.getPuntuacion().setText("0");
		
	}

	
	private void temporizador(long tiempo) {
		
		int segundos = (int) (tiempo%60);
		int minutos = (int) (tiempo / 60) %60;
		int horas = (int) (tiempo / 120) % 60;
		
		String formato = "%02d:%02d:%02d";
		formato = String.format(formato, horas, minutos, segundos);
		controlador.getTemporizador().setText(formato);
		
	}

	public boolean isPausado() {
		return pausado;
	}

	public Jugador getJugador() {
		return jugador;
	}

	
}
