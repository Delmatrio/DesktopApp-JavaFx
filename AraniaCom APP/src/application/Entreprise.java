package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Entreprise implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomEntr;
	private String Categorie;
	private String adresseEntr;
	private String Tel1Entr;
	private String Tel2Entr;
	private String Mail1Entr;
	private String Mail2Entr;
	private String DescrDetEntr;
	
	public Entreprise(String nomEntr, String categorie, String adresseEntr, String tel1Entr, String tel2Entr,
			String mail1Entr, String mail2Entr, String descrDetEntr) {
		super();
		this.nomEntr = nomEntr;
		Categorie = categorie;
		this.adresseEntr = adresseEntr;
		Tel1Entr = tel1Entr;
		Tel2Entr = tel2Entr;
		Mail1Entr = mail1Entr;
		Mail2Entr = mail2Entr;
		DescrDetEntr = descrDetEntr;
	}
	public Entreprise() {
		
		//this.nomEntr=this.Categorie=this.adresseEntr=this.Tel1Entr=this.Tel2Entr=this.Mail1Entr=this.Mail2Entr=this.DescrDetEntr="";
	
	}
	public String getNomEntr() {
		return nomEntr;
	}
	public void setNomEntr(String nomEntr) {
		this.nomEntr = nomEntr;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public String getAdresseEntr() {
		return adresseEntr;
	}
	public void setAdresseEntr(String adresseEntr) {
		this.adresseEntr = adresseEntr;
	}
	public String getTel1Entr() {
		return Tel1Entr;
	}
	public void setTel1Entr(String tel1Entr) {
		Tel1Entr = tel1Entr;
	}
	public String getTel2Entr() {
		return Tel2Entr;
	}
	public void setTel2Entr(String tel2Entr) {
		Tel2Entr = tel2Entr;
	}
	public String getMail1Entr() {
		return Mail1Entr;
	}
	public void setMail1Entr(String mail1Entr) {
		Mail1Entr = mail1Entr;
	}
	public String getMail2Entr() {
		return Mail2Entr;
	}
	public void setMail2Entr(String mail2Entr) {
		Mail2Entr = mail2Entr;
	}
	public String getDescrDetEntr() {
		return DescrDetEntr;
	}
	public void setDescrDetEntr(String descrDetEntr) {
		DescrDetEntr = descrDetEntr;
	}
	@Override
	public String toString() {
		/*	return "Entreprise [nomEntr=" + nomEntr + ", Categorie=" + Categorie + ", adresseEntr=" + adresseEntr
				+ ", Tel1Entr=" + Tel1Entr + ", Tel2Entr=" + Tel2Entr + ", Mail1Entr=" + Mail1Entr + ", Mail2Entr="
				+ Mail2Entr + ", DescrDetEntr=" + DescrDetEntr + "]"; */
			
		return nomEntr + " "  + Categorie + " " + adresseEntr + " "  + Tel1Entr + " "  + Tel2Entr + " "  + Mail1Entr + " "  + Mail2Entr + " "  + DescrDetEntr + " "  ;
	}
	
/***********************************AJOUT D1 ENTREPRISE DANS UN FICHIER*********************************************/	
	
	public static void saveEntreprise(String fileName, Entreprise E) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(E);
			oos.close();
		    System.out.println("Fin ajout !");

		} catch (IOException e) {
		    System.out.println("Fin ajout !");

			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/	
	    
		public static ArrayList<Entreprise> readFromFile(String fileName) throws Exception {  
			ArrayList<Entreprise> recordList = new ArrayList<Entreprise> ();
			try {
			    FileInputStream streamIn = new FileInputStream("Entreprise.txt");
			    Entreprise readCase = new Entreprise();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (Entreprise) ois.readObject();
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
/***********************************SUPPRIMER UN ENTREPRISE DU FICHIER*********************************************/
	
		public static void supprimer(String n) throws Exception {  
			ArrayList<Entreprise>  l = new ArrayList<Entreprise>();
			l = Entreprise.readFromFile("Entreprise.txt");
			
			Iterator<Entreprise> it = l.iterator();
			System.out.println(n);
			while (it.hasNext()) {
				Entreprise cl = it.next();
				System.out.println(cl.getNomEntr());
			  if (Objects.equals(cl.getNomEntr(), n)) { 
			    it.remove();
			    new FileOutputStream("Entreprise.txt").close();
			    for(Entreprise clt : l)
			    	clt.writeToFile("Entreprise.txt");
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
		
			public static Boolean FindEntreprise(String fid, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Entreprise>  L = new ArrayList<Entreprise>();
				L = Entreprise.readFromFile(filepath);
				Iterator<Entreprise> it = L.iterator();
				while (it.hasNext()) {
					Entreprise clt = it.next();
				 if ( Objects.equals(clt.getNomEntr(), fid) )
				      
				          { F=true; }
				   }
				
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
/********************************************************************************/

}
