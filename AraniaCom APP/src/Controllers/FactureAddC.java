package Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Facture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FactureAddC extends Facture implements Initializable{


    @FXML
    private JFXTextField FID;
    @FXML
    private JFXDatePicker Dat;
    @FXML
    private JFXTextField Ht;
    @FXML
    private JFXTextField T;
    @FXML
    private JFXTextField Ttc;
    @FXML
    private JFXComboBox<String> Tpay;
    @FXML
    private JFXTextField idclf;
    @FXML
    private JFXTextField idenf;
    @FXML
    private JFXButton AddF;
    @FXML
    private JFXButton Bback;
    @FXML
    private Label affiche;
	private static final long serialVersionUID = 1L;
	
	LocalDate ld;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Tpay.getItems().add("");
		Tpay.getItems().add("OUI");
		Tpay.getItems().add("NON");
		
	}
	
	
	
	// VAR POUR CE CLASSE
    boolean cond = false;
    
    @FXML
	public void AjoutFact() throws Exception {
		Facture F= new Facture(); 

	cond =  Validation();
    if (cond == true)
		{
    	
    	//bloc creation Facture
    	F.setIdf(FID.getText());
        F.setDateFact(Dat.getValue());
    	F.setMntFactHT(Ht.getText());
    	F.setMntTVA(T.getText());
    	F.setMntFactTTC(Ttc.getText());
    	F.setTVAPayee(Tpay.getSelectionModel().getSelectedItem());
    	F.setIdcl(idclf.getText());
    	F.setIden(idenf.getText());
    	
        saveFacture("Facture.txt",F);
       
        FID.clear();
        Dat.getEditor().clear();
        Ht.clear();
        T.clear();
        Ttc.clear();
        Tpay.getSelectionModel().selectFirst();
            
        affiche.setText("Entreprise ajoutée avec succée! ");
		}
    else
    {   
    	
    	if(FindFacture(FID.getText() ,"Facture.txt") )
    		affiche.setText("cette ID déjà utilisée ! ");	
    	    else affiche.setText("<<< Erreur: Des informations Invalid!!>>>");
    	    	
 }   

	}
    
    private boolean Validation() throws Exception {
    	boolean res=false;
       if (  !(FindFacture(FID.getText() ,"Facture.txt")  ))
    	              { if(  (isNumber(Ht.getText())) && (isNumber(T.getText()) ) &&   (isNumber(Ttc.getText()) )  )
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
		AddF.getScene().getWindow().hide();
    	Stage Bback = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiFacture.fxml"));
    	Scene scene = new Scene(root);
    	Bback.setScene(scene);
    	Bback.show();
    	Bback.setResizable(false); }

	/***************************************************/

	
	
	
	

}
