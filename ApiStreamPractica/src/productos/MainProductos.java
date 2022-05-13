package productos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class MainProductos {

	public static void main(String[] args) {
		
		List<Productos> productos = new ArrayList<>();
		productos.add(new Productos("Leche", 0.89));
		productos.add(new Productos("Galletas Chocolate", 1.5));
		productos.add(new Productos("Huevos", 2.20));
		productos.add(new Productos("Mermelada", 1.89));
		productos.add(new Productos("Cereales", 1.57));
		productos.add(new Productos("Jamon", 5.30));
		productos.add(new Productos("Yogures", 1.99));
		productos.add(new Productos("Pizza", 1.69));
		productos.add(new Productos("Chorizo", 1.99));
		productos.add(new Productos("Gel", 2.39));
		productos.add(new Productos("Desodorante", 2.19));
		productos.add(new Productos("Agua", 1.18));
		productos.add(new Productos("Toallitas", 1.50));
		productos.add(new Productos("Avena", 0.99));
		productos.add(new Productos("Zumo de Pi�a", 2.09));
		productos.add(new Productos("Queso Curado", 11.89));
		
		
		//Recoge unos datos y los agrupa en un map con dos condiciones, la segunda tiene que ser un collectors.
				Map<Integer, List<Productos>> listaProductos = productos.stream()
																.collect(Collectors.groupingBy(Productos::getId));
				System.out.println(listaProductos.entrySet());
		
	}
			
}
