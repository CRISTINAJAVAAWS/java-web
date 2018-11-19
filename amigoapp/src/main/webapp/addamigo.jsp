<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Añadir Amigos</title>
</head>
<body>
	<h1>Date de alta</h1>
	<form action="" method="POST"
	id="nuevousuarioform" novalidate>

		<div class="error">${mensajeerror}</div>
		<div>
			<input type="email" placeholder="Email" name="email" id="email"
				value="${newusuario.email}" required />
		</div>
		
		<div>
			<input type="text" placeholder="Nombre" name="nombre" id="nombre"
				value="${newusuario.name}" />
		</div>
		<div>
			<input type="password" placeholder="Contraseña" name="pass" id="pass"
				value="${newusuario.password}" />
		</div>
		<div>
			<input type="password" placeholder="Repetir contraseña"
				name="reppass" id="reppass" />
		</div>
		

			
			<div>
				<button id="enviarBtn">Enviar</button>
			</div>
			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>


			<h2>Usuarios</h2>
			<ul>
			
				var="unUsuario" items="${losUsuarios}">
					<li><a href="./amigoappservlet=${unUsuario.id}">
							<div>${unUsuario.id}</div>
							<div>${unUsuario.name}</div>
							<div>${unUsuario.email}</div>
					</a></li>
</c:forEach>
</ul>

</body>
</html>