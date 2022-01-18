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
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		String msgErreur="";
		if (login!= null && password != null && !login.equals("") && !password.equals("")) {
			GestUsers gestionUtilisateur = new GestUsers();
			Utilisateur user = gestionUtilisateur.Chercher(login, password);
			if (user != null) {
				HttpSession maSession = request.getSession(true);
				maSession.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
			}else {
				msgErreur = "Vous n etes pas authentifier";
				request.setAttribute(msgErreur, "msg");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else {
			msgErreur = "Login et password vides";
			request.setAttribute(msgErreur, "msg");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
