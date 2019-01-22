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

public class Facture implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idf;
	private LocalDate DateFact;
	private String MntFactHT;
	private String MntTVA;
	private String MntFactTTC;
	private String  TVAPayee;
	private String  idVerCl;
	private String idcl;
	private String iden;
	
	public String getIdcl() {
		return idcl;
	}

	public void setIdcl(String idcl) {
		this.idcl = idcl;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public Facture(String idf, LocalDate dateFact, String mntFactHT, String mntTVA, String mntFactTTC, String tVAPayee,String idcl,String iden) {
		super();
		this.idf = idf;
		DateFact = dateFact;
		MntFactHT = mntFactHT;
		MntTVA = mntTVA;
		MntFactTTC = mntFactTTC;
		TVAPayee = tVAPayee;
		this.iden=iden;
		this.idcl=idcl;
	}
	
	public Facture() {}
	
	public String getIdf() {
		return idf;
	}
	public void setIdf(String idf) {
		this.idf = idf;
	}
	public LocalDate getDateFact() {
		return DateFact;
	}
	public void setDateFact(LocalDate localDate) {
		DateFact = localDate;
	}
	public String getMntFactHT() {
		return MntFactHT;
	}
	public void setMntFactHT(String mntFactHT) {
		MntFactHT = mntFactHT;
	}
	public String getMntTVA() {
		return MntTVA;
	}
	public void setMntTVA(String mntTVA) {
		MntTVA = mntTVA;
	}
	public String getMntFactTTC() {
		return MntFactTTC;
	}
	public void setMntFactTTC(String mntFactTTC) {
		MntFactTTC = mntFactTTC;
	}
	public String getTVAPayee() {
		return TVAPayee;
	}
	public void setTVAPayee(String tVAPayee) {
		TVAPayee = tVAPayee;
	}
	public String getIdVerCl() {
		return idVerCl;
	}
	public void setIdVerCl(String dd) {
		idVerCl = dd;
	}
	@Override
	public String toString() {
		/*return "Facture [idf=" + idf + ", DateFact=" + DateFact + ", MntFactHT=" + MntFactHT + ", MntTVA=" + MntTVA
				+ ", MntFactTTC=" + MntFactTTC + ", TVAPayee=" + TVAPayee + "]";
		*/
		
		return idf + " " + DateFact + " " + MntFactHT + " " + MntTVA + " " + MntFactTTC + " " + TVAPayee + " " + idcl + " " + iden + " " ;
	}
	
	
/***********************************AJOUT D1 FACTURE DANS UN FICHIER*********************************************/	
	
	public static void saveFacture(String fileName, Facture F) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(F);
			oos.close();
		    System.out.println("Fin ajout !");

		} catch (IOException e) {
		    System.out.println("Fin ajout !");

			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/	
	    
		public static ArrayList<Facture> readFromFileF(String fileName) throws Exception {  
			ArrayList<Facture> recordList = new ArrayList<Facture> ();
			try {
			    FileInputStream streamIn = new FileInputStream("Facture.txt");
			    Facture readCase = new Facture();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (Facture) ois.readObject();
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
	
		public static void supprimer(String idf) throws Exception {  
			ArrayList<Facture>  l = new ArrayList<Facture>();
			l = Facture.readFromFileF("Facture.txt");
			
			Iterator<Facture> it = l.iterator();
			Integer x = Integer.valueOf(idf);
			System.out.println(x);
			while (it.hasNext()) {
				Facture cl = it.next();
				System.out.println(cl.getIdf());
			  if (Integer.valueOf(cl.getIdf())==x) {
			    it.remove();
			    new FileOutputStream("Facture.txt").close();
			    for(Facture clt : l)
			    	clt.writeToFile("Facture.txt");
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
		
			public static Boolean FindFacture(String fid, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Facture>  L = new ArrayList<Facture>();
				L = Facture.readFromFileF(filepath);
				Iterator<Facture> it = L.iterator();
				while (it.hasNext()) {
					Facture clt = it.next();
				 if ( Objects.equals(clt.getIdf(), fid) )
				      
				          { F=true; }
				   }
				
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
/********************************************************************************/


}
