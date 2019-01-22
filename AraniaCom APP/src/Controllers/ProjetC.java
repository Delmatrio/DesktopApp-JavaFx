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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ProjetC extends Projet implements Initializable {
  
	private static final long serialVersionUID = 1L;
	@FXML
    private JFXButton goadd;
    @FXML
    private JFXButton del;
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
			Table.setItems(data);  }
		 
            Table.setEditable(true);
            Table.getSelectionModel().setCellSelectionEnabled(true);
            NomP.setCellFactory(TextFieldTableCell.forTableColumn());
            nbrLot.setCellFactory(TextFieldTableCell.forTableColumn());	
            
            
            
           // DCND.setCellValueFactory(ComboBoxTableCell<Projet,Date>() );
            
            
	}
	
	
	//EDIT
	
	@FXML
	public void changeNom(CellEditEvent<Projet, String> cellNom) throws Exception
	{
	Projet PSelec = Table.getSelectionModel().getSelectedItem(); 
	String old = PSelec.getNomProjet();	
	System.out.println(old);
	PSelec.setNomProjet(cellNom.getNewValue().toString() );
	// update the file:
	ArrayList<Projet>  L = new ArrayList<Projet>();
	 L = Projet.readFromFileP("Projet.txt");
	
	Iterator<Projet> it = L.iterator();
	
	while (it.hasNext())    {
		Projet P = it.next();
	 if (Objects.equals(P.getNomProjet(), old)) {
		 P.setNomProjet(PSelec.getNomProjet());
	    new FileOutputStream("Projet.txt").close();
	    for(Projet p : L)
	    	p.writeToFile("Projet.txt");      }
	}
	System.out.println(" Updated !"); }

	

	 @FXML
	 void changeDCND(CellEditEvent<Projet, Date> event) {

	 
	 }

	 
	 
	 
	 @FXML
	 void changeNbr(CellEditEvent<Projet, String> event) throws Exception {

		 Projet PSelec = Table.getSelectionModel().getSelectedItem(); 
			String old = PSelec.getNomProjet();	
			String old2=PSelec.getNbrLot();
			System.out.println(old2);
			PSelec.setNbrLot(event.getNewValue().toString() );
			
			if(isNumber(PSelec.getNbrLot())) 
			{
			// update the file:
			ArrayList<Projet>  L = new ArrayList<Projet>();
			 L = Projet.readFromFileP("Projet.txt");
			Iterator<Projet> it = L.iterator();
			while (it.hasNext())    {
				Projet P = it.next();
			 if (Objects.equals(P.getNomProjet(), old)) {
				 P.setNbrLot(PSelec.getNbrLot());
			    new FileOutputStream("Projet.txt").close();
			    for(Projet p : L)
			    	p.writeToFile("Projet.txt");      }
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
	
	
	//Suppression row
    @FXML
    void delSelC(ActionEvent event)  throws Exception {
        Projet cl = Table.getSelectionModel().getSelectedItem();
 	   System.out.println(cl.getNomProjet());
 	   Projet.supprimer(cl.getNomProjet());
	   Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem() );
	
    }
	
	
	//boutton AJOUTER
    @FXML
    void goAjoutProj(ActionEvent event) throws IOException {
    	Backhome.getScene().getWindow().hide();
    	Stage goadd = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/AddProjet.fxml"));
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
