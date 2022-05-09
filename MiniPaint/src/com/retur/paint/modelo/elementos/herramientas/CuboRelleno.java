package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

public class CuboRelleno extends Herramienta{

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/cuboRelleno").toURI().toString();
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
	
	public void rellenar(int xInicial, int yInicial, String color, String[][] lienzo) {
		
		for(int y = yInicial - 1 ; y <= yInicial + 1; y++) {
			
			if(y < 0 || y >= lienzo.length || y == yInicial) {
				
				continue;
				
			}
			
			for(int x = xInicial - 1; x <= xInicial + 1; x++) {
				
				if(x < 0 || x >= lienzo[0].length || x == xInicial) {
					
					continue;
					
				}
				
				if(lienzo[y][x] == null || lienzo[y][x].equals("")) {
					
					rellenar(x, y, color, lienzo);
					
				}else {
					
					lienzo[yInicial][xInicial] = color;
					
				}
				
				
			}
			
		}
		
	}
	
}
