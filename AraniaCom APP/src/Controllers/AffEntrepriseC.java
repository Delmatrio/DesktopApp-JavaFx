package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
import application.Entreprise;
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

public class AffEntrepriseC extends Entreprise implements Initializable {

		private static final long serialVersionUID = 1L;

		
	    @FXML
	    private JFXButton Backhome;
	    
	    @FXML
	    private TableView<Entreprise> Table;
	    @FXML
	    private TableColumn<Entreprise, String> nomE;
	    @FXML
	    private TableColumn<Entreprise, String> CatE;
	    @FXML
	    private TableColumn<Entreprise, String> AdE;
	    @FXML
	    private TableColumn<Entreprise, String> Tel1E;
	    @FXML
	    private TableColumn<Entreprise, String> Mail1E;
	    @FXML
	    private TableColumn<Entreprise, String> DescE;
		
	    ObservableList<Entreprise> data = FXCollections.observableArrayList();


		
		
	    
	  //Boutton RETOUR
	    @FXML
	    void goMenu(ActionEvent event) throws IOException {
	    	Backhome.getScene().getWindow().hide();
	    	Stage Backhome = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/MenuUser.fxml"));
	    	Scene scene = new Scene(root);
	    	Backhome.setScene(scene);
	    	Backhome.show();
	    	Backhome.setResizable(false); }
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {


			if (!(Client.EmptyF("Entreprise.txt"))) {
					nomE.setCellValueFactory(new PropertyValueFactory <Entreprise , String> ("nomEntr"));
					CatE.setCellValueFactory(new PropertyValueFactory <Entreprise , String> ("Categorie"));
					AdE.setCellValueFactory(new PropertyValueFactory <Entreprise, String> ("adresseEntr"));
					Tel1E.setCellValueFactory(new PropertyValueFactory <Entreprise, String> ("Tel1Entr"));
					Mail1E.setCellValueFactory(new PropertyValueFactory <Entreprise, String> ("Mail1Entr"));
					DescE.setCellValueFactory(new PropertyValueFactory <Entreprise, String> ("DescrDetEntr"));
					
					ArrayList<Entreprise> l = new ArrayList<Entreprise>();
					try {
					l = Entreprise.readFromFile("Entreprise.txt");
					}catch(Exception e) {
						System.out.println(e);
					}
					Iterator<Entreprise> it = l.iterator();
					while (it.hasNext()) {
						  Entreprise E = it.next();  
						  this.data.add(E);
					}
					Table.setItems(data);
					
				   
			}
			
		}
	

}
