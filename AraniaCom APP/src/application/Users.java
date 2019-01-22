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

public class Users implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private String n;
	private String p;
	
	public Users() {
	}
	public Users(String n, String p) {
		super();
		this.n = n;
		this.p = p;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return  n + " " + p + " " ;
	}
	
	

/***********************************AJOUT D1 LOT DANS UN FICHIER*********************************************/	
	
	public static void saveUser(String fileName, Users U) throws IOException {
		try {
			
			// write object to file
			FileOutputStream fos = new FileOutputStream(fileName,true); //ECRIRE DANS UN FICHIER SANS ECRASER!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(U);
			oos.close();
		    System.out.println("Fin ajout !");

		} catch (IOException e) {
		    System.out.println("Fin ajout !");

			e.printStackTrace();
		  } 
	}
	
/*********************************LIRE LE CONTENU D'UN FICHIER DANS UN ARRAYLIST***********************************************/	
	    
		public static ArrayList<Users> readFromFileU(String fileName) throws Exception {  
			ArrayList<Users> recordList = new ArrayList<Users> ();
			try {
			    FileInputStream streamIn = new FileInputStream("Users.txt");
			    Users readCase = new Users();
			    do {
			    	ObjectInputStream ois = new ObjectInputStream(streamIn);
			        readCase = (Users) ois.readObject();
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
			ArrayList<Users>  l = new ArrayList<Users>();
			l = Users.readFromFileU("Users.txt");
			
			Iterator<Users> it = l.iterator();
			System.out.println(n);
			while (it.hasNext()) {
				Users cl = it.next();
				System.out.println(cl.getN());
			  if (Objects.equals(cl.getN(), n)) { 
			    it.remove();
			    new FileOutputStream("Users.txt").close();
			    for(Users clt : l)
			    	clt.writeToFile("Users.txt");
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
		
			public static Boolean FindUser(String N, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Users>  L = new ArrayList<Users>();
				L = Users.readFromFileU(filepath);
				Iterator<Users> it = L.iterator();
				while (it.hasNext()) {
					Users clt = it.next();
				 if ( Objects.equals(clt.getN(), N) )
				        F=true;  
				   }
				} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				
				return F;
			}
			
  public static Boolean VerifUser(String N,String P, String filepath) throws Exception  {
				
				boolean F=false;
				try { 
				ArrayList<Users>  L = new ArrayList<Users>();
				L = Users.readFromFileU(filepath);
				Iterator<Users> it = L.iterator();
				while (it.hasNext()) {
					Users clt = it.next();
				 if ( Objects.equals(clt.getN(), N) )
				    { if( Objects.equals(clt.getP(), P))
				        F=true;  }
				}} catch(Exception e) {}
		        System.out.println("Fin Recherche !");
				return F;
			}			
}
