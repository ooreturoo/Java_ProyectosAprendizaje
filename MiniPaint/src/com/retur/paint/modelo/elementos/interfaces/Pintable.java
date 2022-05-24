package com.retur.paint.modelo.elementos.interfaces;

import javafx.scene.paint.Color;

public interface Pintable {

	/**
	 * Lo implementa cualquier clase en la que se pueda pintar de alguna forma.
	 * @param colores Contiene códigos hexagesimales de colores posicionados de acuerdo al patrón que 
	 * se pintarán.
	 */
	void pintado(Color[][] colores);
	
}
