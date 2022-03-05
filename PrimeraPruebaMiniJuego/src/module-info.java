module MiniJuego {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens vista to javafx.graphics, javafx.fxml;
}
