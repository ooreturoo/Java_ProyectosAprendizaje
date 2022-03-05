package controlador;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML private Button start;
	@FXML private AnchorPane raiz;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Juego.setPelota(new Pelota(circulo, fondoCanvas));
		Juego.setJugador(new Jugador(rectangulo, fondoCanvas));
		Juego.setRAIZ(raiz);
		
		
	}
	
	
	@FXML
	private void start() {
		
		Juego.inicioJuego();
		raiz.getChildren().remove(start);
		
		
	}

	
	
	
}
