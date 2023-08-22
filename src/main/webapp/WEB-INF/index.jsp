<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Tu puntuación ${oro}</h1>
		<div class="row">
			<div class="col border">
				<h3>Granja</h3>
				<p>Ganas 10 - 20 monedas</p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value="granja" >
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-success">
				</form>
			</div>
			<div class="col border">
				<h3>Cueva</h3>
				<p>Ganas 5 - 10 monedas</p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value="cueva" >
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-info">
				</form>
			</div>
			<div class="col border">
				<h3>Casa</h3>
				<p>Ganas 2 - 5 monedas</p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value="casa" >
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-primary">
				</form>
			</div>
			<div class="col border">
				<h3>Casino</h3>
				<p>Ganas/Pierdes 0 - 50 monedas</p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value="casino" >
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-danger">
				</form>
			</div>
		</div>
		<div class="row">
			<h2>Actividades</h2>
			<p>Entraste a la granja y ganaste 10 monedas. (Fecha)</p>
			<p>Entraste a la granja y ganaste 10 monedas. (Fecha)</p>
			<p>Entraste a la granja y ganaste 10 monedas. (Fecha)</p>
			<p>Entraste a la granja y ganaste 10 monedas. (Fecha)</p>
		</div>
	</div>
</body>
</html>