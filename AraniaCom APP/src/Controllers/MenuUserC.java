package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuUserC implements Initializable{

		    @FXML
		    private JFXButton Cl;
		    @FXML
		    private JFXButton Fa;
		    @FXML
		    private JFXButton Entr;
		    @FXML
		    private JFXButton Proj;
		    @FXML
		    private JFXButton Lot;
		    @FXML
		    private JFXButton ProjEv;
		    @FXML
		    private JFXButton Backhome;

		
		public void goClient() throws IOException {
			
			Backhome.getScene().getWindow().hide();
	    	Stage Cl = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffClient.fxml"));
	    	Scene scene = new Scene(root);
	    	Cl.setScene(scene);
	    	Cl.show();
	    	Cl.setResizable(false);
		}
		
		
	      public void goFact() throws IOException {
			
			Backhome.getScene().getWindow().hide();
	    	Stage Fa = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffFacture.fxml"));
	    	Scene scene = new Scene(root);
	    	Fa.setScene(scene);
	    	Fa.show();
	    	Fa.setResizable(false);
		}
		
	     public void goEntr() throws IOException {
		
		Backhome.getScene().getWindow().hide();
		Stage Entr = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffEntreprise.fxml"));
		Scene scene = new Scene(root);
		Entr.setScene(scene);
		Entr.show();
		Entr.setResizable(false);
	}

	    public void goProj() throws IOException {
		
		Backhome.getScene().getWindow().hide();
		Stage Proj = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffProjet.fxml"));
		Scene scene = new Scene(root);
		Proj.setScene(scene);
		Proj.show();
		Proj.setResizable(false);
	}

	   
		


	public void goLot() throws IOException {
	    	
	    	Backhome.getScene().getWindow().hide();
	    	Stage Lot = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffLot.fxml"));
	    	Scene scene = new Scene(root);
	    	Lot.setScene(scene);
	    	Lot.show();
	    	Lot.setResizable(false);
	    }



	public void goHome() throws IOException {
		
		Cl.getScene().getWindow().hide();
		Stage Backhome = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
		Scene scene = new Scene(root);
		Backhome.setScene(scene);
		Backhome.show();
		Backhome.setResizable(false);
	}


	public void goProjEv() throws IOException {
		
		Backhome.getScene().getWindow().hide();
		Stage ProjEv = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/UserAff/AffProjetEv.fxml"));
		Scene scene = new Scene(root);
		ProjEv.setScene(scene);
		ProjEv.show();
		ProjEv.setResizable(false);
	}


		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		}



}
