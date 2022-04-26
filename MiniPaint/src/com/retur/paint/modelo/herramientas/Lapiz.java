package com.retur.paint.modelo.herramientas;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;



public class Lapiz extends HerramientaDibujo {

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/lapiz.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = 0;
	
	
	public Lapiz() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,DIMENSION_CURSOR,DIMENSION_CURSOR,false,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
		
	}
	

	@Override
	protected boolean[][] crearPrimerRango() {
		
		boolean[][] rango = {{true}};
		
		return rango;
		
	}


	@Override
	protected boolean[][] crearSegundoRango() {

		boolean[][] rango = {
							{true, true},
							{true, true}
							};
	
		return rango;
		
	}


	@Override
	protected boolean[][] crearTercerRango() {
		
		boolean[][] rango = {
							{false, true, false},
				 			{true, true, true},
				 			{false, true, false}
				 			};

		return rango;
		
	}


	@Override
	protected boolean[][] crearCuartoRango() {
		
		boolean[][] rango = {
							{false, true, true, false},
							{true, true, true, true},
							{true, true, true, true},
							{false, true, true, false}
							};

		return rango;
		
	}
	
	

}
