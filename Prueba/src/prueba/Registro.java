package prueba;

import java.sql.Date;
import java.time.LocalDate;

public class Registro {

	private String nombre;
	private int puntuacion;
	private LocalDate fecha;
	
	public Registro(String nombre, int puntuacion, Date fecha) {
		
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.fecha = fecha.toLocalDate();
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Registro [nombre=" + nombre + ", puntuacion=" + puntuacion + ", fecha=" + fecha + "]";
	}
	
	
	
	
	
}
