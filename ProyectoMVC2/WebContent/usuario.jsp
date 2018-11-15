<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<h1>Datos de Usuario</h1>
	<ul>
		<li>ID:${elUsuario.id}</li>
		<li>Nombre:${elUsuario.name}</li>
		<li>Email:${elUsuario.email}</li>
		<li><a href="./habitacion.jsp">Hid:${elUsuario.hid}</a></li>
		
		//Tiene que tener .jsp
	
	</ul>
</body>
</html>