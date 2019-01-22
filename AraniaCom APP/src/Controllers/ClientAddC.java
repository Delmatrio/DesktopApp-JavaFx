package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ClientAddC extends Client implements Initializable{
	
	
	private static final long serialVersionUID = 1L;
	//variable FXML View
	@FXML
    private JFXTextField ident;
    @FXML
    private JFXTextField namec;
    @FXML
    private JFXTextField secnamec;
    @FXML
    private JFXTextField num1;
    @FXML
    private JFXTextField num2;
    @FXML
    private JFXTextField mail1;
    @FXML
    private JFXTextField mail2;
    @FXML
    private  JFXCheckBox ger;
    @FXML
    private JFXCheckBox autre;
    @FXML
    private JFXTextArea autredec;
    @FXML
    private JFXTextField addrs;
    @FXML
    private JFXTextArea descdet;
    @FXML
    private JFXComboBox<String> source;
    @FXML
    private JFXButton addc;
    @FXML
    private JFXButton backc;
    @FXML
    private Label affiche;
	

    // VAR POUR CE CLASSE
    boolean cond = false;
    
    
    /***************************************************/
	@FXML
	public void Ajout() throws Exception {
		Client C= new Client(); 

		cond =  Validation();
    if (cond == true)
		{
		//bloc creation Client 
		C.setIdC(ident.getText());
		C.setNom(namec.getText());
		C.setPrenom(secnamec.getText());
		C.setTel1(num1.getText());
		C.setTel2(num2.getText());
		C.setMail1(mail1.getText());
		C.setMail2(mail2.getText());
		C.setMetier( SelMet() );
		C.setDesautre(autredec.getText());
		C.setAdresse(addrs.getText());
		C.setDescrDet(descdet.getText());
		C.setSource(source.getSelectionModel().getSelectedItem());
		
		//Client.
		saveClient("Client.txt", C);
        
        ident.clear();
        namec.clear();
        secnamec.clear();
        num1.clear();
        num2.clear();
        mail1.clear();
        mail2.clear();
        addrs.clear();
        descdet.clear();
        autredec.clear();
        ger.setSelected(false);
        autre.setSelected(false);
        source.getSelectionModel().selectFirst();

         
        affiche.setText("Client ajouté avec succée! ");
		}
    else
    {   
    	
    	if(FindClient(ident.getText().toString(),"Client.txt") )
    		affiche.setText("identifiant déjà utilisé ! ");	
    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
   	    	
 }   

	}
    
    private boolean Validation() throws Exception {
    	boolean res=false;
       if (   !(FindClient(ident.getText(),  "Client.txt" ) ) )
    	              { if( (isNumber(ident.getText())) && (Pattern.matches("[a-zA-Z]+", namec.getText())) && (Pattern.matches("[a-zA-Z]+", secnamec.getText())) && (isNumber(num1.getText())) && (isNumber(num2.getText()) || num2.getText().equals("") ) &&    (valEmail(mail1.getText())) && (valEmail(mail2.getText()) || mail2.getText().equals("") ) )
    	            	  res=true ;}    	
    	return res;
	}
    /***************************************************/
    //checked work
    public  String SelMet()
    {
    if ( ger.isSelected()   )
    	return "Gerant";
    else if (autre.isSelected())
        return "Autre";
    else return "";
    }
    /***************************************************/
	// function validate number form
    public static boolean isNumber(String in)
    { try {
    Integer.parseInt(in);
    return true;}
    catch (Exception E)
    { System.out.println("Mouch numrou");
    	return false; } }
    /***************************************************/
    //function validate Email form
    public static boolean valEmail(String in)
    { String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher=emailPat.matcher(in);
    return matcher.find();}
    /***************************************************/
	@FXML
    void goBack(ActionEvent event) throws IOException {
    	addc.getScene().getWindow().hide();
    	Stage backc = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiClient.fxml"));
    	Scene scene = new Scene(root);
    	backc.setScene(scene);
    	backc.show();
    	backc.setResizable(false); }

	/***************************************************/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		source.getItems().add("");
		source.getItems().add("la-foire ");
		source.getItems().add("WEB ");
		
	
	}

	
}
