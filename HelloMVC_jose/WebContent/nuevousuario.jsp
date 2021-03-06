<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link href="./CSS/style.css" rel="stylesheet">
</head>
<body>


	<h1>Nuevo Usuario</h1>

	<div id="errormensaje" class="error hide">${mensajeerror}</div>
	<p></p>

	<form id="registerform" action="" method="POST">
		<!-- Para proteger nuestros datos metods el método post, los encripta -->

		<div>
			<input type="text" placeholder=" Nombre y apellido" name="nombre"
				id="nombre" value="${newusuario.name}" minlength="3" maxlength="10"required/>
				 <div id="errornombre" class="hide">Nombre incorrecto</div>
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet, con el value accedemos al objeto usuario y tras el puntoa las propiedades de las clase Usuario -->

		</div>
		<p></p>

		<div>
			<input type="text" placeholder=" Email" name="email" id="email"
				value="${newusuario.email}" required/>
				 <div id="erroremail" class="hide">Email incorrecto</div>
			<!-- el name es el nombre del parámetro que voy a recibir en el servlet -->

		</div>
		
		<p></p>

		<div>
			<input type="password" placeholder=" Password" name="password" minlength="4"
				maxlength="9" pattern="[a-zA-Z0-9]*" id="password" value="" required/>
				 <div id="errorpassword" class="hide">El password es incorrecto</div>

		</div>
		
		<p></p>

		<div>
			<input type="password" placeholder=" Confirmarpassword"
				name="confirmarpassword" minlength="4" maxlength="9" pattern="[a-zA-Z0-9]*"
				id="confirmarpassword" required/>
				 <div id="errorconfirmar" class="hide">El password no coincide</div>

		</div>

		<p></p>
		<!-- Aqui iran las habitaciones, la plantilla tiene que recibir la lista de habitaciones de NuevoUsarioServlet -->
		<!--lashabitaciones es el atributo que he dejado en el servlet. unHab es solo una variable local-->
		<div>
			<label id="habitacion">Elige habitación: </label> <select
				name="habitacion" id="habitacion">
				<c:forEach var="unaHab" items="${lashabitaciones}">
					<option value="${unaHab.hid}">${unaHab.calle}</option> <!-- Crear un enlace para una nueva habitacion. Añadir una nueva habitacion -->
				</c:forEach>
			</select>
		</div>
		
		<a href="./nuevahabitacion">Elegir nueva habitacion</a> <!-- apunta a la direccion del servlet de nueva habitacion -->


		<p></p>

		<div>
			<button id="validform">Darse de alta</button>

		</div>

	</form>

</body>
<script src="./jquery-3.3.1.min.js"></script>
<script src="./JS/validarFormulario.js"></script>
</html>