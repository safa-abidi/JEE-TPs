<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="metier.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Article Trouver</title>
</head>
<body>
	<h1>Resultat de la recherche</h1>
	<h2>les informations sur l'article recherché</h2>
	<% Article a = (Article)request.getAttribute("article"); %>
	<table border=2>
	<tr>
		<td>code</td>
		<td>nom</td>
		<td>description</td>
		<td>quantite</td>
		<td>prix</td>
	</tr>
	<tr>
	<td><%= a.getCode() %></td>
	<td><%= a.getNom() %></td>
	<td><%= a.getDescription() %></td>
	<td><%= a.getQuantite()%></td>
	<td><%= a.getPrix() %>£</td>
	</tr>
	</table>
</body>
</html>