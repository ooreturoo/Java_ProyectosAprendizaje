package modelo.elementos;

import javafx.scene.shape.Rectangle;

public class Jugador {

	private static final int VIDAS_DEFECTO = 5;
	
	private String nombre;
	private int vidas;
	private PalaJugador palaJugador;
	
	public Jugador(String nombre, Rectangle pala) {
		
		this.vidas = VIDAS_DEFECTO;
		this.nombre = nombre;
		this.palaJugador = new PalaJugador(pala);
		
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public static int getVidasDefecto() {
		return VIDAS_DEFECTO;
	}

	public String getNombre() {
		return nombre;
	}

	public PalaJugador getPalaJugador() {
		return palaJugador;
	}
	
	
	
	
	
}
