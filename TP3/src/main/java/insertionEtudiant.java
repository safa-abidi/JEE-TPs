

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.Etudiant;
import web.GestionEtudiants;

/**
 * Servlet implementation class insertionEtudiant
 */
@WebServlet("/insertionEtudiant")
public class insertionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertionEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom") ;
		String cin = request.getParameter("cin") ;
		Etudiant newEtudiant = new Etudiant(nom,cin);
		
		GestionEtudiants.addEtudiant(newEtudiant) ;
		Vector <Etudiant> allEtudiants = GestionEtudiants.getVect();
		
		request.setAttribute("listeEtudiants", allEtudiants);
		request.getRequestDispatcher("listeEtudiants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
