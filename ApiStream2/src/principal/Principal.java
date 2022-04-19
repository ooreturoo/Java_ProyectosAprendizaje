package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import objetos.Armas;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Armas> armamento = new ArrayList<Armas>();
		
		armamento.add(new Armas(3.5, 455));
		
		armamento.add(new Armas(8.5, 555));

		armamento.add(new Armas(5.5, 155));
		
		armamento.add(new Armas(1.5, 576));
		
		armamento.add(new Armas(6, 425));
		
		
		List<Armas> armasPocoDamage = armamento.stream().filter(arma -> arma.getDamage() < 6).collect(Collectors.toList());
		
		
		armasPocoDamage.forEach(System.out::println);
		
		
	}
	
	
	
}
