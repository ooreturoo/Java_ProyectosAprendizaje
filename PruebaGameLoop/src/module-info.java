module PruebaGameLoop {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens ejecutador to javafx.graphics, javafx.fxml;
	opens controlador to javafx.graphics, javafx.fxml;
}
