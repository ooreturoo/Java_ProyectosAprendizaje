package com.retur.paint.modelo.elementos.interfaces;

import javafx.scene.paint.Color;

public interface Pintor {

	
	/**
	 * El metodo lo sobreescribira cualquier herramienta que pinte en el lienzo con algún tipo
	 * de color.
	 * @param color
	 * @param pintable
	 */
	void pintar(Color color, Pintable pintable);
	
}
