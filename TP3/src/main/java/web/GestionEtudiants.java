package web;

import java.util.Vector;

public class GestionEtudiants {

	private static Vector <Etudiant> vect = new Vector<Etudiant>();

	public static Vector<Etudiant> getVect() {
		return vect;
	}

	public static void setVect(Vector<Etudiant> vect) {
		GestionEtudiants.vect = vect;
	}
	
	public static void addEtudiant(Etudiant e) {
		GestionEtudiants.vect.add(e) ;
	}
	public static void supprimerEtudiant(String cin) {
		for(int i =0 ; i< vect.size() ; i++) {
			if((vect.elementAt(i)).getCin().equals(cin)) {
				vect.remove(i);
				break;
			}
		}
	}
}
