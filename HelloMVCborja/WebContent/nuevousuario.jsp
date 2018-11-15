<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		</div>
		<div>
			<input type="password" placeholder="Password" name="password"
				id="password" value="" required />
		</div>
		<div>
			<input type="password" placeholder="Password Confirmation"
				name="passwordconfirmation" id="passwordconfirmation"
				value="" required />
		</div>
		<div>
			<button>Enviar</button>
		</div>
	</form>
</body>
</html>