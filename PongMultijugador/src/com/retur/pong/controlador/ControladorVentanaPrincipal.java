package com.retur.pong.controlador;


import com.retur.pong.modelo.alertas.Alerta;
import com.retur.pong.modelo.excepciones.NombreJugadorException;
import com.retur.pong.vista.VentanaPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorVentanaPrincipal {

	public final VentanaPrincipal VISTA_PRINCIPAL;
	
	public ControladorVentanaPrincipal() {
		
		this.VISTA_PRINCIPAL = new VentanaPrincipal();
		asignarEventoBoton(VISTA_PRINCIPAL.BOTON_JUGAR);
		
	}
	
	private void asignarEventoBoton(Button boton) {
		
		boton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				String j1 = VISTA_PRINCIPAL.NOMBRE_J1.getText();
				String j2 = VISTA_PRINCIPAL.NOMBRE_J2.getText();
				
				
				try {
					
					comprobarNombres(j1, j2);
					Stage stage = (Stage) boton.getScene().getWindow();
					ControladorJuego controladorJ = new ControladorJuego(j1, j2);
					stage.setScene(controladorJ.VENTANA_JUEGO.ESCENA_JUEGO);
					
				} catch (NombreJugadorException e) {
					
					Alerta.alertaError("Nombres no validos.", e.getMessage());
					
				}
				
				
			}
			
		});
		
	}
	
	private void comprobarNombres(String nombreJ1, String nombreJ2) throws NombreJugadorException {

		
		if(nombreJ1.isEmpty() || nombreJ2.isEmpty()) {
			
			throw new NombreJugadorException("No puede haber ningún nombre vacío.");
			
		}
		
		if(nombreJ1.equals(nombreJ2)) {
			
			throw new NombreJugadorException("No pueden ser los dos nombres iguales.");
			
		}
		
	}
	
}
