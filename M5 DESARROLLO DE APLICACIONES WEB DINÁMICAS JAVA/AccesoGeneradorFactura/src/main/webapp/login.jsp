<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login: Generador Factura</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Generador<br>de<br>Factura</h1>
	<form class="container border rounded py-4" style="width: 22rem;" id="loginFormulario" method="post">

		<div class="form-outline mb-4">
			<label class="form-label" for="usuario" style="margin-left: 0px;">Usuario</label>
			<input type="text" id="usuario" name="usuario" class="form-control">
			<div class="form-notch">
				<div class="form-notch-leading" style="width: 9px;"></div>
				<div class="form-notch-middle" style="width: 88.8px;"></div>
				<div class="form-notch-trailing"></div>
			</div>
		</div>

		<!-- Password input -->
		<div class="form-outline mb-4">
			<label class="form-label" for="contrasenia" style="margin-left: 0px;">Contraseña</label>
			<input type="password" id="contrasenia" name="contrasenia" class="form-control">

			<div class="form-notch">
				<div class="form-notch-leading" style="width: 9px;"></div>
				<div class="form-notch-middle" style="width: 64px;"></div>
				<div class="form-notch-trailing"></div>
			</div>
		</div>


		<button type="submit" class="btn btn-success btn-block mb-4">Ingresar</button>
		<div class="text-center">
			<p>
				¿No estás regristrado? <a href="#!">Registrate</a>
			</p>
		</div>
	</form>

</body>
</html>