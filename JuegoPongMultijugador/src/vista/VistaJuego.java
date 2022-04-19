package vista;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VistaJuego {

	private static final double ANCHO_F_JUEGO = 670;
	private static final double ALTO_F_JUEGO = 380;
	private static final double LAYOUTX_F_JUEGO = 25;
	private static final double LAYOUTY_F_JUEGO = 75;
	private static final double ANCHO_PALA = 10;
	private static final double ALTO_PALA = 85;
	private static final double LAYOUTX_PALA1 = 67;
	private static final double LAYOUTY_PALAS = 223;
	private static final double LAYOUTX_PALA2 = 644;

	
	
	private AnchorPane raiz;
	
	private Canvas fondoPrincipal;
	private Rectangle fondoJuego;
	private Circle pelota;
	private Rectangle pala1;
	private Rectangle pala2;
	
	public VistaJuego() {

		raiz = new AnchorPane();

		crearFondoPrincipal();
		crearFondoJuego();
		crearPelota();
		crearPala1();
		crearPala2();
		
		raiz.getChildren().addAll(fondoJuego,pelota,pala1,pala2);
		
	}


	
	private void crearFondoPrincipal() {
		
		fondoPrincipal = new Canvas(raiz.getWidth(),raiz.getHeight());
		fondoPrincipal.setLayoutX(0);
		fondoPrincipal.setLayoutY(0);
		
	}
	
	public Canvas getFondoPrincipal() {
		return fondoPrincipal;
	}



	private void crearPelota() {
		
		pelota = new Circle(8);
		pelota.setLayoutX(362);
		pelota.setLayoutY(267);
		pelota.setFill(Color.WHITE);
		
	}
	
	private void crearFondoJuego() {
		
		fondoJuego = new Rectangle(ANCHO_F_JUEGO, ALTO_F_JUEGO);
		fondoJuego.setLayoutX(LAYOUTX_F_JUEGO);
		fondoJuego.setLayoutY(LAYOUTY_F_JUEGO);
		
	}
	
	private void crearPala1() {
		
		pala1 = crearPalas();
		pala1.setLayoutX(LAYOUTX_PALA1);
		pala1.setLayoutY(LAYOUTY_PALAS);

	}
	
	private void crearPala2() {
		
		pala2 = crearPalas();
		pala2.setLayoutX(LAYOUTX_PALA2);
		pala2.setLayoutY(LAYOUTY_PALAS);
		
	}
	
	private Rectangle crearPalas() {
		
		Rectangle palas = new Rectangle(ANCHO_PALA,ALTO_PALA);
		palas.setFill(Color.WHITE);
		
		return palas;
		
	}

	public AnchorPane getRaiz() {
		return raiz;
	}


	public Circle getPelota() {
		return pelota;
	}


	public Rectangle getPala1() {
		return pala1;
	}


	public Rectangle getPala2() {
		return pala2;
	}
	
	
	
	
	
	
}
