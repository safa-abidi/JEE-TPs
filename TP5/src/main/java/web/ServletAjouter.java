package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestUsersDAO;
import metier.GestUsers;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletAjouter
 */
@WebServlet("/ServletAjouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
		if(maSession == null) {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);;
		}else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if(user != null) {
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String ville = request.getParameter("ville");
			
				GestUsersDAO gest = new GestUsersDAO();
				gest.addUser(login, password, email, ville);
				response.sendRedirect("ServletListe");
			}
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
