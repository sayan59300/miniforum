<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des messages</title>
</head>
<body>
	<table>
		<c:forEach items="${messages }" var="messages">
			<tr>Date: ${ messages.getDate()}</tr><br>
			<tr>Titre: ${ messages.getTitre()}  </tr>	<br>
			<tr>Contenus: ${ messages.getContenu()} </tr><br>	
			<tr>
			<form action="voirMessage" method="post">
				<button name="id" value="${ messages.getId()}">Voir le message</button>
			</form>
			</tr><br><br>		
		
			
		</c:forEach>
	</table>
</body>
</html>