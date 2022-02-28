package runnableCallable;

public class HeredaRunnable implements Runnable {

	private static int cantidadHilos = 0;
	private int runnable;
	
	public HeredaRunnable() {
		this.runnable = ++cantidadHilos; 
	}
		
	

	@Override
	public void run() {
		int numero = generarAleatorio();
		while(numero <= 90) {
			numero = generarAleatorio();
		}
		
		System.out.printf("El runnable nº%d número (%d) generado es mayor que 90\n",this.runnable, numero);
	}
	
	private static int generarAleatorio() {
		return (int) Math.round(Math.random()*100);
	}
	
	
}
