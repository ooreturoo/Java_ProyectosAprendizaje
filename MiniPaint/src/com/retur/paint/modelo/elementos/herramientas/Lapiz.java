package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import com.retur.paint.modelo.elementos.interfaces.Pintable;
import com.retur.paint.modelo.elementos.interfaces.Pintor;


import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;



public final class Lapiz extends HerramientaDibujo implements Pintor{

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/lapiz.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = DIMENSION_CURSOR - 6;
	
	private static Lapiz instance;
	
	private Lapiz() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,DIMENSION_CURSOR,DIMENSION_CURSOR,true,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
		usarPrimerRango();

	}
	
	public static Lapiz getInstance() {
		
		if(instance == null) {
			
			instance = new Lapiz();
			
		}
		
		return instance;
		
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

	@Override
	public void pintar(Color color, Pintable pintable) {
		
		Color zonaColorear[][] = new Color[rangoDibujo.length][rangoDibujo[0].length];
		
		for(int i = 0; i < zonaColorear.length; i++) {
			
			for(int j = 0; j < zonaColorear[i].length; j++) {
				
				if(rangoDibujo[i][j]) {
					
					zonaColorear[i][j] = color;
					
				}
				
			}
			
			
		}
		
		
		pintable.pintado(zonaColorear);
		
	}
	
	

}
