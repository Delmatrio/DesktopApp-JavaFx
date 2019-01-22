package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Projet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProjetAddC extends Projet implements Initializable{

	
 	private static final long serialVersionUID = 1L;
	@FXML
    private JFXButton AddP;
    @FXML
    private JFXButton Bback;
    @FXML
    private JFXTextField nomp;
    @FXML
    private JFXComboBox<String> typep;
    @FXML
    private JFXTextField webp;
    @FXML
    private JFXTextField ahp;
    @FXML
    private JFXTextField aftpp;
    @FXML
    private JFXTextField acap;
    @FXML
    private JFXTextField aap;
    @FXML
    private JFXTextField cp;
    @FXML
    private JFXTextArea ddp;
    @FXML
    private JFXTextField nbrp;
    @FXML
    private JFXComboBox<String> ghwp;
    @FXML
    private JFXDatePicker dcp;
    @FXML
    private Label affiche;

	
	
	
    // VAR POUR CE CLASSE
    boolean cond = false;
    
    
    /***************************************************/
	@FXML
	public void AjoutP() throws Exception {
		Projet P= new Projet(); 

		cond =  Validation();
    if (cond == true)
		{
		//bloc creation Client 
		P.setNomProjet(nomp.getText());
		P.setTypeProjet(typep.getSelectionModel().getSelectedItem());
		P.setSiteweb(webp.getText());
		P.setAcceeHeber(ahp.getText());
		P.setAcceeFTP(aftpp.getText());
		P.setAcceeCptAdmin(acap.getText());
		P.setAcceeAutres(aap.getText());
		P.setContact(cp.getText());
		P.setDescrDetProjet(ddp.getText());
		P.setNbrLot(nbrp.getText());
		P.setGestHeberWeb(ghwp.getSelectionModel().getSelectedItem());
		P.setDatecommande(dcp.getValue());
		saveProjet("Projet.txt",P);
        
        nomp.clear();
        typep.getSelectionModel().selectFirst();
        webp.clear();
        ahp.clear();
        aftpp.clear();
        acap.clear();
        aap.clear();
        cp.clear();
        ddp.clear();
        nbrp.clear();
        ghwp.getSelectionModel().selectFirst();
        dcp.getEditor().clear();
         
        affiche.setText("Projet ajouté avec succée! ");
		}
    else
    {   
    	
    	if(FindProjet(nomp.getText(), "Projet.txt") )
    		affiche.setText("Projet déjà enregistrée ! ");	
    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
    	    	
 }   

	}
    
    private boolean Validation() throws Exception {
    	boolean res=false;
   if (   !(FindProjet(nomp.getText(),"Projet.txt" )))
    	              { if( (Pattern.matches("[a-zA-Z]+", nomp.getText())) &&(isNumber(nbrp.getText())) )
    	            	  res=true ;}    	
    	return res;
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
	@FXML
    void goBack(ActionEvent event) throws IOException {
    	AddP.getScene().getWindow().hide();
    	Stage Bback = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiProjet.fxml"));
    	Scene scene = new Scene(root);
    	Bback.setScene(scene);
    	Bback.show();
    	Bback.setResizable(false); }

	/***************************************************/
	
    
    
    
    
    
    
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// liste des types pour les projets:
		typep.getItems().add("");
		typep.getItems().add("développement site web ");
		typep.getItems().add("maintenance site web ");
		typep.getItems().add("développement d’une application ");
		typep.getItems().add("conception de visuels ");
		typep.getItems().add("référencement ");
		typep.getItems().add("webmaster  ");
		typep.getItems().add("administration Facebook ");
		typep.getItems().add("autres ");
		ghwp.getItems().add("");
		ghwp.getItems().add("Client");
		ghwp.getItems().add("AraniaCom");
		
		
	}

}
