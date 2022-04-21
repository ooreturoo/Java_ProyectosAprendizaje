module TiroAlPlato {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	
	opens com.retur to javafx.graphics, javafx.fxml;
}
