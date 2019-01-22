package Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import application.Client;
import application.Lot;
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

public class AffLotC  implements Initializable {

		    @FXML
		    private JFXButton goadd;
		    @FXML
		    private JFXButton del;
		    @FXML
		    private JFXButton Backhome;
		    
		    @FXML
		    private TableView<Lot> Table;
		    @FXML
		    private TableColumn<Lot, String> noml;
		    @FXML
		    private TableColumn<Lot, String> typel;
		    @FXML
		    private TableColumn<Lot, Date> dal;
		    @FXML
		    private TableColumn<Lot, String> descl;
		    @FXML
		    private TableColumn<Lot, Date> ddl;
		    @FXML
		    private TableColumn<Lot, String> prix;
		    @FXML
		    private TableColumn<Lot, Date> dfl;
		    @FXML
		    private TableColumn<Lot, Date> dpl;
		    @FXML
		    private TableColumn<Lot, String> duresl;

		    ObservableList<Lot> data = FXCollections.observableArrayList();

		    @Override
			public void initialize(URL arg0, ResourceBundle arg1) {

		    	if (!(Client.EmptyF("Lot.txt"))) {
		    	 
		    	noml.setCellValueFactory(new PropertyValueFactory <Lot , String> ("nomLot"));
		    	typel.setCellValueFactory(new PropertyValueFactory <Lot , String> ("TypeLot"));
		    	dal.setCellValueFactory(new PropertyValueFactory <Lot , Date> ("dateajoutLot"));
		    	descl.setCellValueFactory(new PropertyValueFactory <Lot , String> ("DescrDetLot"));
		    	ddl.setCellValueFactory(new PropertyValueFactory <Lot , Date> ("datedebut"));
		    	prix.setCellValueFactory(new PropertyValueFactory <Lot , String> ("Prix"));
		    	dfl.setCellValueFactory(new PropertyValueFactory <Lot , Date> ("datefin"));
		    	dpl.setCellValueFactory(new PropertyValueFactory <Lot , Date> ("datepaiment"));
		    	duresl.setCellValueFactory(new PropertyValueFactory <Lot , String> ("dureeEstimee"));
		    	
		    	ArrayList<Lot> l = new ArrayList<Lot>();
				try {
				l = Lot.readFromFileL("Lot.txt");
				}catch(Exception e) {
					System.out.println(e);
				}
				Iterator<Lot> it = l.iterator();
				while (it.hasNext()) {
					Lot L = it.next();  
					  this.data.add(L);
				}
				Table.setItems(data);
				
		    	
			}}
		    
		    
		    
		  
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


