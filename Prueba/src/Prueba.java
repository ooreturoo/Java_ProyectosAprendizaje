<<<<<<< HEAD
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
=======
import java.awt.MouseInfo;
>>>>>>> 6ef25f45806e903b6dedec7d307bdd74dba8f5c3

public class Prueba {

	
	
	public static void main(String[] args) {
		
<<<<<<< HEAD
//		List<Integer> lista = new LinkedList<Integer>();
//		
//		lista.add(5);
//		lista.add(7);
//		lista.add(23);
//		lista.add(10);
//		lista.add(25);
//		
//		Iterator<Integer> iterador = lista.iterator();
		
		HashMap<String, Integer> alimentos = new HashMap<String, Integer>();
		
		alimentos.put("Zanahoria", 3);
		alimentos.put("Tomate", 5);
		alimentos.put("Lechuga", 12);
		alimentos.put("Huevo", 6);
		alimentos.put("Lim�n", 4);
		
		Collection<Integer> numeros = alimentos.values();
		Collection<Integer> numeros2 = alimentos.values();
		
		for(Integer num : numeros) {
			
			System.out.print(num + ",");
			
		}
		for(Integer num : numeros2) {
			
			System.out.println(num + ",");
			
		}	
=======
		for(int i = 0; i < 10000; i++) {
			
			System.out.println(MouseInfo.getPointerInfo().getLocation().x);
			
		}
		
		
>>>>>>> 6ef25f45806e903b6dedec7d307bdd74dba8f5c3
		
	}
	
}
