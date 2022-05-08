package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;
import com.retur.paint.modelo.funciones.ApoyoControladores;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

public class SelectorColor extends Herramienta {

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/cuentaGotas.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 5;
	private static final double COLOCACION_CURSO_Y = DIMENSION_CURSOR;
	
	private static SelectorColor instance;
	
	private SelectorColor() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,DIMENSION_CURSOR,DIMENSION_CURSOR,true,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
		
	}
	
	public static SelectorColor getInstance() {
		
		if(instance == null) {
			
			instance = new SelectorColor();
			
		}
		
		return instance;
		
	}

	
	public void obtenerColor(int x, int y, Lienzo lienzo, ColorSeleccionado colorSeleccionado) {
		
		String color = null;
		
		if(lienzo.LIENZO[y][x] == null || lienzo.LIENZO[y][x].equals("")) {
			
			color = "#FFFFFF";
			
		}else {
			
			color = lienzo.LIENZO[y][x];
			
		}
		
		colorSeleccionado.setColor(color);
		ApoyoControladores.pintarCanvasBotones(colorSeleccionado);
		System.out.println(color);
		
	}
	
	
}
