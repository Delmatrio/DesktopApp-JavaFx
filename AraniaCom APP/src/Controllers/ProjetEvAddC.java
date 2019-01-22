package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ProjetEv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProjetEvAddC extends ProjetEv implements Initializable{
	
	

    @FXML
    private JFXDatePicker di;
    @FXML
    private JFXTextField g;
    @FXML
    private JFXTextField e;
    @FXML
    private JFXTextField t1;
    @FXML
    private JFXTextField t2;
    @FXML
    private JFXTextField m1;
    @FXML
    private JFXTextField m2;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField adr;
    @FXML
    private JFXTextArea dd;
    @FXML
    private JFXComboBox<String> etat;
    @FXML
    private JFXComboBox<String> sr;
    @FXML
    private JFXTextField sw;
    @FXML
    private JFXButton addPE;
    @FXML
    private JFXButton back;
    @FXML
    private Label affiche;
	
	private static final long serialVersionUID = 1L;
	// VAR POUR CE CLASSE
    boolean cond = false;
    
    
    /***************************************************/
	@FXML
	public void AjoutPE() throws Exception {
		ProjetEv P= new ProjetEv(); 

		cond =  Validation();
    if (cond == true)
		{
		//bloc creation Client 
		P.setDateajout(di.getValue());
		P.setGerant(g.getText());
		P.setEntreprise(e.getText());
		P.setT1(t1.getText());
		P.setT2(t2.getText());
		P.setM1(m1.getText());
		P.setM2(m2.getText());
		P.setAdress(adr.getText());
		P.setDDet(dd.getText());
		P.setETAT(etat.getSelectionModel().getSelectedItem());
		P.setSrcc(sr.getSelectionModel().getSelectedItem());
		P.setLinkWeb(sw.getText());
		P.setIdEv(id.getText());
		
		saveProjetEv("ProjetEv.txt",P);  
        di.getEditor().clear();
        g.clear();
        e.clear();
        t1.clear();
        t2.clear();
        m1.clear();
        m2.clear();
        adr.clear();
        dd.clear();
        sw.clear();
        sr.getSelectionModel().selectFirst();
        etat.getSelectionModel().selectFirst();
        id.clear();

         
        affiche.setText("Projet ajouté avec succée! ");
		}
    else
    {   
    	
    	if(FindProjetEv(id.getText(),"ProjetEv.txt") )
    		affiche.setText("Projet déjà enregistrée ! ");	
    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
    	    	
 }   

	}
    
    private boolean Validation() throws Exception {
    	boolean res=false;
   if (   !(FindProjetEv(id.getText(),"ProjetEv.txt" )))
   { if( (isNumber(id.getText()))   && (isNumber(t1.getText())) && (isNumber(t2.getText()) || t2.getText().equals("") ) &&    (valEmail(m1.getText())) && (valEmail(m2.getText()) || m2.getText().equals("") ) )
 	  res=true ;}    	
    	return res;
	}
   
    /***************************************************/
    //function validate Email form
    public static boolean valEmail(String in)
    { String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher=emailPat.matcher(in);
    return matcher.find();}
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
		addPE.getScene().getWindow().hide();
    	Stage back = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiProjet.fxml"));
    	Scene scene = new Scene(root);
    	back.setScene(scene);
    	back.show();
    	back.setResizable(false); }

	/***************************************************/

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// liste des types pour les projets:


		etat.getItems().add("");
		etat.getItems().add("à contacter ");
		etat.getItems().add("en attente ");
		etat.getItems().add("raté ");
		etat.getItems().add("validé ");
		sr.getItems().add("");
		sr.getItems().add("la-foire ");
		sr.getItems().add("WEB ");

		
		
		
	}
	

}
