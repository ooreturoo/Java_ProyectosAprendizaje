

public class Prueba {

	
	
	public static void main(String[] args) {
		
		String[][] matriz = new String[10][5];
		
		
		for(int i = 0; i < matriz.length; i++) {
			
			for(int j = 0; j < matriz[0].length; j++) {
				
				
				matriz[i][j] = "X =" + i + "Y =" + j;
				
				
			}
			
			
		}
		
		for(int i = 0; i < matriz.length; i++) {
			
			for(int j = 0; j < matriz[0].length; j++) {
				
				
				System.out.print(matriz[i][j] + " | ");
				
				
			}
			
			System.out.println();
			
			
		}
		
		
		
	}
	
}
