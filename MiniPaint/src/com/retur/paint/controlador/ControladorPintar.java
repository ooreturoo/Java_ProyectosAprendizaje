package com.retur.paint.controlador;

import com.retur.paint.modelo.excepciones.ColorException;
import com.retur.paint.modelo.excepciones.mensajes.MensajesExcepciones;
import com.retur.paint.modelo.objetos.ColorSeleccionado;

public class ControladorPintar {

	
	private static final String COLOR1_DEFECTO = "#FFFFFF";
	private static final String COLOR2_DEFECTO = "#000000";
	
	private ColorSeleccionado color1;
	private ColorSeleccionado color2;

	
	public ControladorPintar() {
		
		this.color1 = new ColorSeleccionado(COLOR1_DEFECTO);
		this.color2 = new ColorSeleccionado(COLOR2_DEFECTO);
		
	}
	
	public String seleccionColor() throws ColorException {
		
		String colorSeleccionado;
		
		if(color1.isSeleccionado()) {
			
			colorSeleccionado = color1.getColor();
			
		}else if(color2.isSeleccionado()) {
			
			colorSeleccionado = color2.getColor();
			
		}else {
			
			throw new ColorException(MensajesExcepciones.COLOR_NO_SELECCIONADO);
			
		}
		
		return colorSeleccionado;
		
	}
	
	
}
