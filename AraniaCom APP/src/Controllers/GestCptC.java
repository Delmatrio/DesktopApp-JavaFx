package Controllers;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
import application.Users;
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

public class GestCptC  implements Serializable, Initializable{

	private static final long serialVersionUID = 1L;


	@FXML
    private TableView<Users> Table;
    @FXML
    private TableColumn<Users, String> NomUser;
    @FXML
    private TableColumn<Users, String> PassUser;
    @FXML
    private JFXButton Retour;
    @FXML
    private JFXButton Suppr;
    ObservableList<Users> data = FXCollections.observableArrayList();
    
    
    
    @FXML
    void BACK(ActionEvent event) throws IOException {
    	
    	Suppr.getScene().getWindow().hide();
    	Stage Retour = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/MenuAdmin.fxml"));
    	Scene scene = new Scene(root);
    	Retour.setScene(scene);
    	Retour.show();
    	Retour.setResizable(false); }
	
    

    @FXML
    void SupprCompte(ActionEvent event) throws Exception {  
    	
    	Users cl = Table.getSelectionModel().getSelectedItem();
    	Users.supprimer(cl.getN());	
     Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );
   	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (!(Client.EmptyF("Users.txt"))) {
 
		NomUser.setCellValueFactory(new PropertyValueFactory<Users,String>("N"));
		PassUser.setCellValueFactory(new PropertyValueFactory<Users,String>("P"));
	     
	        ArrayList<Users> l = new ArrayList<Users>();
			try {
				l = Users.readFromFileU("Users.txt");
				}catch(Exception e) {
					System.out.println(e);
				}
				Iterator<Users> it = l.iterator();
				while (it.hasNext()) {
					Users P = it.next();  
					  this.data.add(P);
				}   
				
				Table.setItems(data);
				
			}                                }
            
         
	}
             
    




