package com.retur.paint.modelo.elementos.pintura;





import com.retur.paint.modelo.elementos.herramientas.Herramienta;
import com.retur.paint.modelo.elementos.interfaces.Pintable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Lienzo implements Pintable {

	private final AnchorPane ANCHOR_LIENZO;
	public final Canvas CANVAS_LIENZO;
	public final int ALTO_LIENZO;
	public final int ANCHO_LIENZO;
	private int posRatonX;
	private int posRatonY;
	
	
	public Lienzo(int ancho,int alto, AnchorPane zonaLienzo, Herramienta herramientaSeleccionada) {
		
		ALTO_LIENZO = alto;
		ANCHO_LIENZO = ancho;
		
		ANCHOR_LIENZO = new AnchorPane();
		ANCHOR_LIENZO.getStyleClass().add("lienzo");
		ANCHOR_LIENZO.setLayoutX(10);
		ANCHOR_LIENZO.setLayoutY(10);
		ANCHOR_LIENZO.setPrefWidth(ancho);
		ANCHOR_LIENZO.setPrefHeight(alto);
		
		CANVAS_LIENZO = new Canvas(ancho,alto);
		
		ANCHOR_LIENZO.getChildren().add(CANVAS_LIENZO);
		AnchorPane.setTopAnchor(ANCHOR_LIENZO, 10.0);
		AnchorPane.setLeftAnchor(ANCHOR_LIENZO, 10.0);
		zonaLienzo.getChildren().add(ANCHOR_LIENZO);
		
		cambiarCursor(herramientaSeleccionada);
		
	}
	
	public void pintarLienzo(int x, int y, Color color) {
		
		GraphicsContext gc = CANVAS_LIENZO.getGraphicsContext2D();
		
		gc.setFill(color);
		gc.fillRect(x, y, 1, 1);
		
	}


	@Override
	public void pintado(Color[][] zonaColorear) {
		
		int posPintandoXInicial = posRatonX - zonaColorear[0].length/2;
		int posPintandoY = posRatonY - zonaColorear.length/2;
		
		for(int i = 0; i < zonaColorear.length; i++) {
			int posPintandoX = posPintandoXInicial;
			if(posPintandoY < 0 || posPintandoY >= ALTO_LIENZO) {
				
				posPintandoY++;
				continue;
				
			}
			
			for(int j = 0; j < zonaColorear[i].length; j++) {
				
				if(posPintandoX < 0 || posPintandoX >= ANCHO_LIENZO) {
					
					posPintandoX++;
					continue;
					
				}
				
				if(zonaColorear[i][j] != null) {
					
					pintarLienzo(posPintandoX, posPintandoY, zonaColorear[i][j]);
					
				}
				
				posPintandoX++;
				
			}
			
			posPintandoY++;
			
		}
		
	}
	
	public void cambiarCursor(Herramienta herramienta) {
		
		CANVAS_LIENZO.setCursor(herramienta.ESTILO_CURSOR);
		
	}

	public int getPosRatonX() {
		
		return posRatonX;
		
	}
	
	public void setPosRaton(int posRatonX, int posRatonY) {
		
		this.posRatonX = posRatonX;
		this.posRatonY = posRatonY;
		
	}	

	public int getPosRatonY() {
		
		return posRatonY;
		
	}


	
	
	
}
