package dao;
import java.sql.*;
import java.util.Vector;

import metier.Article;


public class GestionArticle {
	
		public Article loadArticle(String code, String nom) {
			Connection conn = Utilitaire.getConnection();
			Article a = null;
			try {
				PreparedStatement ps = conn.prepareStatement("select * from articles where code=? and nom=?");
				ps.setString(1, code);
				ps.setString(2, nom);
				ResultSet rsArticle = ps.executeQuery();
				if (rsArticle.next()) {
					a = new Article();
					a.setCode(new String(rsArticle.getString("code")));
					a.setNom(rsArticle.getString("nom"));
					a.setDescription(rsArticle.getString("description"));
					a.setQuantite(rsArticle.getFloat("quantite"));
					a.setPrix(rsArticle.getFloat("prix"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return a;
		}

		public void addArticle(String c, String n, String d, float q, float p) {
			Connection conn = Utilitaire.getConnection();
			Article a = null;
			try {
				PreparedStatement ps = conn
						.prepareStatement("insert into articles (code,nom,description,quantite,prix) values(?,?,?,?,?)");
				ps.setString(1, c);
				ps.setString(2, n);
				ps.setString(3, d);
				ps.setFloat(4, q);
				ps.setFloat(5, p);
				ps.executeUpdate();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		public Vector selectAll() {
			Connection conn = Utilitaire.getConnection();
			Vector articles = new Vector();
			Article a = null;
			try {
				PreparedStatement ps = conn.prepareStatement("select * from articles");
				ResultSet rsArticle = ps.executeQuery();
				while (rsArticle.next()) {
					a = new Article();
					a.setCode(new String(rsArticle.getString("code")));
					a.setNom(rsArticle.getString("nom"));
					a.setDescription(rsArticle.getString("description"));
					a.setQuantite(rsArticle.getFloat("quantite"));
					a.setPrix(rsArticle.getFloat("prix"));
					articles.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return articles;
		}

		public void deleteArticle(String code) {
			Connection conn = Utilitaire.getConnection();
				try {
				PreparedStatement ps = conn.prepareStatement("delete from articles where code=?");
				ps.setString(1, code);
				int rsArticle = ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void UpdateArticle(String code, String nom, String description, float quantite, float prix) {
			Connection conn = Utilitaire.getConnection();
			try {
				PreparedStatement ps = conn
						.prepareStatement("Update articles set nom=?,description=?,quantite=?,prix=? where code=?");
				ps.setString(1, nom);
				ps.setString(2, description);
				ps.setFloat(3, quantite);
				ps.setFloat(4, prix);
				ps.setString(5, code);
				int rsArticle = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}


