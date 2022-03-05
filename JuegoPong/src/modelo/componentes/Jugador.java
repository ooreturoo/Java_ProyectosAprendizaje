package modelo.componentes;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Rectangle;

public class Jugador {

	private final Rectangle RECTANGULO;
	private final Canvas CANVAS;
	
	public Jugador(Rectangle rectangulo, Canvas canvas) {
		
		this.RECTANGULO = rectangulo;
		this.CANVAS = canvas;
		
	}
	
}
