package coches;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCoches {

	public static void main(String[] args) {
		
		//SET DE COCHES
		
		HashSet<Coche> set = new HashSet<Coche>();
		
		set.add(new Coche(Marca.OPEL,"1234H",5,Combustible.ELECTRICIDAD));
		set.add(new Coche(Marca.BMW,"1234H",9,Combustible.GASOIL));
		set.add(new Coche(Marca.DACIA,"1234H",7,Combustible.GASOIL));
		set.add(new Coche(Marca.FERRARI,"1234H",12,Combustible.GASOLINA));
		set.add(new Coche(Marca.KIA,"1234H",1,Combustible.ELECTRICIDAD));
		set.add(new Coche(Marca.BMW,"1234H",3,Combustible.ELECTRICIDAD));
		set.add(new Coche(Marca.PEUGEOT,"1234H",11,Combustible.GASOIL));
		
		
		System.out.println("MOSTRAR TODAS LAS ESTADÍSTICAS AÑOS DE LOS COCHES");
		IntSummaryStatistics estadisticasAnios= set.stream().collect(Collectors.summarizingInt(Coche::getAnios));
		System.out.println(estadisticasAnios);
		
		
		System.out.println("\nTOTAL DE COCHES QUE NO SON ELECTRICOS");
		long cochesNoElectricidad = set.stream().filter((c) -> c.getCombustible() != Combustible.ELECTRICIDAD).count();
		System.out.println(cochesNoElectricidad);
		
		System.out.println("\nENCONTRAR EL PRIMERO");
		Optional<Coche> primerCoche = set.stream().findFirst();
		System.out.println(primerCoche);
		
		System.out.println("\nENCONTRAR ALGUNO");
		Optional<Coche> algunCoche = set.stream().filter(c -> c.getAnios() >  15).findAny();
		System.out.println(algunCoche);

	}
	
}
