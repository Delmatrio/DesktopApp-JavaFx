package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
import application.ProjetEv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProjetEvC implements Initializable{
	
	@FXML
    private JFXButton goadd;
    @FXML
    private JFXButton del;
    @FXML
    private JFXButton Backhome;

    @FXML
    private TableView<ProjetEv> Table;
    @FXML
    private TableColumn<ProjetEv, Date> DA;
    @FXML
    private TableColumn<ProjetEv, String> ger;
    @FXML
    private TableColumn<ProjetEv, String> ent;
    @FXML
    private TableColumn<ProjetEv, String> t1;
    @FXML
    private TableColumn<ProjetEv, String> m1;
    @FXML
    private TableColumn<ProjetEv, String> adrs;
    @FXML
    private TableColumn<ProjetEv, String> d;
    @FXML
    private TableColumn<ProjetEv, String> etat;
    @FXML
    private TableColumn<ProjetEv, String> sr;
    @FXML
    private TableColumn<ProjetEv, String> LW;
    @FXML
    private TableColumn<ProjetEv, String> ide;
	
	 ObservableList<ProjetEv> data = FXCollections.observableArrayList();

		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			
			
			if (!(Client.EmptyF("ProjetEv.txt"))) {
	
				DA.setCellValueFactory(new PropertyValueFactory <ProjetEv , Date> ("dateajout"));
				ger.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("gerant"));
				ent.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("entreprise"));
				t1.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("T1"));
				m1.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("M1"));
				adrs.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("adress"));
			    d.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("DDet"));
			    etat.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("ETAT"));
			    sr.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("Srcc"));
			    LW.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("LinkWeb"));
			    ide.setCellValueFactory(new PropertyValueFactory <ProjetEv , String> ("idEv"));
			    
			    
			ArrayList<ProjetEv> l = new ArrayList<ProjetEv>();
			try {
				l = ProjetEv.readFromFilePE("ProjetEv.txt");
				}catch(Exception e) {
					System.out.println(e);
				}
				Iterator<ProjetEv> it = l.iterator();
				while (it.hasNext()) {
					  ProjetEv P = it.next();  
					  this.data.add(P);
				}
				Table.setItems(data);
				
			}
			
		}
		//Suppression row
	    @FXML
	    void delSelC(ActionEvent event)  throws Exception {
	    	ProjetEv cl = Table.getSelectionModel().getSelectedItem();
	 	   System.out.println(cl.getIdEv());
	 	  ProjetEv.supprimer(cl.getIdEv());
		   Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );
		
	    }
		
		
		//boutton AJOUTER
	    @FXML
	    void goAjoutProj(ActionEvent event) throws IOException {
	    	Backhome.getScene().getWindow().hide();
	    	Stage goadd = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddEvProjet.fxml"));
	    	Scene scene = new Scene(root);
	    	goadd.setScene(scene);
	    	goadd.show();
	    	goadd.setResizable(false);  }
	    
	  //Boutton RETOUR
	    @FXML
	    void goMenuadmin(ActionEvent event) throws IOException {
	    	goadd.getScene().getWindow().hide();
	    	Stage Backhome = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/MenuAdmin.fxml"));
	    	Scene scene = new Scene(root);
	    	Backhome.setScene(scene);
	    	Backhome.show();
	    	Backhome.setResizable(false); }
		
		
		


}
