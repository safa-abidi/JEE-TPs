<%@page import="metier.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>
	<h2>Bienvenue</h2>
	<%
	Utilisateur user = (Utilisateur) (session.getAttribute("user"));
	%>
	<%=user.getIdUser()%>
	<br>
	<%=user.getLogin()%>
	<br>
	<%=user.getEmail()%>
	<br>
	<%=user.getPass()%>
	<br>
	<%=user.getVille()%> <br>

	<a href="ajout.jsp">Ajouter un nouveau utilisateur</a><br>
	<a href="ServletListe">Liste des utilisateurs</a>
</body>
</html>