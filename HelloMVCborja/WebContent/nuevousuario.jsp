<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
</head>
<body>


	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>
		<div>
			<input type="text" placeholder="nombre" name="nombre" id="nombre"
				value="${newusuario.name}" required />
		</div>
		<div>
			<input type="text" placeholder="Email" name="email" id="email"
				value="${newusuario.email}" required />
				<div class="error esconder" id="repass</div>
		</div>
		<div>
			<input type="password" placeholder="Password" name="password"
				id="password" value="" required />
		</div>
		<div>
			<input type="password" placeholder="Password Confirmation"
				name="passwordconfirmation" id="passwordconfirmation" value=""
				required />
		</div>


		<label for="habitacion">Habitación</label>
		 <select name="habitacion" id="habitacion">
			<c:forEach var="unaHab" items="${lashabitaciones}">
				<option value="${unaHab.hid}">${unaHab.calle}</option>
			</c:forEach>
		</select> 
		<a href="./nuevahabitacion">Nueva Habitacion</a>

		<div>
			<button>Enviar</button>
		</div>
	</form>
</body>
</html>