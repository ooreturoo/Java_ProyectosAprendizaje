package com.retur.paint.controlador;



import com.retur.paint.modelo.elementos.Rango;
import com.retur.paint.modelo.elementos.RangosPintura;
import com.retur.paint.modelo.elementos.herramientas.Herramienta;
import com.retur.paint.modelo.elementos.herramientas.HerramientaDibujo;
import com.retur.paint.modelo.elementos.herramientas.Lapiz;
import com.retur.paint.modelo.elementos.herramientas.SelectorColor;
import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;
import com.retur.paint.modelo.elementos.pintura.Lienzo;
import com.retur.paint.modelo.funciones.ApoyoControladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	private final Label COORDENADA_RATON_LIENZO;
	public final ColorSeleccionado COLOR1;
	public final ColorSeleccionado COLOR2;
	
	
	private Herramienta herramientaSeleccionada;
	private Lienzo lienzo;
	private MouseButton botonPresionado;
	private boolean pintando;

	
	public ControladorPintar(Button color1, Button color2, Label posicionRaton) {
		
		COLOR1 = new ColorSeleccionado(color1, COLOR1_DEFECTO);
		COLOR2 = new ColorSeleccionado(color2, COLOR2_DEFECTO);
		ApoyoControladores.pintarCanvasBotones(COLOR1);
		ApoyoControladores.pintarCanvasBotones(COLOR2);
		COORDENADA_RATON_LIENZO = posicionRaton;
		herramientaSeleccionada = Lapiz.getInstance();
		herramientaSeleccionada.seleccionado();
		COLOR1.seleccionado();
		
	}
	
	/**
	 * Cambia el color de los botones que se pintaran dependiendo del botón del ratón pulsado.
	 * @param color Recibe el color que se guardará en el botón.
	 */
	public void cambioColor(String color) {
		
		if(COLOR1.isSeleccionado()) {
			
			COLOR1.setColor(color);
			ApoyoControladores.pintarCanvasBotones(COLOR1);
			
		}else if(COLOR2.isSeleccionado()) {
			
			COLOR2.setColor(color);
			ApoyoControladores.pintarCanvasBotones(COLOR2);
			
		}
		
	}
	

	/**
	 * Cambia la herramienta seleccionada que se utilizará en el lienzo.
	 * @param herramienta Recibe la herramienta que se va a utilizar.
	 */
	public void cambioHerramienta(Herramienta herramienta) {
		
		herramientaSeleccionada.deseleccionado();
		this.herramientaSeleccionada = herramienta;
		
		if(lienzo != null) {
			
			lienzo.CANVAS_LIENZO.setCursor(herramientaSeleccionada.ESTILO_CURSOR);
			
		}
		
		this.herramientaSeleccionada.seleccionado();
		
	}
		
	/**
	 * Cambia el tamaño de al herramienta seleccionada.
	 * @param size
	 * @throws HerramientaSeleccionadaException
	 */
	public void cambiosRangos(Rango rango){
		
		HerramientaDibujo herramienta = (HerramientaDibujo) herramientaSeleccionada;
		RangosPintura rangoPintura = rango.RANGO_PINTURA;
		
		if(rangoPintura == RangosPintura.PRIMER_RANGO) {
			
			herramienta.usarPrimerRango();
			
		}else if (rangoPintura == RangosPintura.SEGUNDO_RANGO) {
			
			herramienta.usarSegundoRango();
			
		}else if (rangoPintura == RangosPintura.TERCER_RANGO) {
			
			herramienta.usarTercerRango();
			
		}else if (rangoPintura == RangosPintura.CUARTO_RANGO) {
			
			herramienta.usarCuartoRango();
			
		}
		
		herramienta.setRangoEnUso(rangoPintura);
		
	}
	
	public void cambioColorSeleccionado(ActionEvent event) {
		
		Object obj = event.getSource();
		
		if(obj == COLOR1.BOTON_COLOR_SELEC && !COLOR1.isSeleccionado()) {
			
			COLOR2.deseleccionado();
			COLOR1.seleccionado();
			
		}else if (obj == COLOR2.BOTON_COLOR_SELEC && !COLOR2.isSeleccionado()) {
			
			COLOR1.deseleccionado();
			COLOR2.seleccionado();
			
		}
		
	}
	
	/**
	 * Método que devuelve el texto que mostrará el label de las coordenadas donde se encuentra
	 * el puntero.
	 * @param x
	 * @param y
	 * @return
	 */
	private void actualizarLabelCoordenadas() {
		
		COORDENADA_RATON_LIENZO.setText("X: " + lienzo.getPosRatonX() + ", Y: " + lienzo.getPosRatonY());
		
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
				

				lienzo.setPosRaton((int) event.getX(), (int) event.getY());
				actualizarLabelCoordenadas();
				
			}
			
		};
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_MOVED, eventoPosicion);
		
		lienzo.CANVAS_LIENZO.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			
				//TODO Aqui el while no funciona, porque no para al detectar el siguiene elemento el siguiente elemento.
				//while(pintando) {
				if(herramientaSeleccionada instanceof HerramientaDibujo) {
					
					pintarColorSeleccionado(e);
					
				}
				
				actualizarLabelCoordenadas();
				
				//}

			}
		});
		
		
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
			
				actualizarLabelCoordenadas();
				
			}
		});
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_EXITED, e -> COORDENADA_RATON_LIENZO.setText(""));
		
		lienzo.CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				
				if(herramientaSeleccionada instanceof HerramientaDibujo) {
					
					pintarColorSeleccionado(e);
					
				}
				
				
				if (herramientaSeleccionada instanceof SelectorColor) {
					
					SelectorColor selector = (SelectorColor) herramientaSeleccionada;
					ColorSeleccionado colorSeleccionado = null;
					
					if(e.getButton() == MouseButton.PRIMARY) {
						
						colorSeleccionado = COLOR1;
						
					}else if (e.getButton() == MouseButton.SECONDARY) {
						
						colorSeleccionado = COLOR2;
						
					}
					
					selector.obtenerColor((int)e.getX(), (int)e.getY(), lienzo, colorSeleccionado);
					
					
				}
				
				pintando = true;
				
			}
		});
		
		lienzo.CANVAS_LIENZO.addEventFilter(MouseEvent.MOUSE_RELEASED, (e) -> pintando = false);
		
	}
	
	private void pintarColorSeleccionado(MouseEvent e) {
		
		HerramientaDibujo herramientaDibujo = (HerramientaDibujo) herramientaSeleccionada;
		
		lienzo.setPosRaton((int) e.getX(), (int) e.getY());
		
		if(e.getButton() == MouseButton.PRIMARY) {
			
			herramientaDibujo.pintar(COLOR1.getColor(), lienzo);						
			
		}else if(e.getButton() == MouseButton.SECONDARY) {
			
			herramientaDibujo.pintar(COLOR2.getColor(), lienzo);				
			
		}
		
		
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

	public Herramienta getHerramientaSeleccionada() {
		return herramientaSeleccionada;
	}


	
	
	
	
}
