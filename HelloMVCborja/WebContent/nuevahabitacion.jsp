<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Habitación</title>
</head>
<body>
	<h1>Nueva Habitacion</h1>
	<form action="" method="POST">
		<div>
			<input type="texto" placeholder="Calle" name="calle" id="calle"
				required />
		</div>
		<div>
			<input type="texto" placeholder="Metros" name="metros" id="metros"
				required />
				
				
				
		</div>
		<div>
			<label for="habitacion">Da de Alta tu Nueva Habitación</label> <select
				name="habitacion" id="habitacion"></select>
			<c:forEach var="unaHab" items="${lasHabitaciones}">
				<option value="${unaHab.hid}">${unaHab.calle}>${unaHab.metros}</option>
			</c:forEach>
			</select>
		</div>
		<div>
			<button>Agregar Habitación</button>
		</div>
	</form>

</body>
</html>