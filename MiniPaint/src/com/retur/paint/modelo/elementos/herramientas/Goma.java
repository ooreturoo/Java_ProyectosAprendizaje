package com.retur.paint.modelo.elementos.herramientas;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;

public class Goma extends HerramientaDibujo {

	private static final String DIR_IMAGEN_CURSOR = new File("src/resources/images/goma.png").toURI().toString();
	private static final double COLOCACION_CURSO_X = 0;
	private static final double COLOCACION_CURSO_Y = 0;
	
	private static Goma instance;
	
	private Goma() {
		
		super(new ImageCursor(new Image(DIR_IMAGEN_CURSOR,DIMENSION_CURSOR,DIMENSION_CURSOR,false,false), COLOCACION_CURSO_X, COLOCACION_CURSO_Y));
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
				{true, true, true},
				{true, true, true},
				{true, true, true}
				};

		return rango;
		
	}

	@Override
	protected boolean[][] crearCuartoRango() {
	
		boolean[][] rango = {
							{true, true, true, true},
							{true, true, true, true},
							{true, true, true, true},
							{true, true, true, true}
							};

		return rango;
		
	}

	@Override
	public void seleccionado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deseleccionado() {
		// TODO Auto-generated method stub
		
	}

}
