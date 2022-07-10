package com.miravent.modelo.interfaces;

import javafx.scene.canvas.GraphicsContext;


/**
 * Los elementos que implementan esta interfaz deben poder ser dibujadas en un Canvas.
 * La implementación de esta interfaz suele ir acompañada de la interfaz {@link Movible}
 * @author Sergio
 *
 */
public interface Pintable {

	/**
	 * Pinta el elemento en el Canvas al que pertenece el GraphicsContext que es recibido
	 * por parametro.
	 * @param gc
	 */
	void pintar(GraphicsContext gc);
	
}
