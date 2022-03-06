package modelo.juego;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import modelo.componentes.Jugador;
import modelo.componentes.Pelota;

public class ColisionesObjetos {

	public static void colisionesPelota(Pelota pelota, Jugador jugador, Canvas canvas, Juego juego) {
		
		Circle circuloP = pelota.getCIRCULO();
		double x = circuloP.getLayoutX();
		double y = circuloP.getLayoutY();
		
		if(x + circuloP.getRadius()>= canvas.getWidth()) {
			
			pelota.setxDerecha(false);
			
		}else if(x - circuloP.getRadius() <= 0) {
			
			pelota.setxDerecha(true);
			
		}
		
		if(y - circuloP.getRadius() <= 0) {
			
			pelota.setyAbajo(true);
			
		}else if(golpeoJugador(circuloP, jugador.getRECTANGULO())){
			
			pelota.setyAbajo(false);
			
			jugador.sumarPuntosGolpeo();
			
		}
		
		if(y + circuloP.getRadius() >= canvas.getHeight()) {
			
			pelota.posicionInicial();
			jugador.posicionInicial();
			juego.finJuego();
			
		}else {
			
			pelota.movimientoPelota();
			
		}
	
			
		
		
		//TODO Añadir colisión con Jugador
	}	
		
	
	private static boolean golpeoJugador(Circle pelota, Rectangle jugador) {
		
		Shape colision = Shape.intersect(jugador, pelota);
		
		return colision.getLayoutBounds().getWidth() != -1;
		
	}


	public static void colisionesJugador(Jugador jugador, Canvas canvas) {
		
		Rectangle rectanguloJ =  jugador.getRECTANGULO();
		double x = rectanguloJ.getLayoutX();
		
		
		if(x + rectanguloJ.getWidth() >= canvas.getWidth()){
			
			jugador.setMovimientoDerecha(false);
			
		}
		
		if ( x <= 0) {
			
			jugador.setMovimientoIzquierda(false);
			
		}
		
		jugador.movimientoJugador();
		
		
	}

}
