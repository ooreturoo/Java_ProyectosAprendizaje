package com.miravent.modelo.componentes.registros;

import java.sql.Date;
import java.time.LocalDate;

public class Registro implements Comparable<Registro>{

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
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(puntuacion).append("\t\t").append("->");
		sb.append("\t\t").append(nombre);
		sb.append("[").append(fecha).append("]");
		return sb.toString();
	}

	@Override
	public int compareTo(Registro o) {
		return o.puntuacion - this.puntuacion;
	}
	
	
	
	
	
}
