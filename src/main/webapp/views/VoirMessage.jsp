<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Voir message</title>
</head>
<body>
<table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Titre</th>
				<th>Contenus</th>	
				<th>Action</th>			
			</tr>
		</thead>
		<tbody>		
			<td>${ message.getDate()}</td>
			<td>${ message.getTitre()} </td>
			<td>${ message.getContenu()} </td>	
			<td>
				<form  action="modifierMessage" method="get">
					<input type="hidden" name="id" value="${message.getId() }" >		
					<input type="submit" value="Modifier le message"/>
				</form>
				<form  action="supprimerMessage" method="post">
					<input type="hidden" name ="id" value="${message.getId() }" >
					<input type="submit" value="Supprimer le message"/>
				</form>
			</td>	
								
		</tbody>
		<tfoot>
   		 	<tr>
      				<td colspan="4"  class="noneBorder"><br><a href="listeMessage" name><button>Liste des messages</button></a></td>      
    		</tr>
  		</tfoot>			
</body>
</html>