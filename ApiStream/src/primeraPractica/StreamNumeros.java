package primeraPractica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNumeros {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(18);
		lista.add(9);
		lista.add(15);
		lista.add(32);
		lista.add(54);
		lista.add(23);
		lista.add(20);
		lista.add(32);
		lista.add(54);

		lista.forEach((l) -> System.out.print(l + " "));

		System.out.println();
		System.out.println();

		// Muestra solo los que entran en la condicion de filter, en este caso los
		// menores de 18.
		System.out.print("Filtrado de menores: ");
		lista.stream()
				.filter((p) -> p < 18)// Filtra segun la condicion.
				.forEach((l) -> System.out.print(l + " "));

		System.out.println();
		System.out.println();

		// Elimina los duplicados de la lista.
		System.out.print("Sin repetidos: ");
		lista.stream()
				.distinct()// Elimina los duplicados.
				.forEach((l) -> System.out.print(l + " "));

		System.out.println();
		System.out.println();

		// Guardamos los cambios en una nueva lista
		List<Integer> mayoresEdad = lista.stream()
										.filter((p) -> p > 18)
										.collect(Collectors.toList()); // Recoge los elementos del 
																		//filtrado anterior para 
																		//que se puedan guardar en una lista.
		System.out.print("Lista de mayores de edad: ");
		mayoresEdad.forEach((l) -> System.out.print(l + " "));

		System.out.println();
		System.out.println();
		
		//allMatch comprueba si todos los elementos de la list cumplen la condicion, y devuelve un booleano.
		boolean condicion = lista.stream()
			.allMatch((p) -> p < 60);
		System.out.println(condicion);
		
		System.out.println();
		System.out.println();
		
		//Usamos map para pasar la lista a booleana con una condicion y recogerla con collect.
		List<Boolean> condiciones = lista.stream()
			.map((p) -> p > 22)
			.collect(Collectors.toList());
		condiciones.forEach((l) -> System.out.print(l + " "));
		
		
	
	}
}
