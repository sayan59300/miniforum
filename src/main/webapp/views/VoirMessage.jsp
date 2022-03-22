<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voir message</title>
</head>
<body>
	Date: ${ message.getDate()} <br>
	Titre: ${ message.getTitre()} <br>
	Contenus: ${ message.getContenu()} <br><br>
	<form  action="modifierMessage" method="get">
		<input type="hidden" name="id" value="${message.getId() }" >		
		<input type="submit" value="Modifier le message"/>
	</form><br><br>
	<form  action="supprimerMessage" method="post">
		<input type="hidden" name ="id" value="${message.getId() }" >
		<input type="submit" value="Supprimer le message"/>
	</form>
</body>
</html>