package com.retur.paint.modelo.elementos;

import com.retur.paint.modelo.elementos.interfaces.Seleccionable;

import javafx.scene.control.MenuItem;


/**
 * Clase envolvente de los menuitems de la interfaz para cambiar el tamaño de la zona que se dibuja.
 * Almacena un menuitem y un valor de RangosPintura equivalente al tamaño del menuitem.
 * La principal ventaja de esta clase es  poder implementar la interfaz seleccionable y 
 * así poder cambiar el estilo una vez se selecciona cada tamaño.
 * @author sergi
 *
 */
public class Rango implements Seleccionable {

	public final MenuItem BOTON_RANGO;
	public final RangosPintura RANGO_PINTURA;
	
	public Rango(MenuItem botonRango, RangosPintura rango) {
		
		BOTON_RANGO = botonRango;
		RANGO_PINTURA = rango;
		
	}
	
	@Override
	public void seleccionado() {
		
		this.BOTON_RANGO.getStyleClass().remove(ELEMENTO_DESELECCIONADO);
		this.BOTON_RANGO.getStyleClass().add(ELEMENTO_SELECCIONADO);			

	}
	
	@Override
	public void deseleccionado() {

		this.BOTON_RANGO.getStyleClass().remove(ELEMENTO_SELECCIONADO);			
		this.BOTON_RANGO.getStyleClass().add(ELEMENTO_DESELECCIONADO);
	

	}


	
	
	
}
