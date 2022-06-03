module PongBD {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens com.miravent to javafx.graphics, javafx.fxml;
	opens com.miravent.controlador to javafx.graphics, javafx.fxml;
}
