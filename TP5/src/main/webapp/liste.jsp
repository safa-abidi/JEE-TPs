<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Vector"%>
<%@page import="metier.Utilisateur"%>
<%@page import="metier.GestUsers"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
</head>
<body>
	<%
	Vector<Utilisateur> users = (Vector<Utilisateur>) (session.getAttribute("users"));
	%>
	<%
	for (Utilisateur u : users) {
	%>
	<%=u.getLogin()%>
	/
	<%=u.getEmail()%>
	/
	<%=u.getVille()%>
	<form method="GET" action="ServletSupprimer">
		<input type="hidden" value=<%=u.getLogin()%> name="login"> <input
			type="hidden" value=<%=u.getPass()%> name="password"> <input
			type="submit" value="Supprimer">
	</form>
	
	<form method="GET" action="ServletModifier">
		<input type="hidden" name="id" value=<%=u.getIdUser()%>>
		<input	type="submit" value="modifier">
	</form>
	<%
	}
	%>
</body>
</html>