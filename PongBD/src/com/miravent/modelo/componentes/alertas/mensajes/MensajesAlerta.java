package com.miravent.modelo.componentes.alertas.mensajes;

/**
 * Almacena los mensajes personalizados para las alertas de la aplicación, donde los nombres de las constantes
 * que comienzan por 'T' corresponden a titulos y 'M' al contenido.
 * @author Sergio
 *
 */
public class MensajesAlerta {
	
	public static final String T_ERROR_CONEXION = "Error de conexión.";
	public static final String M_ERROR_CONEXION = "No se ha podido conectar con la base de datos. No podrá guardar su puntuación obtenida.";
	public static final String M_ERROR_OBTENER_REGISTROS = "Error de conexión. No se han podido obtener las puntuaciones.";
	
	
	public static final String T_ERROR_REGISTRO = "Error registro.";
	public static final String M_ERROR_REGISTRO = "No se ha podido realizar el registro debido a un error, intenteló más tarde.";
	
	public static final String T_SOLICITUD_NOMBRE = "Introduccion nombre";
	public static final String M_SOLICITUD_NOMBRE = "Introduce tu nombre para registrar tu puntuación.";
	
	
	public static final String T_REGISTRO = "Registro Puntuacion";
	public static final String M_REGISTRO_REALIZADO = "Se ha registrado la puntuación con exito.";
	
	public static final String T_NOMBRE_VACIO = "Nombre no introducido.";
	public static final String M_NOMBRE_VACIO = "Es necesario un nombre para registrar la puntuación.";
	
}
