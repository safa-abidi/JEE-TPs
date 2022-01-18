package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.GestUsers;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletSupprimer
 */
@WebServlet("/ServletSupprimer")
public class ServletSupprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSupprimer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		Utilisateur user = (Utilisateur) httpSession.getAttribute("user");
		if (user != null) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			GestUsers gest = new GestUsers();
			Utilisateur u = gest.Chercher(login, password);
			gest.supprimer(u);
			response.sendRedirect("ServletListe");
		} else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
