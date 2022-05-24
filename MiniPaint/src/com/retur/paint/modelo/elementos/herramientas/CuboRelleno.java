package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class CuboRelleno extends Herramienta{

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/cuboRelleno.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = 0;
	
	private static CuboRelleno instance;
	
	private CuboRelleno() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,5,5,false,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
		
	}

	public static CuboRelleno getInstance() {
		
		if(instance == null) {
			
			instance = new CuboRelleno();
			
		}
		
		return instance;
		
	}
	
	public void rellenar(int xInicial, int yInicial, Color color) {
		
	
		
		
		
	}
	
}
