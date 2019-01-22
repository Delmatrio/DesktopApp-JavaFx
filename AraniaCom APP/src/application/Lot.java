package application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Lot implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomLot;
	private String TypeLot;
	private LocalDate dateajoutLot;
	private String DescrDetLot;
	private LocalDate datedebut;
	private String dureeEstimee;
	private String Prix;
	private LocalDate datefin;
	private LocalDate datepaiment;
	
	public Lot(String nomLot, String typeLot, LocalDate dateajoutLot, String descrDetLot, LocalDate datedebut,
			String dureeEstimee, String prix, LocalDate datefin, LocalDate datepaiment) {
		super();
		this.nomLot = nomLot;
		TypeLot = typeLot;
		this.dateajoutLot = dateajoutLot;
		DescrDetLot = descrDetLot;
		this.datedebut = datedebut;
		this.dureeEstimee = dureeEstimee;
		Prix = prix;
		this.datefin = datefin;
		this.datepaiment = datepaiment;
	}
	
	public Lot() {
		
	}

	public String getNomLot() {
		return nomLot;
	}

	public void setNomLot(String nomLot) {
		this.nomLot = nomLot;
	}

	public String getTypeLot() {
		return TypeLot;
	}

	public void setTypeLot(String typeLot) {
		TypeLot = typeLot;
	}

	

	public LocalDate getDateajoutLot() {
		return dateajoutLot;
	}

	public void setDateajoutLot(LocalDate dateajoutLot) {
		this.dateajoutLot = dateajoutLot;
	}

	public String getDescrDetLot() {
		return DescrDetLot;
	}

	public void setDescrDetLot(String descrDetLot) {
		DescrDetLot = descrDetLot;
	}

	public LocalDate getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}

	public String getDureeEstimee() {
		return dureeEstimee;
	}

	public void setDureeEstimee(String dureeEstimee) {
		this.dureeEstimee = dureeEstimee;
	}

	public String getPrix() {
		return Prix;
	}

	public void setPrix(String prix) {
		Prix = prix;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	public LocalDate getDatepaiment() {
		return datepaiment;
	}

	public void setDatepaiment(LocalDate datepaiment) {
		this.datepaiment = datepaiment;
	}

	@Override
	public String toString() {
		return  nomLot + " " + TypeLot  + " "+ dateajoutLot + " " + DescrDetLot + " " + datedebut + " "
				+ dureeEstimee + " " + Prix + " " + datefin + " " + datepaiment  + " " ;
	}
	
/***********************************AJOUT D1 LOT DANS UN FICHIER*********************************************/	
	
	public static void saveLot(String fileName, Lot l) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(l);
			oos.close();
		    System.out.println("Fin ajout !");

		} catch (IOException e) {
		    System.out.println("Fin ajout !");

			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/	
	    
		public static ArrayList<Lot> readFromFileL(String fileName) throws Exception {  
			ArrayList<Lot> recordList = new ArrayList<Lot> ();
			try {
			    FileInputStream streamIn = new FileInputStream("Lot.txt");
			    Lot readCase = new Lot();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (Lot) ois.readObject();
			        if(readCase != null){
			            recordList.add(readCase);
			        } 
			    } while (streamIn.available()>0);
			    streamIn.close();
			    return recordList;
			} catch (Exception e) {
			    e.printStackTrace();
			    return null;
			}
		}
/***********************************SUPPRIMER UN LOT DU FICHIER*********************************************/
		
		public static void supprimer(String n) throws Exception {  
			ArrayList<Lot>  l = new ArrayList<Lot>();
			l = Lot.readFromFileL("Lot.txt");
			
			Iterator<Lot> it = l.iterator();
			System.out.println(n);
			while (it.hasNext()) {
				Lot cl = it.next();
				System.out.println(cl.getNomLot());
			  if (Objects.equals(cl.getNomLot(), n)) { 
			    it.remove();
			    new FileOutputStream("Lot.txt").close();
			    for(Lot clt : l)
			    	clt.writeToFile("Lot.txt");
			  }
			}		
			System.out.println("Fin Suppression !");
		}
		
		
		public void writeToFile(String fileName) throws IOException {
			try {
				
				// write object to file
				FileOutputStream fos = new FileOutputStream(fileName,true);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(this);
				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
				} 
		}
		
/*************************************RECHERCHE par NOM*******************************************/
		
			public static Boolean FindLot(String fid, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Lot>  L = new ArrayList<Lot>();
				L = Lot.readFromFileL(filepath);
				Iterator<Lot> it = L.iterator();
				while (it.hasNext()) {
					Lot clt = it.next();
				 if ( Objects.equals(clt.getNomLot(), fid) )
				      
				          { F=true; }
				   }
				
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
/********************************************************************************/

	
	
	

}
