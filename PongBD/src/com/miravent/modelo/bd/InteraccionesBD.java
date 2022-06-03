package com.miravent.modelo.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import com.miravent.modelo.componentes.registros.Registro;

/**
 * Clase funcional encargada de interacciones (consultas, registros ...) con la base de datos.
 * @author Sergio
 *
 */
public class InteraccionesBD {

	public static final String NOMBRE_TABLA = "registro_puntuaciones";
	public static final String COL_NOMBRE = "nombre";
	public static final String COL_PUNTUACION = "puntos";
	public static final String COL_FECHA = "fecha";
	public static final int MAX_VARCHAR = 25;
	
	/**
	 * Registra el nombre, la puntuación y la fecha del jugador en la base de datos.
	 * @param nombre Nombre del jugador.
	 * @param puntuacion Puntuación del jugador.
	 * @param conexion Conexion con la BD.
	 * @throws SQLException
	 */
	public static void registrarPuntuacion(String nombre, int puntuacion, Connection conexion) throws SQLException{
		
		/*
		 * Se inserta los valores si el nombre no existe. En caso contrario de hará un update si la puntuación es 
		 * mayor que la almacenada.
		 */
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(NOMBRE_TABLA);
		sql.append(" VALUES (?, ?, NOW()) ON DUPLICATE KEY UPDATE ");
		sql.append(COL_FECHA).append(" = IF(VALUES(").append(COL_PUNTUACION).append(") > ");
		sql.append(COL_PUNTUACION).append(", VALUES(").append(COL_FECHA).append("),");
		sql.append(COL_FECHA).append("),");
		sql.append(COL_PUNTUACION).append(" = IF(VALUES(").append(COL_PUNTUACION).append(") > ");
		sql.append(COL_PUNTUACION).append(", VALUES(").append(COL_PUNTUACION).append("),");
		sql.append(COL_PUNTUACION).append(");");
		
		PreparedStatement statement = conexion.prepareStatement(sql.toString());
		
		statement.setString(1, nombre);
		statement.setLong(2, puntuacion);
		
		statement.executeUpdate();
		
		
	}
	
	/**
	 * Obtiene la lista de puntuaciones de la BD.
	 * @param conexion Conexion con la BD.
	 * @return Devuelve la lista de registros.
	 * @throws SQLException
	 */
	public static List<Registro> obtenerMejoresPuntuaciones(Connection conexion) throws SQLException {
		
		List<Registro> lista = new LinkedList<Registro>();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append(COL_NOMBRE).append(",");
		sql.append(COL_PUNTUACION).append(",");
		sql.append(COL_FECHA).append(" FROM ");
		sql.append(NOMBRE_TABLA);
		
		PreparedStatement statement = conexion.prepareStatement(sql.toString());
		
		ResultSet result = statement.executeQuery();
		
		//Se pasa los valores obtenidos de cada columna a una lista de registros.
		while (result.next()) {
			
			String nombre = result.getString(1);
			int puntuacion = result.getInt(2);
			Date fecha = result.getDate(3);
			
			lista.add(new Registro(nombre, puntuacion, fecha));
			
		}
		
		return lista;
		
	}
	
	/**
	 * Crea la tabla donde se almacenaran los datos.
	 * @param conexion
	 * @throws SQLException
	 */
	public static void creacionTabla(Connection conexion) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("CREATE TABLE IF NOT EXISTS ").append(NOMBRE_TABLA);
		sql.append("( ").append(COL_NOMBRE).append(" VARCHAR(").append(MAX_VARCHAR).append(")").append(" UNIQUE,");
		sql.append(COL_PUNTUACION).append(" int,");
		sql.append(COL_FECHA).append(" date);");
		
		PreparedStatement statement = conexion.prepareStatement(sql.toString());
		
		statement.execute();
		
	}
	
}
