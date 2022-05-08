package com.retur.paint.modelo.elementos.interfaces;

public interface Seleccionable {

	/**
	 * Nombre de clase de estilo predeterminada para los elementos seleccionados.
	 */
	public static final String ELEMENTO_SELECCIONADO = "elementoSeleccionado";
	public static final String ELEMENTO_DESELECCIONADO = "elementoDeseleccionado";
	
	/**
	 * Los metodos cambiarár el estado estado de la herramienta y el estilo cambiando su clase.
	 */
	void seleccionado();
	
	void deseleccionado();
	
}
