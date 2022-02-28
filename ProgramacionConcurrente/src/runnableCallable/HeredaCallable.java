package runnableCallable;

import java.util.concurrent.Callable;

public class HeredaCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int numero = generarAleatorio();
		while(numero <= 90) {
			numero = generarAleatorio();
		}
		return numero;
	}
	
	private static int generarAleatorio() {
		return (int) Math.round(Math.random()*100);
	}
}
