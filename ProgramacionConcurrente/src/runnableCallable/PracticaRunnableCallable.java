package runnableCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PracticaRunnableCallable {
	public static void main(String[] args) {
		Thread r1 = new Thread(new HeredaRunnable());
		Thread r2 = new Thread(new HeredaRunnable());
		Thread r3 = new Thread(new HeredaRunnable());
		
		r1.start();
		r2.start();
		r3.start();
		
		//Ejecuta un hilo y crea una cola si entran más.
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> c1 = executor.submit(new HeredaCallable());
		Future<Integer> c2 = executor.submit(new HeredaCallable());
		
		try {
			System.out.println("El callable nº1 devuelve " + c1.get());
			System.out.println("El callable nº2 devuelve " + c2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		
		
	}
	
	
}
