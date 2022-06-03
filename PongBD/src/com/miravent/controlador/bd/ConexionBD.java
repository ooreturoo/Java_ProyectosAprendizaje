package com.miravent.controlador.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Maneja la conexión con la base de datos.
 * @author Sergio
 *
 */
public class ConexionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/pong";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection conexion;
	
	/**
	 * Inicia la conexión con la base de datos.
	 * @throws SQLException Si ocurre algún error al establecer la conexión con la base de datos.
	 */
	public static void establecerConexion() throws SQLException {
		
		conexion = DriverManager.getConnection(URL,USER,PASSWORD);
		
	}
	
	/**
	 * Cierra la conexión con la base de datos.
	 * @throws SQLException  Si ocurre algún error al acceder a la conexión con la base de datos.
	 */
	public static void cerrarConexion() throws SQLException {
		
		conexion.close();
		
	}

	public static Connection getConexion() {
		return conexion;
	}

	
	
}
