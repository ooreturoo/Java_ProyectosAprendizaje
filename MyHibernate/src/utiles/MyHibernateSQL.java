package utiles;

import java.lang.reflect.*;
import anotaciones.Column;
import anotaciones.Id;
import anotaciones.Table;

public class MyHibernateSQL {
	
	public static String selectSQL(Class<?> clazz) {
		String sql = "SELECT " + obtenerField(clazz);
		sql += " FROM " + obtenerNombreTabla(clazz);
		sql += " WHERE " + obtenerId(clazz) + " = ? ";
		return sql;
	}
	
	public static String selectAllSQL(Class<?> clazz) {
		String sql = "SELECT * FROM " + obtenerNombreTabla(clazz);
		return sql;
	}
	
	public static String deleteSQL(Class<?> clazz) {
		String sql = "DELETE " + obtenerNombreTabla(clazz);
		sql += " WHERE " + obtenerId(clazz) + " = ? ";
		return sql;
	}

	public static String insertSQL(Class<?> clazz) {
		String sql = "INSERT INTO " + obtenerNombreTabla(clazz);
		sql += " (" + obtenerField(clazz) + ")";
		sql += " VALUES (" + obtenerCantidadValores(clazz) + ")";
		return sql;
	}
	
	public static String updateSQL(Class<?> clazz) {
		Field [] f = clazz.getDeclaredFields();
		String s="";
			for(int i = 0; i<f.length; i++) {
				Column col = f[i].getAnnotation(Column.class);
				if(f[i].getAnnotation(Id.class) == null) {
					s += col.name() + " = ?" + ((i<f.length-1)? ", " : "");
				}
			}
		String sql = "UPDATE " + obtenerNombreTabla(clazz);
		sql+= " SET " + s + " WHERE " + obtenerId(clazz) + " ?";
		return sql;
	}
	
	private static String obtenerField (Class<?> clazz) {//Obtener atributos.
		Field [] f = clazz.getDeclaredFields();
		String fields = "";
		for(int i =0; i<f.length;i++) {
			
			Column col = f[i].getAnnotation(Column.class);
			fields += col.name() + ((i<f.length-1)? ", " : " ");
		}
		
		return fields;
	}
	
	private static String obtenerId(Class<?> clazz) {//Obtener el atributo ID.
		Field[] f = clazz.getDeclaredFields();
		String id = "";
		for(Field field : f) {
			Column col = field.getAnnotation(Column.class);
			if(field.getAnnotation(Id.class) != null) {
				id = col.name();
			}
			
		}
		return id;
	}
	
	private static String obtenerNombreTabla(Class<?> clazz) {//Obtener el nombre de la tabla.
		return clazz.getAnnotation(Table.class).name();
	}
	
	private static String obtenerCantidadValores(Class<?> clazz) { //Obtener las interrogaciones en cada caso.
		Field[] f = clazz.getDeclaredFields();
		String s = "";
		for(int i = 0; i<f.length;i++) {
				s += "?" + ((i<f.length-1)? ", " : "");				
		}
		return s;
	}
}
