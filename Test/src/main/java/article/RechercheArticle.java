package article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Article;
import metier.GestionArticleMetier;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RechercheArticle() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		
		GestionArticleMetier gest = new GestionArticleMetier();
		Article a = gest.Chercher(code, nom);
		System.out.println(a);
		if(a != null) {
			request.setAttribute("article", a);
			Cookie cookie = new Cookie("cookie", "existe");
			response.addCookie(cookie);
			getServletContext().getRequestDispatcher("/ListeArticleTrouver.jsp").forward(request, response);
		}else {
			request.setAttribute("code", code);
			request.setAttribute("nom", nom);
			getServletContext().getRequestDispatcher("/ArticleInexsistant.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
