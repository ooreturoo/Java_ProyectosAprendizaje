package thread;

public class HeredaThread extends Thread{
	
	private static int cantidadHilos = 0;
	private int hilo;
	
	public HeredaThread() {
		this.hilo = ++cantidadHilos; 
		
	}

	@Override
	public void run() {
		int numero = generarAleatorio();
		while(numero <= 90) {
			numero = generarAleatorio();
		}
		
		System.out.printf("El hilo nº%d número (%d) generado es mayor que 90\n",this.hilo, numero);
	}
	
	private static int generarAleatorio() {
		return (int) Math.round(Math.random()*100);
	}
	
	
}
