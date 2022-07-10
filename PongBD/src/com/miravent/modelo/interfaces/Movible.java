package com.miravent.modelo.interfaces;

import javafx.scene.canvas.Canvas;

/**
 * Un elemento movible es cualquiere elemento el cual cuenta con unas coordenadas (x, y) que se pintará en un Canvas y es 
 * capaz de desplazarse por este para cambiar de posición.
 * La clase que implementa esta interfaz suele ir acompañada de la interfaz {@link Pintable}
 * @author Sergio
 *
 */
public interface Movible {

	/**
	 * Mueve el elemento recibiendo por parámetro el Canvas en el que cambiará su posición.
	 * @param superficieMovimiento
	 */
	void mover(Canvas superficieMovimiento);
	
}
