<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<P>Please fill out this form with your name. Thanks!</P>
	<FORM METHOD="GET" action="ServletLogin">
		<P>Please enter your login and password:</P>
		<P>
			login: <INPUT NAME="login" TYPE=" TEXT" SIZE=" 12" MAXLENGTH=" 20">
		</P>
		<P>
			password: <INPUT NAME="password" TYPE=" TEXT" SIZE=" 12"
				MAXLENGTH=" 20">
		</P>
		<P>Thank you!</P>
		<INPUT TYPE="SUBMIT">
	</FORM>
	<h2><% String msg = (String)request.getAttribute("msg"); %></h2>
</body>
</html>