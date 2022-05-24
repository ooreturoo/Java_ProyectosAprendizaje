package com.retur.paint.controlador;





import java.net.URL;
import java.util.ResourceBundle;

import com.retur.paint.modelo.elementos.Rango;
import com.retur.paint.modelo.elementos.RangosPintura;
import com.retur.paint.modelo.elementos.herramientas.CuboRelleno;
import com.retur.paint.modelo.elementos.herramientas.Goma;
import com.retur.paint.modelo.elementos.herramientas.Herramienta;
import com.retur.paint.modelo.elementos.herramientas.HerramientaDibujo;
import com.retur.paint.modelo.elementos.herramientas.Lapiz;
import com.retur.paint.modelo.elementos.herramientas.Lupa;
import com.retur.paint.modelo.elementos.herramientas.SelectorColor;
import com.retur.paint.modelo.elementos.pintura.Lienzo;
import com.retur.paint.modelo.funciones.ApoyoControladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ControladorPrincipal implements Initializable {
	
	
	/*************************
	 *****Botones Colores***** 
	 *************************/
	
	@FXML
	private GridPane gridBotonesColores;
	
	@FXML
	private MenuButton cambioRangos;
	
	@FXML
	private Button lapiz;
	@FXML
	private Button goma;
	@FXML
	private Button selectorColor;
	@FXML
	private Button cuboRelleno;
	@FXML
	private Button lupa;
	
	@FXML
	private MenuItem primerRangoVentana;
	@FXML
	private MenuItem segundoRangoVentana;
	@FXML
	private MenuItem tercerRangoVentana;
	@FXML
	private MenuItem cuartoRangoVentana;
	
	
	@FXML
	private Button botonColor1;
	@FXML
	private Button botonColor2;
	
	
	@FXML
	private MenuItem nuevoLienzo;
	
	@FXML
	private AnchorPane zonaLienzo;
	
	@FXML
	private Label coordenadaLienzo;
	
	
	private Rango primerRango;
	private Rango segundoRango;
	private Rango tercerRango;
	private Rango cuartoRango;
	private Rango rangoSeleccionado;
	private ObservableList<Button> botonesTodosColores;
	private ObservableList<Button> botonesColoresAjustables;
	private ControladorPintar cPintar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Inicializamos todas las herramientas asignandole sus botones.
		
		Lapiz.getInstance().init(lapiz);
		Goma.getInstance().init(goma);
		SelectorColor.getInstance().init(selectorColor);
		CuboRelleno.getInstance().init(cuboRelleno);
		Lupa.getInstance().init(lupa);
		
		primerRango = new Rango(primerRangoVentana, RangosPintura.PRIMER_RANGO);
		segundoRango = new Rango(segundoRangoVentana, RangosPintura.SEGUNDO_RANGO);
		tercerRango = new Rango(tercerRangoVentana, RangosPintura.TERCER_RANGO);
		cuartoRango = new Rango(cuartoRangoVentana, RangosPintura.CUARTO_RANGO);
		
		rangoSeleccionado = primerRango;
		primerRango.seleccionado();
		
		cPintar = new ControladorPintar(botonColor1, botonColor2, coordenadaLienzo);
		botonesTodosColores = FXCollections.observableArrayList();
		botonesColoresAjustables = FXCollections.observableArrayList();
		/*
		 * Obtenemos los hijos del grid donde se alamcenan los colores que servirán para cambiar
		 * el color con el que se dibuja, se recorren y se separan los que serán colores por defectos
		 * y en los que se cambiarán los valores.
		 */
		
		for(Node nodo : gridBotonesColores.getChildren()) {
			
			
			if(nodo instanceof Button) {
				
				Button boton = (Button) nodo;
				
				botonesTodosColores.add(boton);
				
				if(boton.getText().isEmpty()) {
					
					botonesColoresAjustables.add(boton);
					
				}else {
					
					ApoyoControladores.pintarCanvasBotones(boton);
					
				}
				
			}
			
			
		}
		
		
	};
	
	
	@FXML
	private void crearLienzo(ActionEvent e) {
		
		//Esto ira en una ventana nueva que se arbirá al crear nuevo, en el que se introduciran las medidas del lienzo.
		cPintar.setLienzo(new Lienzo(1080, 720, zonaLienzo, cPintar.getHerramientaSeleccionada()));
		
	};
	
	@FXML
	private void obtenerColorBoton(ActionEvent e) {
		
		Button boton = (Button) e.getSource();
		
		if(!boton.getText().isEmpty()) {
			
			
			cPintar.cambioColor(Color.web(boton.getText()));
			
		}
	
	}
	
	
	/**
	 * Se llama al seleccionar cualquier herramienta.
	 * @param event
	 */
	@FXML
	private void seleccionarHerramienta(ActionEvent event) {
		
		Object obj = event.getSource();
		
		Herramienta herramienta = null;
		
		if(obj == lapiz) {
			
			herramienta = Lapiz.getInstance();
			
		}else if (obj == goma) {
			
			herramienta = Goma.getInstance();
			
		}else if (obj == selectorColor) {
			
			herramienta = SelectorColor.getInstance();
			
		}else if(obj == cuboRelleno) {
			
			herramienta = CuboRelleno.getInstance();
			
		}else if(obj == lupa) {
			
			herramienta = Lupa.getInstance();
			
		}
		
		if(herramienta instanceof HerramientaDibujo) {
			
			HerramientaDibujo herramientaDibujo = (HerramientaDibujo) herramienta;
			actualizarRangoSeleccionado(herramientaDibujo.getRangoEnUso());
			cambioRangos.setDisable(false);
			
			
		}else {
			
			cambioRangos.setDisable(true);
			
		}
		
		cPintar.cambioHerramienta(herramienta);
		
	}
	
	/**
	 * Al seleccionar un tamaño en la intarfaz, se cambia el tamaño con el que se pinta.
	 * @param event
	 */
	@FXML
	private void seleccionRango(ActionEvent event) {
		
		Object obj = event.getSource();
		Rango rango = null;
		
		
		if(obj == primerRangoVentana) {
			
			rango = primerRango;
		 
		}else if(obj == segundoRangoVentana) {
			
			rango = segundoRango;
			
		}else if(obj == tercerRangoVentana) {
			
			rango = tercerRango;
			
		}else if(obj == cuartoRangoVentana) {
			
			rango = cuartoRango;
			
		}
		
		if(rango != rangoSeleccionado) {
			
			actualizarRangoSeleccionado(rango.RANGO_PINTURA);
			cPintar.cambiosRangos(rango);
			
		}
		
	}
	
	
	@FXML
	private void cambioColorSeleccionado(ActionEvent event) {
		
		cPintar.cambioColorSeleccionado(event);
		
	}
	
	
	/**
	 * Se le asigna el disparador al Canvas del lienzo para que en el momento
	 * que se presione el raton en él se comience a pintar.
	 * @param e
	 */
	@FXML
	private void comienzoPintar(MouseEvent e) {
		

		cPintar.setBotonPresionado(e.getButton());
		
	}
	
	@FXML
	private void finalPintar(MouseEvent e) {
		
		
		
	}
	

	private void actualizarRangoSeleccionado(RangosPintura rango) {
		
		if(rangoSeleccionado.RANGO_PINTURA != rango) {
			
			Rango rangoActual = null;
			
			if(rango == RangosPintura.PRIMER_RANGO) {
				
				rangoActual = primerRango;
				
			}else if(rango == RangosPintura.SEGUNDO_RANGO) {
				
				rangoActual = segundoRango;
				
			}else if(rango == RangosPintura.TERCER_RANGO) {
				
				rangoActual = tercerRango;
				
			}else if(rango == RangosPintura.CUARTO_RANGO) {
				
				rangoActual = cuartoRango;
				
			}
		
			rangoSeleccionado.deseleccionado();
			rangoSeleccionado = rangoActual;
			rangoActual.seleccionado();
		
		}
		
		
		
	}
	

	
	
	
}
