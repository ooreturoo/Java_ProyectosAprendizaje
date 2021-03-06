package com.retur.paint.controlador;



import com.retur.paint.modelo.elementos.Rango;
import com.retur.paint.modelo.elementos.RangosPintura;
import com.retur.paint.modelo.elementos.herramientas.CuboRelleno;
import com.retur.paint.modelo.elementos.herramientas.Herramienta;
import com.retur.paint.modelo.elementos.herramientas.HerramientaDibujo;
import com.retur.paint.modelo.elementos.herramientas.Lapiz;
import com.retur.paint.modelo.elementos.herramientas.Lupa;
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
import javafx.scene.input.ZoomEvent;
import javafx.scene.paint.Color;

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
	private ColorSeleccionado colorSeleccionado;

	
	public ControladorPintar(Button color1, Button color2, Label posicionRaton) {
		
		COLOR1 = new ColorSeleccionado(color1, Color.web(COLOR1_DEFECTO));
		COLOR2 = new ColorSeleccionado(color2, Color.web(COLOR2_DEFECTO));
		ApoyoControladores.pintarCanvasBotones(COLOR1);
		ApoyoControladores.pintarCanvasBotones(COLOR2);
		COORDENADA_RATON_LIENZO = posicionRaton;
		herramientaSeleccionada = Lapiz.getInstance();
		herramientaSeleccionada.seleccionado();
		colorSeleccionado = COLOR1;
		COLOR1.seleccionado();
		
	}
	
	/*
	 * TODO No es necesario tener una clase lienzo con una matriz de Strings, se puede obtener el color
	 * del Canvas con Robot e incluso hay otras clasees m??s que creo que pueden hacer lo mismo.
	 * Por lo que habria que cambiar la clase de color seleccionado a que en vez de almacenar un String
	 * almacene un objeto de la clase Color y hacer los cambios de tipo al setearlos o al seleccionar 
	 * un color nuevo.
	 * Habria que buscar una opci??n de usar robot en un bucle while dentro de un nuevo hilo, puesto 
	 * que solo puede usarse robot en el hilo principal de javafx, por lo que limitar??a el uso de 
	 * un pintado fluido.
	 * Usar la clase point2D si no se puede con el robot e intentar hacer un trazado limpio utilizando
	 * angulos etc.
	 * 
	 */
	
	/**
	 * Cambia el color de los botones que se pintaran dependiendo del bot??n del rat??n pulsado.
	 * @param color Recibe el color que se guardar?? en el bot??n.
	 */
	public void cambioColor(Color color) {
		
		colorSeleccionado.setColor(color);
		ApoyoControladores.pintarCanvasBotones(colorSeleccionado);
		
	}
	

	/**
	 * Cambia la herramienta seleccionada que se utilizar?? en el lienzo.
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
	 * Cambia el tama??o de al herramienta seleccionada.
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
		
		if(obj == COLOR1.BOTON_COLOR_SELEC && COLOR1 != colorSeleccionado) {
			
			COLOR2.deseleccionado();
			colorSeleccionado = COLOR1;
			COLOR1.seleccionado();
			
		}else if (obj == COLOR2.BOTON_COLOR_SELEC && COLOR2 != colorSeleccionado) {
			
			COLOR1.deseleccionado();
			colorSeleccionado = COLOR2;
			COLOR2.seleccionado();
			
		}
		
	}
	
	/**
	 * M??todo que devuelve el texto que mostrar?? el label de las coordenadas donde se encuentra
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
		// y cambiar el boolean pintando a true, crear un bucle que mientra se est?? pintando, que pinte
		// y capturar que al dejar de draguear se deje de pintar.
		
		EventHandler<MouseEvent> eventoPosicion = new EventHandler<MouseEvent>() {
			//TODO USAR robot javafx y migrar el metodo al exterior con un while.
			
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
			
				pintarHerramientaDibujo(e);
				
				actualizarLabelCoordenadas();
				


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
				
				pintarHerramientaDibujo(e);
				
				obtenerColorHerramientaSelector(e);
				
				rellenarCubo(e);
				
				zoomLupa(e);

				
			}
		});
		
		lienzo.CANVAS_LIENZO.addEventHandler(ZoomEvent.ZOOM, new EventHandler<ZoomEvent>() {

			@Override
			public void handle(ZoomEvent e) {
			
				System.out.println("zoom");
				
			}
		});
		
		
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
	
	
	private void pintarHerramientaDibujo(MouseEvent e) {
		
		if(herramientaSeleccionada instanceof HerramientaDibujo) {
			
			pintarColorSeleccionado(e);
			
		}
		
	}
	
	private void obtenerColorHerramientaSelector(MouseEvent e) {
		
		if (herramientaSeleccionada instanceof SelectorColor) {
			
			SelectorColor selector = (SelectorColor) herramientaSeleccionada;
			ColorSeleccionado colorSeleccionado = null;
			
			if(e.getButton() == MouseButton.PRIMARY) {
				
				colorSeleccionado = COLOR1;
				
			}else if (e.getButton() == MouseButton.SECONDARY) {
				
				colorSeleccionado = COLOR2;
				
			}
			
			selector.obtenerColor((int)e.getX(), (int)e.getY(),lienzo.CANVAS_LIENZO, colorSeleccionado);
			
		}
		
	}
	
	private void rellenarCubo(MouseEvent e) {
		
		if(herramientaSeleccionada instanceof CuboRelleno) {
			
			CuboRelleno cubo= (CuboRelleno) herramientaSeleccionada;
			ColorSeleccionado colorSeleccionado = null;
			
			if(e.getButton() == MouseButton.PRIMARY) {
				
				colorSeleccionado = COLOR1;
				
			}else if (e.getButton() == MouseButton.SECONDARY) {
				
				colorSeleccionado = COLOR2;
				
			}
			
			cubo.rellenar((int)e.getX(), (int)e.getY(), colorSeleccionado.getColor());
			
		}
		
	}
	
	
	private void zoomLupa(MouseEvent e) {
		
		if(herramientaSeleccionada instanceof Lupa) {
			
			Lupa lupa = (Lupa) herramientaSeleccionada;
			
			lupa.hacerZoom(lienzo.CANVAS_LIENZO, e.getX(), e.getY());
			
			
		}
		
	}
	

	public Lienzo getLienzo() {
		return lienzo;
	}

	public void setLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
		eventosCanvas();
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
