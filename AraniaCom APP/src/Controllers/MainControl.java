package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.*;
import application.Users;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainControl extends Users implements Initializable {
	 
	private static final long serialVersionUID = 1L;
	 
	 
	int Validation = 0;
	 
	@FXML
    private JFXTextField usertxt;
    @FXML
    private JFXPasswordField userpass;
    @FXML
    private JFXButton Sin;
    @FXML
    private JFXButton Sup;
    @FXML
    private JFXButton close;
	
    String filepath="AllUsers.txt";
    

	
    @FXML
    public void loginAction(ActionEvent e) throws Exception {
    	
   if((usertxt.getText().equals(" ")) && (userpass.getText().equals(" ")) )
       {Validation=0;}
   else { 	if ((usertxt.getText().equals("admin")) && (userpass.getText().equals("admin")) )
    	      {	Validation=1;}
    	else if ( VerifUser( usertxt.getText() , userpass.getText() , filepath) )
            {Validation=2;}
   }
    
		if ( Validation == 1 )
    	{	//if administrator
    	Sup.getScene().getWindow().hide();
    	Stage Sin = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/MenuAdmin.fxml"));
    	Scene scene = new Scene(root);
    	Sin.setScene(scene);
    	Sin.show();
    	Sin.setResizable(false);
    }
    	else if (Validation == 2)
    	 {	//if simple user
    	Sup.getScene().getWindow().hide();
    	Stage Sin = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/MenuUser.fxml"));
    	Scene scene = new Scene(root);
    	Sin.setScene(scene);
    	Sin.show();
    	Sin.setResizable(false);
    }
    	else if (Validation == 0 )
        	
    	{ Sup.getScene().getWindow();
    	Stage Sin = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/ErrorLogin.fxml"));
    	Scene scene = new Scene(root);
    	Sin.setScene(scene);
    	Sin.show();
    	Sin.setResizable(false); }

    	}
    
    @FXML
    public void signUp(ActionEvent e1) throws IOException {
    	Sin.getScene().getWindow().hide();
    	Stage Sup = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/Signup.fxml"));
    	Scene scene = new Scene(root);
    	Sup.setScene(scene);
    	Sup.show();
    	Sup.setResizable(false);
    	
    }
 
    @FXML
    public void close() {
    	Platform.exit();
    }
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	usertxt.setStyle("-fx-text-inner-color: #ffffffff; " );
    	userpass.setStyle("-fx-text-inner-color: #ffffffff; " );  
    	
    
    }
  
    
}