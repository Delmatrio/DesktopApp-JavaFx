package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Client;
import application.Facture;
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

public class FactureC extends Facture implements Initializable {

	
	private static final long serialVersionUID = 1L;
	@FXML
    private JFXButton goadd;
    @FXML
    private JFXButton del;
    @FXML
    private JFXButton Backhome;

    @FXML
    private TableView<Facture> Table;
    @FXML
    private TableColumn<Facture, String> Fid;
    @FXML
    private TableColumn<Facture, Date> Fdate;
    @FXML
    private TableColumn<Facture, String> HT;
    @FXML
    private TableColumn<Facture, String> TVA;
    @FXML
    private TableColumn<Facture, String> TTC;
    @FXML
    private TableColumn<Facture, String> TVAP;
    @FXML
    private TableColumn<Facture, String> IDC;
    @FXML
    private TableColumn<Facture, String> IDE;

    ObservableList<Facture> data = FXCollections.observableArrayList();

	
	//boutton AJOUTER
    @FXML
    void goAjoutFACT(ActionEvent event) throws IOException {
    	Backhome.getScene().getWindow().hide();
    	Stage goadd = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddFacture.fxml"));
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

  //Suppression row
    @FXML
    void delSelC(ActionEvent event) throws Exception {
       Facture F = Table.getSelectionModel().getSelectedItem();
	   System.out.println(F.getIdf());
	   Facture.supprimer(F.getIdf());
	   Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );

    }
    
	   
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (!(Client.EmptyF("Facture.txt"))) {

		Fid.setCellValueFactory(new PropertyValueFactory <Facture , String> ("idf"));
		Fdate.setCellValueFactory(new PropertyValueFactory <Facture , Date> ("DateFact"));
		HT.setCellValueFactory(new PropertyValueFactory <Facture , String> ("MntFactHT"));
		TVA.setCellValueFactory(new PropertyValueFactory <Facture , String> ("MntTVA"));
		TTC.setCellValueFactory(new PropertyValueFactory <Facture, String> ("MntFactTTC"));
		TVAP.setCellValueFactory(new PropertyValueFactory <Facture , String> ("TVAPayee"));
		IDC.setCellValueFactory(new PropertyValueFactory <Facture , String> ("idcl"));
		IDE.setCellValueFactory(new PropertyValueFactory <Facture , String> ("iden"));
		ArrayList<Facture> l = new ArrayList<Facture>();
		try {
		l = Facture.readFromFileF("Facture.txt");
		}catch(Exception e) {
			System.out.println(e);
		}
		Iterator<Facture> it = l.iterator();
		while (it.hasNext()) {
			  Facture F = it.next();  
			  this.data.add(F);
		}
		Table.setItems(data);
		
	}}
	

}
