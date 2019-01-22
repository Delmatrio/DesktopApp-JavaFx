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

public class MenuAdminC implements Initializable{
	
	  @FXML
	    private JFXButton Client;

	    @FXML
	    private JFXButton Fact;

	    @FXML
	    private JFXButton Entr;

	    @FXML
	    private JFXButton Proj;

	    @FXML
	    private JFXButton Compt;

	    @FXML
	    private JFXButton Lot;

	    @FXML
	    private JFXButton ProjEv;

	    @FXML
	    private JFXButton Backhome;

	
	public void goClient() throws IOException {
		
		Backhome.getScene().getWindow().hide();
    	Stage Client = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiClient.fxml"));
    	Scene scene = new Scene(root);
    	Client.setScene(scene);
    	Client.show();
    	Client.setResizable(false);
	}
	
	
      public void goFact() throws IOException {
		
		Backhome.getScene().getWindow().hide();
    	Stage Fact = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiFacture.fxml"));
    	Scene scene = new Scene(root);
    	Fact.setScene(scene);
    	Fact.show();
    	Fact.setResizable(false);
	}
	
     public void goEntr() throws IOException {
	
	Backhome.getScene().getWindow().hide();
	Stage Entr = new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiEntreprise.fxml"));
	Scene scene = new Scene(root);
	Entr.setScene(scene);
	Entr.show();
	Entr.setResizable(false);
}

    public void goProj() throws IOException {
	
	Backhome.getScene().getWindow().hide();
	Stage Proj = new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiProjet.fxml"));
	Scene scene = new Scene(root);
	Proj.setScene(scene);
	Proj.show();
	Proj.setResizable(false);
}

    public void goCompt() throws IOException {
    	
    	Backhome.getScene().getWindow().hide();
    	Stage Compt = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/GererComptes.fxml"));
    	Scene scene = new Scene(root);
    	Compt.setScene(scene);
    	Compt.show();
    	Compt.setResizable(false);
    }
	


public void goLot() throws IOException {
    	
    	Backhome.getScene().getWindow().hide();
    	Stage Lot = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiLot.fxml"));
    	Scene scene = new Scene(root);
    	Lot.setScene(scene);
    	Lot.show();
    	Lot.setResizable(false);
    }



public void goHome() throws IOException {
	
	Client.getScene().getWindow().hide();
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
	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AffiEvProjet.fxml"));
	Scene scene = new Scene(root);
	ProjEv.setScene(scene);
	ProjEv.show();
	ProjEv.setResizable(false);
}


	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
