<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier</title>
</head>
<body>
	<FORM METHOD="POST" action="ServletModifier">
		<P>
			Please enter your new information: 
			<input type="hidden" name="id"	value=<%=request.getAttribute("id")%>>
		<P>
			Login: <INPUT name="login" TYPE="TEXT" SIZE="12" MAXLENGTH=" 20">
		<P>
			Password: <INPUT name="password" TYPE="TEXT" SIZE="12"
				MAXLENGTH=" 20">
		<P>
		<P>
			Email: <INPUT name="email" TYPE="TEXT" SIZE="12" MAXLENGTH=" 20">
		<P>
		<P>
			Ville: <INPUT name="ville" TYPE="TEXT" SIZE="12" MAXLENGTH=" 20">
		<P>
			Thank you! <INPUT TYPE="SUBMIT">
	</FORM>
</body>
</html>