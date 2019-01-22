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

public class Projet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomProjet;
	private String TypeProjet;
	private String siteweb;
	private String AcceeHeber;
	private String acceeFTP;
	private String acceeCptAdmin;
	private String acceeAutres;
	private String Contact;
	private String DescrDetProjet;
	private String NbrLot;
	private String GestHeberWeb;
	private  LocalDate datecommande;
	public Projet(String nomProjet, String typeProjet, String siteweb, String acceeHeber, String acceeFTP,
			String acceeCptAdmin, String acceeAutres, String contact, String descrDetProjet, String nbrLot,
			String gestHeberWeb,   LocalDate datecommande) {
		super();
		this.nomProjet = nomProjet;
		TypeProjet = typeProjet;
		this.siteweb = siteweb;
		AcceeHeber = acceeHeber;
		this.acceeFTP = acceeFTP;
		this.acceeCptAdmin = acceeCptAdmin;
		this.acceeAutres = acceeAutres;
		Contact = contact;
		DescrDetProjet = descrDetProjet;
		NbrLot = nbrLot;
		GestHeberWeb = gestHeberWeb;
		this.datecommande = datecommande;
	}
	public Projet( ) {
		 
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getTypeProjet() {
		return TypeProjet;
	}
	public void setTypeProjet(String typeProjet) {
		TypeProjet = typeProjet;
	}
	public String getSiteweb() {
		return siteweb;
	}
	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}
	public String getAcceeHeber() {
		return AcceeHeber;
	}
	public void setAcceeHeber(String acceeHeber) {
		AcceeHeber = acceeHeber;
	}
	public String getAcceeFTP() {
		return acceeFTP;
	}
	public void setAcceeFTP(String acceeFTP) {
		this.acceeFTP = acceeFTP;
	}
	public String getAcceeCptAdmin() {
		return acceeCptAdmin;
	}
	public void setAcceeCptAdmin(String acceeCptAdmin) {
		this.acceeCptAdmin = acceeCptAdmin;
	}
	public String getAcceeAutres() {
		return acceeAutres;
	}
	public void setAcceeAutres(String acceeAutres) {
		this.acceeAutres = acceeAutres;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getDescrDetProjet() {
		return DescrDetProjet;
	}
	public void setDescrDetProjet(String descrDetProjet) {
		DescrDetProjet = descrDetProjet;
	}
	public String getNbrLot() {
		return NbrLot;
	}
	public void setNbrLot(String nbrLot) {
		NbrLot = nbrLot;
	}
	public String getGestHeberWeb() {
		return GestHeberWeb;
	}
	public void setGestHeberWeb(String gestHeberWeb) {
		GestHeberWeb = gestHeberWeb;
	}
	public LocalDate getDatecommande() {
		return datecommande;
	}
	public void setDatecommande(LocalDate localDate) {
		this.datecommande = localDate;
	}
	@Override
	public String toString() {
		return  nomProjet + "" + TypeProjet + "" + siteweb
				+ "" + AcceeHeber + "" + acceeFTP + "" + acceeCptAdmin
				+ " " + acceeAutres + " " + Contact + " " + DescrDetProjet
				+ " " + NbrLot + " " + GestHeberWeb + " " + datecommande + " ";
	}
	
	
/***********************************AJOUT D1 Projet DANS UN FICHIER*********************************************/	
	
	public static void saveProjet(String fileName, Projet P) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(P);
			oos.close();
		    System.out.println("Fin ajout !");

		} catch (IOException e) {
		    System.out.println("Fin ajout !");

			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/	
	    
		public static ArrayList<Projet> readFromFileP(String fileName) throws Exception {  
			ArrayList<Projet> recordList = new ArrayList<Projet> ();
			try {
			    FileInputStream streamIn = new FileInputStream("Projet.txt");
			    Projet readCase = new Projet();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (Projet) ois.readObject();
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
/***********************************SUPPRIMER UN Projet DU FICHIER*********************************************/

		public static void supprimer(String n) throws Exception {  
			ArrayList<Projet>  l = new ArrayList<Projet>();
			l = Projet.readFromFileP("Projet.txt");
			
			Iterator<Projet> it = l.iterator();
			System.out.println(n);
			while (it.hasNext()) {
				Projet cl = it.next();
				System.out.println(cl.getNomProjet());
			  if (Objects.equals(cl.getNomProjet(), n)) { 
			    it.remove();
			    new FileOutputStream("Projet.txt").close();
			    for(Projet clt : l)
			    	clt.writeToFile("Projet.txt");
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
		
			public static Boolean FindProjet(String fid, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Projet>  L = new ArrayList<Projet>();
				L = Projet.readFromFileP(filepath);
				Iterator<Projet> it = L.iterator();
				while (it.hasNext()) {
					Projet clt = it.next();
				 if ( Objects.equals(clt.getNomProjet(), fid) )
				      
				          { F=true; }
				   }
				
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
/********************************************************************************/
public void startEdit() {
	// TODO Auto-generated method stub
	
}

	
	

}
