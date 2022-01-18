package web;

import java.io.IOException;
import java.util.Vector;

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
 * Servlet implementation class ServletListe
 */
@WebServlet("/ServletListe")
public class ServletListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
				
		if(maSession == null) {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			try {
				Utilisateur user = (Utilisateur) maSession.getAttribute("user");
				System.out.println(user);
				GestUsers gest = new GestUsers();
				Vector users = gest.lister();
				maSession.setAttribute("users", users);
				System.out.println(users);
				this.getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);				
			}catch(Exception e) {
				e.getStackTrace();
				
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
