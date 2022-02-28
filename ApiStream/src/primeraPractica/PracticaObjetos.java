package primeraPractica;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import objetoPractica.Productos;

public class PracticaObjetos {
	public static void main(String[] args) {
		List<Productos> productos = new ArrayList<>();
		productos.add(new Productos("Leche", 0.89));
		productos.add(new Productos("Galletas Chocolate", 1.5));
		productos.add(new Productos("Huevos", 2.20));
		productos.add(new Productos("Mermelada", 1.89));
		productos.add(new Productos("Cereales", 1.57));
		productos.add(new Productos("Jamón", 5.30));
		productos.add(new Productos("Yogures", 1.99));
		productos.add(new Productos("Pizza", 1.69));
		productos.add(new Productos("Chorizo", 1.99));
		productos.add(new Productos("Gel", 2.39));
		productos.add(new Productos("Desodorante", 2.19));
		productos.add(new Productos("Agua", 1.18));
		productos.add(new Productos("Toallitas", 1.50));
		productos.add(new Productos("Avena", 0.99));
		productos.add(new Productos("Zumo de Piña", 2.09));
		productos.add(new Productos("Queso Curado", 11.89));
		
		//Recogemos en un objeto estadisticas la cantidad, suma, minimo y maximo, y media de los precios de los productos.
		DoubleSummaryStatistics estadisticas = productos.stream()
				.collect(Collectors.summarizingDouble(Productos::getPrecio));
		System.out.println(estadisticas);
		
		System.out.println();
		
		//Recoge unos datos y los agrupa en un map con dos condiciones, la segunda tiene que ser un collectors.
		Map<Integer, List<Productos>> listaProductos = productos.stream()
														.collect(Collectors.groupingBy(Productos::getId));
		System.out.println(listaProductos.entrySet());
		
		System.out.println();
		
		//Se agrupan los repetidos y se suman los precios.
		productos.add(new Productos("Leche", 0.89));
		productos.add(new Productos("Cereales", 1.57));
		Map<String, Double> sumaPrecios = productos.stream()
				.collect(Collectors.groupingBy(Productos::getNombreProducto, Collectors.summingDouble(Productos::getPrecio)));
		
		System.out.println(sumaPrecios + "\n");
		
		
		//Transformamos el stream de productos a doubles con el map y lo recogemos con collect para una nueva lista Double.
		List<Double> listaPrecios = productos.stream()
											.map(Productos::getPrecio)
											.collect(Collectors.toList());
		listaPrecios.forEach((p) -> System.out.print(p + " "));
		
		System.out.println();
		
		/*
		 * A partir de la lista de precios anterior, la reducimos con el metodo reduce y la guardamos en un Optional que este devuelve.
		 * Una vez guardado cogemos el valor con el metodo get para guardarlo en una variable Double.
		 */
		Optional<Double> sumaTodosPrecios = listaPrecios.stream()
											.reduce((a,b) -> a + b);
		double sumaTodosPreciosV = sumaTodosPrecios.get();
		System.out.println(sumaTodosPreciosV);
		
		//Convertimos la lista en un mapa con la id de clave y el nombre como value y lo omprimimos.
		Map<Integer,String> listaP= productos.stream()
				.collect(Collectors.toMap(Productos::getId, Productos::getNombreProducto));
		listaP.entrySet().forEach((p) -> System.out.print(p + " "));
					
		
		
	}
}
