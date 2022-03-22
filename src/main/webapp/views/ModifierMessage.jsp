<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier le message</title>
</head>
<body>
	<h1>Modification du message</h1>
	<form action="modifierMessage" method="post">
		<input type="hidden" name="id" value="${message.getId() }">
		Titre du message: <br><br><input type="text" name="titre"  /> <br><br>
		Contenu du message <br><br><textarea name="contenu" ></textarea>
		<input type="submit" />
	</form>
</body>
</html>