package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.ZoomEvent;

public class Lupa extends Herramienta{

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/lupa.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = 0;
	
	private static Lupa instance;
	
	private Lupa() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,32,38,true,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
	
	}
	
	public static Lupa getInstance() {
		
		if(instance == null) {
			
			instance = new Lupa();
			
		}
		
		return instance;
		
	}
	
	public void hacerZoom(Node nodo, double x, double y) {
		
		ZoomEvent.fireEvent(nodo, 
				new ZoomEvent(null,
				nodo,
				ZoomEvent.ZOOM,
				x,
				y,
				nodo.getLayoutX(),
				nodo.getLayoutY(),
				false,
				false,
				false,
				false,
				false,
				false,
				20.0,
				100.0,
				null));
				
		
		
	}
	
	public void quitarZoom() {
		
		
	}

}
