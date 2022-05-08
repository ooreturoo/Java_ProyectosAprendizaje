package com.retur.paint.modelo.elementos.interfaces;

public interface Pintor {

	
	/**
	 * El metodo lo sobreescribira cualquier herramienta que pinte en el lienzo con algún tipo
	 * de color.
	 * @param color
	 * @param pintable
	 */
	void pintar(String color, Pintable pintable);
	
}
