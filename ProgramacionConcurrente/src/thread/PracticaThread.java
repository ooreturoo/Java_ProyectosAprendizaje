package thread;

public class PracticaThread {
	
	
	
	public static void main(String[] args) {
		HeredaThread hilo1 = new HeredaThread();
		hilo1.start();
		HeredaThread hilo2 = new HeredaThread();
		hilo2.start();
		HeredaThread hilo3 = new HeredaThread();
		hilo3.start();
	}
}
