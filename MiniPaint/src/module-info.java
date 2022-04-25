module MiniPaint {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.retur.paint to javafx.graphics, javafx.fxml;
	opens com.retur.paint.controlador to javafx.graphics,javafx.fxml;
}
