<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tableau dynamique</title>
</head>
<body>
<%
int ligne = Integer.parseInt(request.getParameter("ligne"));
int colonne = Integer.parseInt(request.getParameter("colonne"));
%>
<table>

<%
for (int i=0 ; i< ligne ; i++) 
{
%>
<tr> 
<%
for (int j=0 ; j< colonne ; j++) 
{
%>
<th> 
<%= new String(i +"," +j)%>
</th>
<% 
}
%>
</tr>
<% 
}
%>	

</table>


</body>
</html>