<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Liste des messages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Titre</th>
				<th>Contenus</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<c:forEach items="${messages }" var="messages">
		<tbody>		
			<td>${ messages.getDate()}</td>
			<td>${ messages.getTitre()} </td>
			<td>${ messages.getContenu()} </td>	
			
			<td>
				<form action="voirMessage" method="post">
					<button name="id" value="${ messages.getId()}">Voir le message</button>
				</form>
			</td>				
		</tbody>	
		</c:forEach>
		
	</table><br>
	<a href="ajoutMessage" name><button>Ajouter un message</button></a>
</body>
</html>