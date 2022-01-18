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
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifier")
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(false);
		if (maSession == null) {
			response.sendRedirect("Login.jsp");
		} else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if (user != null) {
				request.setAttribute("id", request.getParameter("id"));
				getServletContext().getRequestDispatcher("/modifier.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(false);
		if (maSession == null) {
			response.sendRedirect("Login.jsp");
		} else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if (user != null) {
				GestUsers gest = new GestUsers();
				Utilisateur u = new Utilisateur();

				String email = request.getParameter("email");
				u.setEmail(email);
				
				String login = request.getParameter("login");
				u.setLogin(login);
				
				String pass = request.getParameter("password");
				u.setPass(pass);
				
				String ville = (String) request.getParameter("ville");
				u.setVille(ville);
				
				gest.modifier(Integer.parseInt(request.getParameter("id")), u);
				response.sendRedirect("ServletListe");
			}
		}
	}

}
