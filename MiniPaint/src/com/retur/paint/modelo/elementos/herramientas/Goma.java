package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import com.retur.paint.modelo.elementos.interfaces.Pintable;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

public final class Goma extends HerramientaDibujo {

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/gomaSeleccionada.jpg").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = 0;
	
	private static Goma instance;
	
	private Goma() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,5,5,false,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
		usarTercerRango();
		
	}
	
	public static Goma getInstance() {
		
		if(instance == null) {
			
			instance = new Goma();
			
		}
		
		return instance;
		
	}

	@Override
	protected boolean[][] crearPrimerRango() {
		
		boolean[][] rango = {
				{true, true, true, true},
				{true, true, true, true},
				{true, true, true, true},
				{true, true, true, true}
				};

		return rango;
		
	}

	@Override
	protected boolean[][] crearSegundoRango() {

		boolean[][] rango = {
				{true, true, true, true, true, true},
				{true, true, true, true, true, true},
				{true, true, true, true, true, true},
				{true, true, true, true, true, true},
				{true, true, true, true, true, true},
				{true, true, true, true, true, true}
				};

		return rango;
		
	}

	@Override
	protected boolean[][] crearTercerRango() {
		
		boolean[][] rango = {
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true}
				};

		return rango;
		
	}

	@Override
	protected boolean[][] crearCuartoRango() {
	
		boolean[][] rango = {
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true},
				};

		return rango;
		
	}

	@Override
	public void pintar(String color, Pintable pintable) {
		String zonaColorear[][] = new String[rangoDibujo.length][rangoDibujo[0].length];
		
		for(int i = 0; i < zonaColorear.length; i++) {
			
			for(int j = 0; j < zonaColorear[i].length; j++) {
				
				if(rangoDibujo[i][j]) {
					
					zonaColorear[i][j] = "";
					
				}
				
			}
			
			
		}
		
		
		pintable.pintado(zonaColorear);
		
	}


}
