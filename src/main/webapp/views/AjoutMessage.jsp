<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Ajout message</title>
</head>
<body>
<h1>Nouveau message</h1>
	<form action="ajoutMessage" method="post">
		Titre du message: <br><br><input type="text" name="titre"  /> <br><br>
		Contenu du message <br><br><textarea name="contenu" ></textarea>
		<input type="submit" />
	</form>
</body>
</html>