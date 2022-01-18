<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.util.Vector" %>
    <%@page import= "web.Etudiant " %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Vector<Etudiant> allEtudiants =(Vector <Etudiant>) request.getAttribute("listeEtudiants");
for( int i=0 ; i<allEtudiants.size() ; i++){

out.println((allEtudiants.elementAt(i)).getNom());
out.println((allEtudiants.elementAt(i)).getCin());

%>
 <a href= <%=new String("SupprimerEtudiant?cin="+(allEtudiants.elementAt(i)).getCin())%>

 > supprimer </a>
<br/>
<%
}
%>



</body>
</html>