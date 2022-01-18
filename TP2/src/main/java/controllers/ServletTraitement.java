package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletTraitement")
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTraitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sexe = request.getParameter("sexe");
		String fonction = request.getParameter("fonction");
		//String[] loisirs = request.getParameterValues("loisirs");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sex = "";
		String msg= "";
		
		if(sexe != null) {
		switch (sexe) {
		case "F" : sex = "madame";
		break;
		case "M" : sex = "mr";
		break;
		}
		}else {
			msg = "Vous n'avez pas specifier votre sexe";
		}
		
		String fn ="";
		
		switch (fonction) {
		case "etd" : 
			fn = "Etudiant";
			if (sexe == "F"){fn = "etudiante";}
		break;
		case "ing" : fn = "ingénieur";
		break;
		case "ens" : 
			fn = "Enseignant";
			if (sexe == "F") {fn = "Enseignante";}
		break;
		case "ret" : 
			fn = "retraité";
			if (sexe == "F") {fn = "retraitée";}
			
		break;
		case "autre" : fn = "autre";
		}
		
		out.println("<html><body> Bonjour "+ sex + " " + nom + " " + prenom+"<br>");
		out.println("\nVotre fonction est " + fn +"<br>");
		
		try {
			String[] loisirs = request.getParameterValues("loisirs");
			out.println("vos loisirs sont ");
			for (int i = 0 ; i< loisirs.length; i ++) {
				out.println(loisirs[i]+ ",");
			}
		}catch( Exception e){
			out.println("Vous n'avez pas de loisirs");
		}

		//for (int i = 0 ; i< loisirs.length; i ++) {
			//out.println("vos loisirs sont " + loisirs[i]);
	
		//}
		out.print(msg);
		out.print("</body></html>");
		
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
