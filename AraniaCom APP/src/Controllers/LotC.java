package Controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class LotC  implements Initializable {

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
			
			noml.setCellFactory(TextFieldTableCell.forTableColumn());                                    
			prix.setCellFactory(TextFieldTableCell.forTableColumn());
			duresl.setCellFactory(TextFieldTableCell.forTableColumn());
	  	
		}}
	    
	    /**************************************************/
	    @FXML
	    void Changedateinsertion(ActionEvent event) {

	    }

	    @FXML
	    void changeDPay(ActionEvent event) {

	    }

	    @FXML
	    void changeDatedeb(ActionEvent event) {

	    }

	    @FXML
	    void changeDfin(ActionEvent event) {

	    }

	    @FXML
	    void changeDurEst(CellEditEvent<Lot, String> cellNom) throws Exception
		{
	    	Lot PSelec = Table.getSelectionModel().getSelectedItem(); 
	    	String old = PSelec.getNomLot();
	    	String old2=PSelec.getDureeEstimee();
	    	System.out.println(old2);
	    	PSelec.setDureeEstimee(cellNom.getNewValue().toString() );
	    	// update the file:
	    	ArrayList<Lot>  L = new ArrayList<Lot>();
	    	 L = Lot.readFromFileL("Lot.txt"); 
	    	Iterator<Lot> it = L.iterator(); 
	    	while (it.hasNext())    {
	    		Lot P = it.next();
	    	 if (Objects.equals(P.getNomLot(), old)) {
	    		 P.setDureeEstimee(PSelec.getDureeEstimee());
	    	    new FileOutputStream("Lot.txt").close();
	    	    for(Lot p : L)
	    	    	p.writeToFile("Lot.txt");      }   	
	    	 
	    	 }
	    	System.out.println(" Updated !"); }

	    @FXML
	    void changeNom(CellEditEvent<Lot, String> cellNom) throws Exception
		{
	    	Lot PSelec = Table.getSelectionModel().getSelectedItem(); 
	    	String old = PSelec.getNomLot();	
	    	PSelec.setNomLot(cellNom.getNewValue().toString() );
	    	// update the file:
	    	ArrayList<Lot>  L = new ArrayList<Lot>();
	    	 L = Lot.readFromFileL("Lot.txt");
	    	
	    	Iterator<Lot> it = L.iterator();
	    	
	    	while (it.hasNext())    {
	    		Lot P = it.next();
	    	 if (Objects.equals(P.getNomLot(), old)) {
	    		 P.setNomLot(PSelec.getNomLot());
	    	    new FileOutputStream("Lot.txt").close();
	    	    for(Lot p : L)
	    	    	p.writeToFile("Lot.txt");      }   	
	    	 
	    	 }
	    	System.out.println(" Updated !"); }

	    @FXML
	    void changePrix(CellEditEvent<Lot, String> cellNom) throws Exception
		{
	    	Lot PSelec = Table.getSelectionModel().getSelectedItem(); 
	    	String old = PSelec.getNomLot();
	    	String old2=PSelec.getPrix();
	    	System.out.println(old2);
	    	PSelec.setPrix(cellNom.getNewValue().toString() );
	    	if(isNumber(PSelec.getPrix())) 
			{
	    	// update the file:
	    	ArrayList<Lot>  L = new ArrayList<Lot>();
	    	 L = Lot.readFromFileL("Lot.txt");
	    	
	    	Iterator<Lot> it = L.iterator();
	    	
	    	while (it.hasNext())    {
	    		Lot P = it.next();
	    	 if (Objects.equals(P.getNomLot(), old)) {
	    		 P.setPrix(PSelec.getPrix());
	    	    new FileOutputStream("Lot.txt").close();
	    	    for(Lot p : L)
	    	    	p.writeToFile("Lot.txt");      }   	
	    	 
	    	 }
	    	System.out.println(" Updated !"); 
		}
		else System.out.println("not a valid NBRLOT");
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
	

	    /*************************************************/
	  //boutton AJOUTER
	    @FXML
	    void goAjoutLot(ActionEvent event) throws IOException {
	    	Backhome.getScene().getWindow().hide();
	    	Stage goadd = new Stage();
	    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddLot.fxml"));
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
	   
	    void delSelC(ActionEvent event)  throws Exception {
	        Lot cl = Table.getSelectionModel().getSelectedItem();
	 	   System.out.println(cl.getNomLot());
	 	   Lot.supprimer(cl.getNomLot());
		   Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );
		   
	   
	    }

}
