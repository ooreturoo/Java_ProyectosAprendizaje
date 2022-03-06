package controlador;



import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modelo.componentes.Jugador;
import modelo.componentes.Pelota;
import modelo.juego.Juego;

public class ControladorVentana implements Initializable {
	
	@FXML private Canvas fondoCanvas;
	@FXML private Circle circulo;
	@FXML private Rectangle rectangulo;
	@FXML private Label temporizador;
	@FXML private Label puntuacion;
	@FXML private Label tDerrota;
	@FXML private Label puntuacionD;
	@FXML private Button bStart;
	@FXML private Button bRestart;
	@FXML private AnchorPane raiz;
	
	private Juego juego;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		juego = new Juego(this, new Pelota(circulo), new Jugador(rectangulo));
		
		
		
	}
	
	
	@FXML
	private void start() {
		eventosJugador();
		juego.inicioJuego();
		raiz.getChildren().remove(bStart);
		
		
	}
	
	@FXML
	private void restart() {
		
		juego.restartJuego();
		
	}
	
	private void eventosJugador() {
		
		raiz.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode().equals(KeyCode.RIGHT)) {
					
					juego.getJugador().setMovimientoDerecha(true);
					
				}else if(e.getCode().equals(KeyCode.LEFT)) {
					
					juego.getJugador().setMovimientoIzquierda(true);
					
				}
//				else if (e.getCode().equals(KeyCode.SPACE)) {
//					
//					if(juego.isPausado()) {
//						
//						notify();
//						
//					}else {
//						
//						try {
//							juego.pausaJuego();
//						} catch (InterruptedException e1) {
//							
//							e1.printStackTrace();
//						}
//						
//					}
//					
//				}
				
			}
		});
		
		
		raiz.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode().equals(KeyCode.RIGHT)) {
					
					juego.getJugador().setMovimientoDerecha(false);
					
				}else if(e.getCode().equals(KeyCode.LEFT)) {
					
					juego.getJugador().setMovimientoIzquierda(false);
					
				}
				
			}
			
		});
		
	}


	public Label getTemporizador() {
		return temporizador;
	}


	public Label getPuntuacion() {
		return puntuacion;
	}


	public Label gettDerrota() {
		return tDerrota;
	}


	public Label getPuntuacionD() {
		return puntuacionD;
	}


	public Button getbRestart() {
		return bRestart;
	}


	public Canvas getFondoCanvas() {
		return fondoCanvas;
	}
	
	

	
	
	
}
