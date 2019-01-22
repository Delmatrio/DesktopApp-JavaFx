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


import application.Lot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LotAddC extends Lot implements Initializable{

	private static final long serialVersionUID = 1L;

    @FXML
    private JFXTextField nomL;
    @FXML
    private JFXComboBox<String> typeL;
    @FXML
    private JFXDatePicker ddL;
    @FXML
    private JFXTextField DestL;
    @FXML
    private JFXTextField prixL;
    @FXML
    private JFXDatePicker DfL;
    @FXML
    private JFXDatePicker DPL;
    @FXML
    private JFXTextArea DescL;
    @FXML
    private JFXDatePicker DaL;
    @FXML
    private JFXButton AddL;
    @FXML
    private JFXButton BackL;
    @FXML
    private Label affiche;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		typeL.getItems().add("");
		typeL.getItems().add("développement site web ");
		typeL.getItems().add("maintenance site web ");
		typeL.getItems().add("développement d’une application ");
		typeL.getItems().add("conception de visuels ");
		typeL.getItems().add("référencement ");
		typeL.getItems().add("webmaster  ");
		typeL.getItems().add("administration Facebook ");
		typeL.getItems().add("autres ");
		
		
	}

	
	
	// VAR POUR CE CLASSE
    boolean cond = false;
    
    @FXML
	public void AjoutLot() throws Exception {
		Lot L= new Lot(); 

		cond =  Validation();
    if (cond == true)
		{
    	
    	//bloc creation Lot
    	L.setNomLot(nomL.getText());
    	L.setTypeLot(typeL.getSelectionModel().getSelectedItem());
    	L.setDateajoutLot(DaL.getValue());
    	L.setDescrDetLot(DescL.getText());
    	L.setDatedebut(ddL.getValue());
    	L.setDureeEstimee(DestL.getText());
    	L.setPrix(prixL.getText());
    	L.setDatefin(DfL.getValue());
    	L.setDatepaiment(DPL.getValue());
    	
    	saveLot("Lot.txt",L);
        
        nomL.clear();
        DaL.getEditor().clear();
        ddL.getEditor().clear();
        DfL.getEditor().clear();
        DPL.getEditor().clear();
        DescL.clear();
        DestL.clear();
        prixL.clear();
        typeL.getSelectionModel().selectFirst();
            
        affiche.setText("Lot ajouté avec succée! ");
		}
    else
    {   
    	
    	   if( FindLot(nomL.getText() ,"Lot.txt") )
    		affiche.setText("Lot existant ! ");	
    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
    	    	
 }   

	}
    
    private boolean Validation() throws Exception {
    	boolean res=false;
       if (   !( FindLot(nomL.getText(),"Lot.txt" ) ))
    	              { if(  (isNumber(prixL.getText())) )
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
		AddL.getScene().getWindow().hide();
    	Stage BackL = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiLot.fxml"));
    	Scene scene = new Scene(root);
    	BackL.setScene(scene);
    	BackL.show();
    	BackL.setResizable(false); }

    /***************************************************/
    //function validate Email form
    public static boolean valEmail(String in)
    { String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    Matcher matcher=emailPat.matcher(in);
    return matcher.find();}
    /***************************************************/
	
	
	
	
	
}
