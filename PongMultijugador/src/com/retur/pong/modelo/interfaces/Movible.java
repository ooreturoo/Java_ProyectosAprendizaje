package com.retur.pong.modelo.interfaces;

import javafx.scene.canvas.Canvas;

public interface Movible {

	void mover(Canvas superficieMovimiento);
	
	void restablecerPosicionInicial();
	
}
