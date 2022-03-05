package modelo;



import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Pelota {

	private final int VELOCIDAD = 5;
	private final Circle PELOTA;
	private final Jugador JUGADOR;
	private final Canvas FONDO_CANVAS;
	private double x;
	private double y;
	private boolean xPositivo;
	private boolean yPositivo;
	
	public Pelota(Circle pelota, Canvas canvas, Jugador jugador) {
	
		this.PELOTA = pelota;
		this.JUGADOR = jugador;
		this.FONDO_CANVAS = canvas;
		this.x = pelota.getLayoutX();
		this.y = pelota.getLayoutY();
		this.xPositivo = true;
		this.yPositivo = true;
		
		
	}
	
	public void movimientoPelota(){
		
		
		if(x + (PELOTA.getRadius()*2) >= FONDO_CANVAS.getWidth()) {
			
			xPositivo = false;
			
		}
		
		if(x - PELOTA.getRadius() <= 0) {
			
			xPositivo = true;
			
		}
		
		if(y - PELOTA.getRadius() <= 0) {
			
			yPositivo = true;
			
		}

		
		golpesJugador();
		
		if(y + (PELOTA.getRadius()*2) >= FONDO_CANVAS.getHeight()) {
			
		//Poner derrorta.
			
			
		}else {
			
			if(xPositivo) {
				x += VELOCIDAD;
			}else {
				x -= VELOCIDAD;
			}
			
			if(yPositivo) {
				y += VELOCIDAD;
			}else {
				y -= VELOCIDAD;
			}
		}
		
		
		
		PELOTA.relocate(x, y);
		
		
	}
	
	
	private void golpesJugador() {
	
		Shape interseccion = Shape.intersect(PELOTA, JUGADOR.getPALA());
		if(interseccion.getBoundsInLocal().getWidth() != -1) {
			yPositivo = false;
		}
		
	}
	
	
	
	
}
