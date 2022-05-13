import java.awt.MouseInfo;

public class Prueba {

	
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 10000; i++) {
			
			System.out.println(MouseInfo.getPointerInfo().getLocation().x);
			
		}
		
		
		
	}
	
}
