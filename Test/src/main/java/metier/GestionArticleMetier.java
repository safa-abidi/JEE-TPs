package metier;

import dao.GestionArticle;
import java.util.Vector;

public class GestionArticleMetier {
	GestionArticle dao;

	public GestionArticleMetier() {
		dao = new GestionArticle();
	}

	public Article Chercher(String code, String nom) {
		return dao.loadArticle(code, nom);
	}

	public void ajouter(Article a) {
		dao.addArticle(a.getCode(), a.getNom(), a.getDescription(), a.getQuantite(), a.getPrix());
	}

	public Vector lister() {
		return dao.selectAll();
	}

	public void supprimer(Article a) {
		dao.deleteArticle(a.getCode());
	}

	public void modifier(String code, Article a) {
		dao.UpdateArticle(code, a.getNom(), a.getDescription(), a.getQuantite(), a.getPrix());
	}

}
