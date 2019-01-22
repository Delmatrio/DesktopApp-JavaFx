package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Client implements Serializable {
	  
	private static final long serialVersionUID = 1L;
	private String idC;
	private String nom;
	private String prenom;
	private String Tel1;
	private String Tel2;
	private String Mail1;
	private String Mail2;
	private String Metier;
	private String Desautre;
	private String Adresse;
	private String DescrDet;
	private String Source;
	
    public Client() {
    /*	this.idC="";
    	this.nom="";
    	this.prenom="";
    	this.Tel1=this.Tel2=this.Mail1=this.Mail2=this.Metier=this.Adresse=this.DescrDet=this.Source="";
    */
    } 
	public Client(String idC, String nom, String prenom, String tel1, String tel2, String mail1, String mail2, String metier, String desautre, 
			String adresse, String descrDet, String source) {
		super();
		this.idC = idC;
		this.nom = nom;
		this.prenom = prenom;
		Tel1 = tel1;
		Tel2 = tel2;
		Mail1 = mail1;
		Mail2 = mail2;
		Metier = metier;
		Adresse = adresse;
		DescrDet = descrDet;
		Source = source;
		Desautre=desautre;
	}
	public String getIdC() {
		return idC;
	}
	public void setIdC(String idC) {
		this.idC = idC;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getTel1() {
		return Tel1;
	}
	public void setTel1(String tel1) {
		Tel1 = tel1;
	}
	public String getTel2() {
		return Tel2;
	}
	public void setTel2(String tel2) {
		Tel2 = tel2;
	}
	public String getMail1() {
		return Mail1;
	}
	public void setMail1(String mail1) {
		Mail1 = mail1;
	}
	public String getMail2() {
		return Mail2;
	}
	public void setMail2(String mail2) {
		Mail2 = mail2;
	}
	public String getMetier() {
		return Metier;
	}
	public void setMetier(String metier) {
		Metier = metier;
	}
	
	public String getDesautre() {
		return Desautre;
	}
	public void setDesautre(String desautre) {
		Desautre = desautre;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getDescrDet() {
		return DescrDet;
	}
	public void setDescrDet(String descrDet) {
		DescrDet = descrDet;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	@Override
	public String toString() {
		/*return "Client [idC=" + idC + ", nom=" + nom + ", prenom=" + prenom + ", Tel1=" + Tel1 + ", Tel2=" + Tel2
				+ ", Mail1=" + Mail1 + ", Mail2=" + Mail2 + ", Metier=" + Metier + ", Adresse=" + Adresse
				+ ", DescrDet=" + DescrDet + ", Source=" + Source + "]";*/
		
		return idC + " " + nom + " " + prenom + " " + Tel1 + " " + Tel2 + " " + Mail1 + " " + Mail2 + " " + Metier + " " + Desautre + " " + Adresse + " " + DescrDet + " " + Source;
	}
	

/***********************************AJOUT D1 CLIENT DANS UN FICHIER*********************************************/	
	
	public static void saveClient(String fileName, Client clt) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clt);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/
	public static ArrayList<Client> readFromFile(String fileName) throws Exception {  
		ArrayList<Client> recordList = new ArrayList<Client> ();
		try {
		    FileInputStream streamIn = new FileInputStream("Client.txt");
		    Client readCase = new Client();
		    do {
		    	ObjectInputStream ois = new ObjectInputStream(streamIn);
		        readCase = (Client) ois.readObject();
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
/********************************************************************************/	
/*
	//CONSULTER LE CONTENU D'UN FICHIER
	public static void consulter() throws Exception {   
		ArrayList<Client> l = new ArrayList<Client>(); 
		l = Client.readFromFile("Client.txt");
		for(Client cl : l)
			System.out.println(cl.toString());
	}
	
*/
/********************************SUPPRIMER UN CLIENT DU FICHIER************************************************/
	/*
	 public static void supprimer(String idC) throws Exception {  
		ArrayList<Client>  L = new ArrayList<Client>();
		L = Client.readFromFile("Client.txt");
		Iterator<Client> it = L.iterator();
		
		while (it.hasNext()) {
		  Client clt = it.next();
		  if ((clt.getIdC())==idC) {
		    it.remove();
		  }
		}		
		new FileOutputStream("Client.txt").close();
	        for(Client cl : L)
			Client.saveClient("Client.txt",cl);
		System.out.println("Fin Suppression !"); */

/************************************RECHERCHE PAR ID********************************************/
	
		public static Boolean FindClient(String fid, String filepath) throws Exception  {
			
			boolean F=false;
			try { 
			ArrayList<Client>  L = new ArrayList<Client>();
			L = Client.readFromFile(filepath);
			Iterator<Client> it = L.iterator();
			while (it.hasNext()) {
			 Client clt = it.next();
			 if ( Objects.equals(clt.getIdC(), fid) )
			      
			          { F=true; }
			   }
			
			} catch(Exception e) {}
	        System.out.println("Fin Recherche !");
			
			return F;
		}
/********************************************************************************/
		public static boolean EmptyF(String filepath)
		{ 
		File f=new File(filepath);
		if (f.length() == 0)
		return true;
		else return false;}
		
		/*************************************/
		
		public static void supprimer(String idC) throws Exception {  
			ArrayList<Client>  l = new ArrayList<Client>();
			l = Client.readFromFile("Client.txt");
			
			Iterator<Client> it = l.iterator();
			Integer x = Integer.valueOf(idC);
			System.out.println(x);
			while (it.hasNext()) {
				Client cl = it.next();
				System.out.println(cl.getIdC());
			  if (Integer.valueOf(cl.getIdC())==x) {
			    it.remove();
			    new FileOutputStream("Client.txt").close();
			    for(Client clt : l)
			    	clt.writeToFile("Client.txt");
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
		
		
		
	
	
}
