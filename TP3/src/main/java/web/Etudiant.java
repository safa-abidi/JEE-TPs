package web;

public class Etudiant {

	private String nom = null ;
	private String cin = null ;
	public Etudiant(String nom , String cin) {
		this.setCin(cin);
		this.setNom(nom);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
}
