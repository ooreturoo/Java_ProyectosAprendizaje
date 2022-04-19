package principal;
	
import javafx.application.Application;
import javafx.stage.Stage;
import vista.Juego;
import vista.VistaJuego;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			VistaJuego vista= new VistaJuego();
			Scene scene = new Scene(vista.getRaiz(),720,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			new Juego().cicloJuego();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
