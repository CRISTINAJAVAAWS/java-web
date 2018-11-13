<%@page import="com.cristina.models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Usuario elUsuario = (Usuario)request.getAttribute("elUsuario");
%>
${requestScope.elUsuario}

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>




   
    
     <h1>Datos de usuario</h1>
    <ul>
    <li>Id: ${elUsuario.id}></li>
    <li>Nombre: ${elUsuario.name}</li>
    <li>Email: ${elUsuario.email}</li>
    <li>Habitacion :${laHabitacion.email}
    <a href="/habitacion.jsp">Habitacion</a>
    </ul>
</body>
</html>

