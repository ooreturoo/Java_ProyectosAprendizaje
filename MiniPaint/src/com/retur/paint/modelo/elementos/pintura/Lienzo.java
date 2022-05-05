package com.retur.paint.modelo.elementos.pintura;





import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Lienzo {

	private final AnchorPane ANCHOR_LIENZO;
	public final Canvas CANVAS_LIENZO;
	public final int ALTO_LIENZO;
	public final int ANCHO_LIENZO;
	private final String[][] dimensionLienzo;
	private int posRatonX;
	private int posRatonY;
	
	
	public Lienzo(int ancho,int alto, ScrollPane zonaLienzo) {
		
		ANCHOR_LIENZO = new AnchorPane();
		ANCHOR_LIENZO.setPrefWidth(ancho);
		ANCHOR_LIENZO.setPrefHeight(alto);
		
		
		CANVAS_LIENZO = new Canvas(ancho,alto);
		
		ANCHOR_LIENZO.getChildren().add(CANVAS_LIENZO);
		zonaLienzo.setContent(ANCHOR_LIENZO);
		ALTO_LIENZO = alto;
		ANCHO_LIENZO = ancho;
		dimensionLienzo = new String[ALTO_LIENZO][ANCHO_LIENZO];
		
	}
	
	public String obtenerColorPixel(int x, int y) {
		
		return dimensionLienzo[y][x];
		
	}
	
	public void rellenarColorPixel(int x, int y, String colorHex) {
		

		dimensionLienzo[y][x] = colorHex;
		pintar(x, y);
			
		
		
	}
	
	
	//TODO Cambiar de lugar y modificar.
	private void pintar(int x, int y) {
		
		GraphicsContext gc = CANVAS_LIENZO.getGraphicsContext2D();
		gc.setFill(Color.web(dimensionLienzo[y][x]));
		gc.fillRect(x, y, 1, 1);
		

	}

	public int getPosRatonX() {
		return posRatonX;
	}

	public void setPosRatonX(int posRatonX) {
		this.posRatonX = posRatonX;
	}

	public int getPosRatonY() {
		return posRatonY;
	}

	public void setPosRatonY(int posRatonY) {
		this.posRatonY = posRatonY;
	}

	

	
	
	
}
