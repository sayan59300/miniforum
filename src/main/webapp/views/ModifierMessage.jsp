<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Modifier le message</title>
</head>
<body>
	<h1>Modification du message</h1>
	<form action="modifierMessage" method="post">
		<input type="hidden" name="id" value="${message.getId() }">
		Titre du message: <br><br><input type="text" name="titre"  /> <br><br>
		Contenu du message <br><br><textarea name="contenu" ></textarea><br><br>
		<table>
		<td  class="noneBorder"><a href="listeMessage" name><button>Liste des messages</button></a></td>
		<td  class="noneBorder"><input type="submit" /></td>
			
		</table>
	</form>
</body>
</html>