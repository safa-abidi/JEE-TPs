<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un utilisateur</title>
</head>
<body>
	<FORM METHOD="GET" action="ServletAjouter">
		<P>Please fill the form</P>
		<P>
			login: <INPUT NAME="login" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
		</P>
		<P>
			password: <INPUT NAME="password" TYPE=" TEXT" SIZE=" 12"
				MAXLENGTH=" 20">
		</P>
		<P>
			email: <INPUT NAME="email" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
		</P>
		<P>
			ville: <INPUT NAME="ville" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
		</P>
		<INPUT TYPE="SUBMIT">
	</FORM>
</body>
</html>