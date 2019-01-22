package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.jfoenix.controls.*;

import application.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SignupC extends Users implements Initializable{

	 
	private static final long serialVersionUID = 1L;
	boolean Verif=false;
	@FXML
    private  JFXTextField nomuser;
    @FXML
    private JFXPasswordField mpass1;
    @FXML
    private JFXPasswordField mpass2;
    @FXML
    private JFXTextField nomad;
    @FXML
    private JFXPasswordField mpassad;
    @FXML
    private JFXButton Creer;
    @FXML
    private JFXButton retour;
    @FXML
    private Label res;
	
    @FXML
    public void backhome(ActionEvent e1) throws IOException {
    	Creer.getScene().getWindow().hide();
    	Stage retour = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
    	Scene scene = new Scene(root);
    	retour.setScene(scene);
    	retour.show();
    	retour.setResizable(false);
    }
    @FXML
    public void onCreer()  throws Exception {
    	
		Users U= new Users();

		Verif =Validation();
    	
    	if ( Verif == true)
    	{	 
    			  U.setN(nomuser.getText().toString());
    			  U.setP(mpass1.getText().toString());
    			  Users.saveUser("Users.txt",U);
    		      res.setText("vous avez creer un compte utilisateur avec succée!");
    		      System.out.println("Done");
    		       nomuser.clear();
    		       mpass1.clear();
    		       mpass2.clear();
    		       nomad.clear();
    		       mpassad.clear();
    
    	}
    	else {	if(FindUser(nomuser.getText() , "Users.txt")) {res.setText("Nom utilisateur utilisé");}
    	        else {res.setText("Erreur ! Verifier vos informations");}		
    	     }
    }
     
    public  boolean Validation( ) throws Exception {
    	
    	   if ( (!FindUser(nomuser.getText(), "Users.txt")) && ( validuser(nomuser.getText()) ) &&  (Pattern.matches(mpass1.getText() , mpass2.getText() )) &&((mpass1.getLength()>4)) && (nomad.getText().toString().equals("admin") ) && (mpassad.getText().toString().equals("admin")) )
    	    return true;
 
    	    else 
    	    		return false;
    } 

    private boolean validuser(String s) { return Pattern.matches("^[a-z0-9_-]{3,15}$" , s);}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomuser.setStyle("-fx-text-inner-color: #ffffffff; " );
		mpass1.setStyle("-fx-text-inner-color: #ffffffff; " );
		mpass2.setStyle("-fx-text-inner-color: #ffffffff; " );
		nomad.setStyle("-fx-text-inner-color: #ffffffff; " );
		mpassad.setStyle("-fx-text-inner-color: #ffffffff; " );
		}
	
}
