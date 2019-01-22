package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
import application.Projet;
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

public class AffProjetC  implements Initializable {


	   
	    @FXML
	    private JFXButton Backhome;
	    @FXML
	    private TableView<Projet> Table;

	    @FXML
	    private TableColumn<Projet, String> NomP;

	    @FXML
	    private TableColumn<Projet, String> TypeP;

	    @FXML
	    private TableColumn<Projet, String> ContP;

	    @FXML
	    private TableColumn<Projet, String> nbrLot;

	    @FXML
	    private TableColumn<Projet, Date> DCND;

	    ObservableList<Projet> data = FXCollections.observableArrayList();

		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			if (!(Client.EmptyF("Projet.txt"))) {

			NomP.setCellValueFactory(new PropertyValueFactory <Projet , String> ("nomProjet"));
			TypeP.setCellValueFactory(new PropertyValueFactory <Projet , String> ("TypeProjet"));
			ContP.setCellValueFactory(new PropertyValueFactory <Projet , String> ("Contact"));
			nbrLot.setCellValueFactory(new PropertyValueFactory <Projet , String> ("NbrLot"));
			DCND.setCellValueFactory(new PropertyValueFactory <Projet , Date> ("datecommande"));
			ArrayList<Projet> l = new ArrayList<Projet>();
			try {
				l = Projet.readFromFileP("Projet.txt");
				}catch(Exception e) {
					System.out.println(e);
				}
				Iterator<Projet> it = l.iterator();
				while (it.hasNext()) {
					  Projet P = it.next();  
					  this.data.add(P);
				}
				Table.setItems(data);
				
			}
			
		}
		
		
	    
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
		
		
		

	

}
