package com.retur.modelo.juego.clases;

import javafx.scene.shape.Rectangle;

public class Disparo extends Thread{
	
	private Rectangle rangoColision;

	public Disparo() {}

	@Override
	public void run() {
		try {
			sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rangoColision = null;
	}

	public Rectangle getRangoColision() {
		return rangoColision;
	}

	public void setRangoColision(Rectangle rangoColision) {
		this.rangoColision = rangoColision;
	}
	
	
	
	
	
	
	
	
}
