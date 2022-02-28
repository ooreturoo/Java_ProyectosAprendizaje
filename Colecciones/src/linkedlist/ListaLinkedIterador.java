package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListaLinkedIterador {

	public static void main(String[] args) {
		
		/*
		 * Creamos dos listas, una de paises y otra de capitales.
		 */
		LinkedList<String> paises = new LinkedList<>();
		paises.add("España");
		paises.add("Colombia");
		paises.add("México");
		paises.add("Perú");
		
		LinkedList<String> capitales = new LinkedList<>();
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("Ciudad de México");
		capitales.add("Lima");
		
		/*
		 * Creamos un iterador para cada lista, para añadir las capitales justo detras de sus correspondientes paises.
		 * Usamos ListIterator, la cual es mejor para listas que tienen un orden.
		 */
		
		ListIterator<String> itA = paises.listIterator();
		ListIterator<String> itB = capitales.listIterator();
		
		/*
		 * Usamos búcle while para recorrer la lista mientras haya un siguiente elemento en ella.
		 */
		
		/*while(itA.hasNext()){
			itA.next();
			if(itB.hasNext()){
				itA.add(itB.next());
			}
		}*/
		
		/*
		 * Se puede hacer de la forma anterior y de la siguiente.
		 */
		
		while(itB.hasNext()) {
			if(itA.hasNext()){
				itA.next();
			}
			itA.add(itB.next());
			
		}
		
		/*
		 * Una vez recorrido ambas listas, imprimimos la lista de los paises con las capitales ya introducidas.
		 */
		
		System.out.println(paises);
		
		/*
		 * Como el iterador ha recorrido toda la lista, se encuentra al final de esta. Para devolverlo al principio, volvemos a instanciar el iterador.
		 */
		
		itB = capitales.listIterator();
		
		/*
		 * Ahora queremos borrar de la lista de capitales, las que se encuentran en las posiciones pares.
		 */
		
		while (itB.hasNext()) {
			
			itB.next(); //Saltamos a la primera
			
			if(itB.hasNext()) { //Comprobamos si habría una siguiente, en este caso sí habria una par, si la hay, saltamos a ella y la eliminamos.
				
				itB.next();
				itB.remove();
				
			}
		}
		
		/*
		 * Comprobamos si hemos borrado los pares correctamente.
		 */
		
		System.out.println(capitales);
		
		/*
		 *Para borrar de la lista paises las capitales que quedaron en la lista capitales, usamos removeAll(), pasando la lista con los componentes a eliminar como paramtetro. 
		 */
		
		paises.removeAll(capitales);
		
		System.out.println(paises);
		
		
	}

}
