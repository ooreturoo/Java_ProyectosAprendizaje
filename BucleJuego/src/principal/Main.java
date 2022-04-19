package principal;

public class Main {

	public static void main(String[] args) {
		
		long tiempoAnterior = System.currentTimeMillis();
		long tiempo = tiempoAnterior;
		long fpsAnterior = tiempoAnterior;
		final int FPS = 120;
		long finalBucle = System.currentTimeMillis();
		int fps = 0;
		
		
		while (finalBucle - tiempoAnterior <= 8000) {
			
			tiempoAnterior = System.currentTimeMillis();
			fps++;
			
//			if(tiempoAnterior - fpsAnterior >= 1000/FPS  && fps < FPS) {
//				fpsAnterior = tiempoAnterior;
//				
//				
//			}
			
			if (System.currentTimeMillis() - tiempo >= 1000) {
				
				System.out.println(fps);
				tiempo += 1000;
				fps = 0;
				
			}
			
		}
		
	}
	
}
