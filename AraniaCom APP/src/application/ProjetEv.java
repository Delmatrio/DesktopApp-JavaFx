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

public class ProjetEv implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String idEv;
	private LocalDate dateajout;
	private String gerant; // du fichier client (client avec metier gerant) 
	private String entreprise; // du fichier des Entreprise
    private String T1;
    private String T2;
    private String M1;
    private String M2;
    private String adress;
    private String DDet;
    private String ETAT;
    private String Srcc;
    private String LinkWeb;
	public ProjetEv(String idev, LocalDate dateajout, String gerant, String entreprise, String t1, String t2, String m1, String m2,
			String adress, String dDet, String eTAT, String srcc, String linkWeb) {
		super();
		idEv=idev;
		this.dateajout = dateajout;
		this.gerant = gerant;
		this.entreprise = entreprise;
		T1 = t1;
		T2 = t2;
		M1 = m1;
		M2 = m2;
		this.adress = adress;
		DDet = dDet;
		ETAT = eTAT;
		Srcc = srcc;
		LinkWeb = linkWeb;
	}
	
	
	public String getIdEv() {
		return idEv;
	}


	public void setIdEv(String idEv) {
		this.idEv = idEv;
	}


	public ProjetEv() {
		super();
	}
	public LocalDate getDateajout() {
		return dateajout;
	}
	public void setDateajout(LocalDate dateajout) {
		this.dateajout = dateajout;
	}
	public String getGerant() {
		return gerant;
	}
	public void setGerant(String gerant) {
		this.gerant = gerant;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public String getT1() {
		return T1;
	}
	public void setT1(String t1) {
		T1 = t1;
	}
	public String getT2() {
		return T2;
	}
	public void setT2(String t2) {
		T2 = t2;
	}
	public String getM1() {
		return M1;
	}
	public void setM1(String m1) {
		M1 = m1;
	}
	public String getM2() {
		return M2;
	}
	public void setM2(String m2) {
		M2 = m2;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDDet() {
		return DDet;
	}
	public void setDDet(String dDet) {
		DDet = dDet;
	}
	public String getETAT() {
		return ETAT;
	}
	public void setETAT(String eTAT) {
		ETAT = eTAT;
	}
	public String getSrcc() {
		return Srcc;
	}
	public void setSrcc(String srcc) {
		Srcc = srcc;
	}
	public String getLinkWeb() {
		return LinkWeb;
	}
	public void setLinkWeb(String linkWeb) {
		LinkWeb = linkWeb;
	}
	@Override
	public String toString() {
		return idEv+ " " + dateajout + " " + gerant + " " + entreprise + " " + T1
				+ " " + T2 + " " + M1 + " " + M2 + " " + adress + " " + DDet + " "
				+ ETAT + " " + Srcc + " " + LinkWeb + " ";
	}
    
/***********************************AJOUT D1 ENTREPRISE DANS UN FICHIER*********************************************/	
	
	public static void saveProjetEv(String fileName, ProjetEv E) throws IOException {
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
	    
		public static ArrayList<ProjetEv> readFromFilePE(String fileName) throws Exception {  
			ArrayList<ProjetEv> recordList = new ArrayList<ProjetEv> ();
			try {
			    FileInputStream streamIn = new FileInputStream("ProjetEv.txt");
			    ProjetEv readCase = new ProjetEv();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (ProjetEv) ois.readObject();
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
			ArrayList<ProjetEv>  l = new ArrayList<ProjetEv>();
			l = ProjetEv.readFromFilePE("ProjetEv.txt");
			
			Iterator<ProjetEv> it = l.iterator();
			System.out.println(n);
			while (it.hasNext()) {
				ProjetEv cl = it.next();
				System.out.println(cl.getIdEv());
			  if (Objects.equals(cl.getIdEv(), n)) { 
			    it.remove();
			    new FileOutputStream("ProjetEv.txt").close();
			    for(ProjetEv clt : l)
			    	clt.writeToFile("ProjetEv.txt");
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
		
			
			public static Boolean FindProjetEv(String fid, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<ProjetEv>  L = new ArrayList<ProjetEv>();
				L = ProjetEv.readFromFilePE(filepath);
				Iterator<ProjetEv> it = L.iterator();
				while (it.hasNext()) {
					ProjetEv clt = it.next();
				 if ( Objects.equals(clt.getIdEv(), fid) )
				      
				          { F=true; }
				   }
				
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
/********************************************************************************/

}
