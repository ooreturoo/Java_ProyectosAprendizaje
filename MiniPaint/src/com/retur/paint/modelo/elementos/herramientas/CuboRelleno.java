package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import com.retur.paint.modelo.elementos.pintura.Lienzo;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

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
	
	public void rellenar(int xInicial, int yInicial, Lienzo lienzo, String color) {
		
		for(int y = yInicial - 1 ; y <= yInicial + 1; y++) {
			
			if(y < 0 || y >= lienzo.LIENZO.length) {
				
				continue;
				
			}
			
			for(int x = xInicial - 1; x <= xInicial + 1; x++) {
				
				if(x < 0 || x >= lienzo.LIENZO[0].length) {
					
					continue;
					
				}
				
				if((lienzo.LIENZO[y][x] == null || lienzo.LIENZO[y][x].equals("")) && x < 50 && y < 50) {
					
					lienzo.LIENZO[y][x] = color;
					lienzo.pintarCanvas(x,y);
					rellenar(x, y, lienzo, color);
					
				}
				
			}
			
		}
		
		
		
	}
	
}
