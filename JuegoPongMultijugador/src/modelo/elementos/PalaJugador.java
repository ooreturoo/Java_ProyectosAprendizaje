package modelo.elementos;

import javafx.scene.shape.Rectangle;

public class PalaJugador {

	private static final int VELOCIDAD_DEFECTO = 3;
	
	private Rectangle pala;
	private boolean subir;
	private boolean bajar;
	private int velocidad;
	private double y;
	
	
	public PalaJugador(Rectangle pala) {
		
		this.pala = pala;
		this.y = pala.getLayoutY();
		this.velocidad = VELOCIDAD_DEFECTO;
		
		
	}
	
	public void movimientoPala(double alturaVentana) {
		
		if(subir) {
			
			if(y > 0) {
				
				y -= velocidad;
				
			}
			
		}
		if(bajar) {
			
			if(y < alturaVentana) {

				y += velocidad;
				
			}
		}
		
		pala.setLayoutY(y);
		
	}

	public Rectangle getPala() {
		return pala;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}

	public void setBajar(boolean bajar) {
		this.bajar = bajar;
	}
	
	
	
}
