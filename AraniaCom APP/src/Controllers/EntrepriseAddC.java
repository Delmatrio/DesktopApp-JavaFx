package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.Entreprise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EntrepriseAddC extends Entreprise implements Initializable{

	private static final long serialVersionUID = 1L;
	    @FXML
	    private JFXTextField NomEn;
	    @FXML
	    private JFXTextField Categ;
	    @FXML
	    private JFXTextField Addr;
	    @FXML
	    private JFXTextField Te1;
	    @FXML
	    private JFXTextField Te2;
	    @FXML
	    private JFXTextField Ma1;
	    @FXML
	    private JFXTextField Ma2;
	    @FXML
	    private JFXTextArea DDE;
	    @FXML
	    private JFXButton ADDE;
	    @FXML
	    private JFXButton BACK;
	    @FXML
	    private Label affiche;

	
	 // VAR POUR CE CLASSE
	    boolean cond = false;
	    
	    @FXML
		public void AjoutEn() throws Exception {
			Entreprise E= new Entreprise(); 

			cond =  Validation();
	    if (cond == true)
			{
	    	
	    	//bloc creation entreprise
	    	E.setNomEntr(NomEn.getText());
	    	E.setCategorie(Categ.getText());
	    	E.setAdresseEntr(Addr.getText());
	    	E.setTel1Entr(Te1.getText());
	    	E.setTel2Entr(Te2.getText());
	    	E.setMail1Entr(Ma1.getText());
	    	E.setMail2Entr(Ma2.getText());
	        E.setDescrDetEntr(DDE.getText());
		
	        saveEntreprise("Entreprise.txt",E);
	        
	        NomEn.clear();
	        Categ.clear();
	        Addr.clear();
	        Te1.clear();
	        Te2.clear();
	        Ma1.clear();
	        Ma2.clear();
	        DDE.clear();
	        
	            
	        affiche.setText("Entreprise ajoutée avec succée! ");
			}
	    else
	    {   
	    	
	    	if(FindEntreprise(NomEn.getText(),"Entreprise.txt" ) )
	    		affiche.setText("cette Entreprise déjà enregistrée ! ");	
	    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
	    	    	
	 }   

		}
	    
	    private boolean Validation() throws Exception {
	    	boolean res=false;
	       if (   !(FindEntreprise(NomEn.getText(),"Entreprise.txt" ) ))
	    	              { if( (Pattern.matches("[a-zA-Z]+", NomEn.getText())) && (Pattern.matches("[a-zA-Z]+", Categ.getText())) && (isNumber(Te1.getText())) && (isNumber(Te2.getText()) || Te2.getText().equals("") ) &&    (valEmail(Ma1.getText())) && (valEmail(Ma2.getText()) || Ma2.getText().equals("") ) )
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
	    //function validate Email form
	    public static boolean valEmail(String in)
	    { String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	    Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
	    Matcher matcher=emailPat.matcher(in);
	    return matcher.find();}
	    /***************************************************/
		@FXML
	    void goBack(ActionEvent event) throws IOException {
			ADDE.getScene().getWindow().hide();
	    	Stage BACK = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiEntreprise.fxml"));
	    	Scene scene = new Scene(root);
	    	BACK.setScene(scene);
	    	BACK.show();
	    	BACK.setResizable(false); }

		/***************************************************/
	
	

	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		
		
		
		
	}
	

}
