package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
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

public class ClientC  implements Initializable {
	

    @FXML
	private JFXButton goadd;
	@FXML
    private JFXButton del;
    @FXML
    private JFXButton Backhome;
   
    @FXML
    private TableView<Client> Table;
    @FXML
    private TableColumn<Client, String> Aid;
    @FXML
    private TableColumn<Client, String> Anom;
    @FXML
    private TableColumn<Client, String> Apren;
    @FXML
    private TableColumn<Client, String> Atel1;
    @FXML
    private TableColumn<Client, String> Amail1;
    @FXML
    private TableColumn<Client, String> Ametier;
    @FXML
    private TableColumn<Client, String> dmet;
    @FXML
    private TableColumn<Client, String> adr;
    @FXML
    private TableColumn<Client, String> dd;

   
    ObservableList<Client> data = FXCollections.observableArrayList();

    
    //boutton AJOUTER
    @FXML
    void goAjoutClient(ActionEvent event) throws IOException, Exception {
    	Backhome.getScene().getWindow().hide();
    	Stage goadd = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddClient.fxml"));
    	Scene scene = new Scene(root);
    	goadd.setScene(scene);
    	goadd.show();
    	goadd.setResizable(false); 
    	
    }

    //suppression des clients:Boutton SUPPRIMER
    @FXML
    void delSelC(ActionEvent event) throws Exception {
       Client cl = Table.getSelectionModel().getSelectedItem();
	   System.out.println(cl.getIdC());
	   Client.supprimer(cl.getIdC());
	   Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );

    }
   
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (!(Client.EmptyF("Client.txt"))) 
		{
		Aid.setCellValueFactory(new PropertyValueFactory <Client , String> ("idC"));
		Anom.setCellValueFactory(new PropertyValueFactory <Client , String> ("nom"));
		Apren.setCellValueFactory(new PropertyValueFactory <Client , String> ("prenom"));
		Atel1.setCellValueFactory(new PropertyValueFactory <Client , String> ("Tel1"));
		Amail1.setCellValueFactory(new PropertyValueFactory <Client , String> ("Mail1"));
		Ametier.setCellValueFactory(new PropertyValueFactory <Client , String> ("Metier"));
		dmet.setCellValueFactory(new PropertyValueFactory <Client , String> ("Desautre"));
		adr.setCellValueFactory(new PropertyValueFactory <Client , String> ("Adresse"));
		dd.setCellValueFactory(new PropertyValueFactory <Client , String> ("DescrDet"));
		ArrayList<Client> l = new ArrayList<Client>();
		try {
		l = Client.readFromFile("Client.txt");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		Iterator<Client> it = l.iterator();
		while (it.hasNext()) {
			  Client clt = it.next();  
			  this.data.add(clt);
		}
		Table.setItems(data);
		}		
		
	} 
}