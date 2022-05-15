import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Prueba {

	
	
	public static void main(String[] args) {
		
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
		alimentos.put("Limón", 4);
		
		Collection<Integer> numeros = alimentos.values();
		Collection<Integer> numeros2 = alimentos.values();
		
		for(Integer num : numeros) {
			
			System.out.print(num + ",");
			
		}
		for(Integer num : numeros2) {
			
			System.out.println(num + ",");
			
		}	
		
	}
	
}
