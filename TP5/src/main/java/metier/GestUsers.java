package metier;

import dao.GestUsersDAO;
import java.util.Vector;

public class GestUsers {
	GestUsersDAO dao;

	public GestUsers() {
		dao = new GestUsersDAO();
	}

	public Utilisateur Chercher(String login, String pass) {
		return dao.loadUser(login, pass);
	}

	public void ajouter(Utilisateur u) {
		dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}

	public Vector lister() {
		return dao.selectAll();
	}
	
	public void supprimer(Utilisateur u) {
		dao.deleteUser(u.getLogin());
	}
	
	public void modifier(int id, Utilisateur u) {
		dao.UpdateUser(id, u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}
	
}