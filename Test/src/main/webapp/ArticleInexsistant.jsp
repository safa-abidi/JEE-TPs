<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article non trouve</title>
</head>
<body>
	<h1>Resultat de la recherche</h1>
	<h2>cher client votre article 
	<%= request.getAttribute("nom") %>
	( <%= request.getAttribute("code") %> )
	
	n'exite pas</h2>
</body>
</html>