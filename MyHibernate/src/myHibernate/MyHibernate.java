package myHibernate;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import anotaciones.*;
import utiles.*;


public class MyHibernate {

	public static <T> T find(Class<T> clazz, Integer id) {//Metodo buscar
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = MyHibernateSQL.selectSQL(clazz);
			
			Connection con = JdbcUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs= pstm.executeQuery();
			T t = generarObjeto(clazz, rs);
			return t;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static <T> List<T> findAll(Class<T> clazz){
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = MyHibernateSQL.selectAllSQL(clazz);
			pstm = JdbcUtil.getConnection().prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				ArrayList<T> list = new ArrayList<>();
				while(rs.next()) {
					T t = find(clazz, rs.getInt(1));
					list.add(t);
				}
				return list;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public static void delete(Class<?> clazz, int id) {
		PreparedStatement pstm = null;
		
		try {
			String sql = MyHibernateSQL.deleteSQL(clazz);
			pstm = JdbcUtil.getConnection().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert(Object obj) {
		PreparedStatement pstm = null;
		
		try {
			Class<?> clazz = obj.getClass();
			String sql = MyHibernateSQL.insertSQL(clazz);
			pstm = JdbcUtil.getConnection().prepareStatement(sql);
			pstm.setObject(1, obj);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static <T> T generarObjeto(Class<T> clazz, ResultSet rs) {//Metodo de apoyo.
		try {
			if (rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance(); //Instancia de Producto
				for(Field f: clazz.getDeclaredFields()) {			//Recorro todos los atributos
					Column col = f.getAnnotation(Column.class);		//Selecciono solo los atributos de las columnas de la tabla
					boolean access = f.canAccess(t);
					f.setAccessible(true);
					if(f.getAnnotation(ManyToOne.class)==null) {
						Object value = rs.getObject(col.name());		//Convierto el valor de las columnas de la tabla en un objeto
						f.set(t, value);				
					}else {
						Integer id = rs.getInt(col.name());				//revisar esta linea a full
		                Object x = MyHibernate.find(f.getType(),id);	//revisar esta linea a full
		                f.set(t,x);										//revisar esta linea a full
					}
					
					f.setAccessible(access);
					
				}
				return t;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
