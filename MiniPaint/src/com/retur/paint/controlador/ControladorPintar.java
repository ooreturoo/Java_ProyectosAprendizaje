package com.retur.paint.controlador;


import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;

import javafx.scene.control.Button;

public class ControladorPintar {

	
	private static final String COLOR1_DEFECTO = "#FFFFFF";
	private static final String COLOR2_DEFECTO = "#000000";
	
	public final ColorSeleccionado COLOR1;
	public final ColorSeleccionado COLOR2;
	private Lienzo lienzo;

	
	public ControladorPintar(Button color1, Button color2) {
		
		COLOR1 = new ColorSeleccionado(color1, COLOR1_DEFECTO);
		COLOR2 = new ColorSeleccionado(color2, COLOR2_DEFECTO);
		
	}
	
	public void cambioColor(String color) {
		
		if(COLOR1.isSeleccionado()) {
			
			COLOR1.setColor(color);
			
		}else if(COLOR2.isSeleccionado()) {
			
			COLOR2.setColor(color);
			
		}
		
	}

	public Lienzo getLienzo() {
		return lienzo;
	}

	public void setLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
	}
	
	
	
}
