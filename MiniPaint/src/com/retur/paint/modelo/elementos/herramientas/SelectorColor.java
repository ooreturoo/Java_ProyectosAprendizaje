package com.retur.paint.modelo.elementos.herramientas;


import java.io.File;

import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;
import com.retur.paint.modelo.funciones.ApoyoControladores;

import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;

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

	
	public void obtenerColor(int x, int y, Canvas lienzo, ColorSeleccionado colorSeleccionado) {
		
		Color color = null;
		//TODO con el robot no funciona. buscar una manera de obtener el color del pixel del canvas
		Robot robot = new Robot();
		color = robot.getPixelColor(x + lienzo.getLayoutX(),y + lienzo.getLayoutY());
		System.out.println(color);
		
		colorSeleccionado.setColor(color);
		ApoyoControladores.pintarCanvasBotones(colorSeleccionado);
		
	}
	
	
}
