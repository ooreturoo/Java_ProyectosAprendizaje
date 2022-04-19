package com.retur.modelo.juego.clases;


import java.io.File;

import com.retur.modelo.juego.Juego;
import com.retur.modelo.juego.interfaces.Disparable;
import com.retur.vista.VentanaPrincipal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Volador extends Thread implements Disparable{

	private static final int VELOCIDAD_DEFECTO = 3;
	private static final int DIMENSION_IMAGEN_ELIMINADO = 70;

	
	private final Image IMAGEN_DISPARADO;
	private final Image IMAGEN_VOLADOR;
	private final int DESPAWN;
	private final int DIMENSION_IMAGEN;
	private final int MAX_SPAWN_Y;
	private final int DANYO;
	private final int PUNTOS;
	private final double ANCHO_VENTANA;
	private final double ALTO_VENTANA;
	private final Jugador JUGADOR;
	
	private double x;
	private double y;
	private int velocidad;
	private boolean recorridoFinalizado;
	private boolean disparado;
	private Rectangle contornoColision;
	
	public Volador(int dimensionImagen, File imgVolador, int danyo, int puntos, Jugador jugador, VentanaPrincipal vp) {
		
		this.DIMENSION_IMAGEN = dimensionImagen;
		ANCHO_VENTANA = vp.ANCHO_VENTANA;
		ALTO_VENTANA = vp.ALTO_VENTANA;
		this.IMAGEN_DISPARADO = new Image(new File("./src/resources/disparado.png").toURI().toString(),
								DIMENSION_IMAGEN_ELIMINADO,
								DIMENSION_IMAGEN_ELIMINADO,
								true,
								false);
		
		this.IMAGEN_VOLADOR = new Image(imgVolador.toURI().toString(),
								DIMENSION_IMAGEN,
								DIMENSION_IMAGEN,
								true,
								false);
		
		this.DESPAWN = -DIMENSION_IMAGEN;
		this.MAX_SPAWN_Y = (int) (ALTO_VENTANA / 2.5);
		this.DANYO = danyo;
		this.PUNTOS = puntos;
		this.contornoColision = new Rectangle(x,y,DIMENSION_IMAGEN,DIMENSION_IMAGEN);
		this.x = ANCHO_VENTANA + DIMENSION_IMAGEN;
		this.y = generadorSpawnY();
		this.velocidad = VELOCIDAD_DEFECTO;
		this.JUGADOR = jugador;
	
	}
	
	private void mover() {
		
		if(x <= DESPAWN) {
			
			recorridoFinalizado = true;
			
		}else {
			
			if(!disparado) {
				
				x -= velocidad;
				
			}else {
				
				
				try {
					sleep(500);
					recorridoFinalizado = true;
					this.join();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
		
		contornoColision.relocate(x, y);
		
	}
	
	/**
	 * Se encarga de pintar el objeto en el canvas y dependiendo del valor de disparado
	 * pintara una imagen u otra.
	 * @param gc Recibe un GraphicsContext.
	 */
	public void pintar(GraphicsContext gc) {
		
		if(!recorridoFinalizado) {
			
			if(disparado) {
				
				gc.drawImage(IMAGEN_DISPARADO, x, y);
				
			}else {
				gc.setStroke(Color.RED);
				gc.strokeRect(x,y,DIMENSION_IMAGEN,DIMENSION_IMAGEN);
				gc.drawImage(IMAGEN_VOLADOR, x, y);
				
			}
			
		}
		
	}
	
	/**
	 * Genera la cordenada de 'y' donde hará spawn el objeto.
	 * @return
	 */
	private int generadorSpawnY() {

		return (int) (Math.random() * MAX_SPAWN_Y);
	}


	@Override
	public void run() {
		
		long nsPorSegundo = 1000000000 / Juego.APS;
		long ultimaActualizacion = System.nanoTime();
		double delta = 0;
		long tiempoActualBucle;
		
		while(!recorridoFinalizado) {
			
			tiempoActualBucle = System.nanoTime();
			
			delta += (tiempoActualBucle - ultimaActualizacion) / nsPorSegundo;
			
			while(delta >= 1) {
				mover();
				disparado();
				ultimaActualizacion = System.nanoTime();
				delta--;
			}
			
			
		}
		
		System.out.println("Hilo acabado");
		
	}
	
	@Override
	public void disparado() {
		
		if(JUGADOR.MIRILLA.getDisparo() != null) {
			
			if(JUGADOR.MIRILLA.getDisparo().getRangoColision() != null) {
				
				Shape colision = Shape.intersect(JUGADOR.MIRILLA.getDisparo().getRangoColision(),contornoColision);
				
				if(colision.getLayoutBounds().getWidth() != -1 || colision.getLayoutBounds().getHeight() != -1) {
					
					disparado = true;
					
				}
				
			}
			
		}
		
		
		
		
//		if(this instanceof Pajaro) {
//			
//			if(jugador.getVidas()-DANYO <= 0) {
//				
//				jugador.setVidas(jugador.getVidas() - DANYO);
//				
//			}else {
//				
//				jugador.setVidas(0);
//				
//			}
//			
//		}else {
//			
//			jugador.setPuntos(PUNTOS);
//			
//		}
		
	}
	
	@Override
	public void salvado() {
		
		recorridoFinalizado = true;
		
		if(this instanceof Plato) {
			
			JUGADOR.setPuntos(JUGADOR.getPuntos() - DANYO);
			
		}else {
			
			JUGADOR.setPuntos(JUGADOR.getPuntos() + PUNTOS);
			
		}
		
	}

	public boolean isRecorridoFinalizado() {
		return recorridoFinalizado;
	}

	public Rectangle getContornoColision() {
		return contornoColision;
	}

	


	
	
	
}
