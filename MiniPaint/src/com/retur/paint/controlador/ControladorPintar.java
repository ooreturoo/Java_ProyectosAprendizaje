package com.retur.paint.controlador;


import java.util.ArrayList;

import com.retur.paint.modelo.elementos.herramientas.Herramienta;
import com.retur.paint.modelo.elementos.herramientas.Lapiz;
import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * 
 * @author Sergio
 *
 */
public class ControladorPintar {

	
	private static final String COLOR1_DEFECTO = "#000000";
	private static final String COLOR2_DEFECTO = "#FFFFFF";
	
	public final ColorSeleccionado COLOR1;
	public final ColorSeleccionado COLOR2;
	private final Label COORDENADA_RATON_LIENZO;
	private final ArrayList<String> lista;
	
	
	private Herramienta herramientaSeleccionada;
	private Lienzo lienzo;
	private MouseButton botonPresionado;
	private boolean pintando;

	
	public ControladorPintar(Button color1, Button color2, Label posicionRaton) {
		
		COLOR1 = new ColorSeleccionado(color1, COLOR1_DEFECTO);
		COLOR2 = new ColorSeleccionado(color2, COLOR2_DEFECTO);
		COORDENADA_RATON_LIENZO = posicionRaton;
		herramientaSeleccionada = Lapiz.getInstance();
		herramientaSeleccionada.seleccionado();
		lista = new ArrayList<String>();
		
	}
	
	/**
	 * Cambia el color de los botones que se pintaran dependiendo del botón del ratón pulsado.
	 * @param color Recibe el color que se guardará en el botón.
	 */
	public void cambioColor(String color) {
		
		if(COLOR1.isSeleccionado()) {
			
			COLOR1.setColor(color);
			
		}else if(COLOR2.isSeleccionado()) {
			
			COLOR2.setColor(color);
			
		}
		
	}
	
	private void actualizarMuestreoColorSelec() {
		
		
		
	}
	
	/**
	 * Cambia la herramienta seleccionada que se utilizara en el lienzo.
	 * @param herramienta Recibe la herramienta que se va a utilizar.
	 */
	public void cambioHerramienta(Herramienta herramienta) {
		
		herramientaSeleccionada.deseleccionado();
		this.herramientaSeleccionada = herramienta;
		this.herramientaSeleccionada.seleccionado();
		
	}
	
	/**
	 * Método que devuelve el texto que mostrará el label de las coordenadas donde se encuentra
	 * el puntero.
	 * @param x
	 * @param y
	 * @return
	 */
	private String textoCoordenadas(int x, int y) {
		
		return "X: " + lienzo.getPosRatonX() + ", Y: " + lienzo.getPosRatonY();
		
	}
	
	/**
	 * Establece los eventos al Canvas.
	 */
	private void eventosCanvas() {
		
		//TODO En vez de capturar el evento cuando se esta dragueando, capturar cuando se empieza
		// y cambiar el boolean pintando a true, crear un bucle que mientra se esté pintando, que pinte
		// y capturar que al dejar de draguear se deje de pintar.
		
		EventHandler<MouseEvent> eventoPosicion = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				lienzo.setPosRatonX((int) event.getX());
				lienzo.setPosRatonY((int) event.getY());
				COORDENADA_RATON_LIENZO.setText(textoCoordenadas(lienzo.getPosRatonX(), lienzo.getPosRatonY()));
				
			}
			
		};
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_MOVED, eventoPosicion);
		
		lienzo.CANVAS_LIENZO.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			
				//TODO Aqui el while no funciona, porque no para al detectar el siguiene elemento el siguiente elemento.
				//while(pintando) {
					double xRaton = e.getX();
					double yRaton = e.getY();
				if(xRaton >= 0 && xRaton < lienzo.ANCHO_LIENZO && yRaton >= 0 && yRaton < lienzo.ALTO_LIENZO) {
					
					lista.add("X: " + xRaton + " Y: " + yRaton);
					lienzo.rellenarColorPixel((int)e.getX(),(int) e.getY(), COLOR1_DEFECTO);
					
				}
					

					
				//}

			}
		});
		
		
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			
				COORDENADA_RATON_LIENZO.setText(textoCoordenadas(lienzo.getPosRatonX(), lienzo.getPosRatonY()));
				
			}
		});
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_EXITED, e -> COORDENADA_RATON_LIENZO.setText(""));
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				if(e.getButton() == MouseButton.PRIMARY) {
					//TODO Añadir una forma de obtener el color seleccionado.
					lienzo.rellenarColorPixel((int)e.getX(),(int) e.getY(), COLOR1.getColor());

					
				}else if(e.getButton() == MouseButton.SECONDARY){
					
					lienzo.rellenarColorPixel((int)e.getX(),(int) e.getY(), COLOR1_DEFECTO);
					
				}
				
				pintando = true;
				
			}
		});
		
		lienzo.CANVAS_LIENZO.addEventFilter(MouseEvent.MOUSE_RELEASED, (e) -> pintando = false);
		
	}

	public Lienzo getLienzo() {
		return lienzo;
	}

	public void setLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
		eventosCanvas();
	}

	public boolean isPintando() {
		return pintando;
	}

	public void setPintando(boolean pintando) {
		this.pintando = pintando;
	}

	public MouseButton getBotonPresionado() {
		return botonPresionado;
	}

	public void setBotonPresionado(MouseButton botonPresionado) {
		this.botonPresionado = botonPresionado;
	}
	
	
	
	
}
