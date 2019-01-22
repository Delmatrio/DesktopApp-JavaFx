package Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorControl {
	
	@FXML
    private Button Ree;
	
	public void close() {
		
		 Stage stage = (Stage) Ree.getScene().getWindow();
		    stage.close();		
		
	}

}
