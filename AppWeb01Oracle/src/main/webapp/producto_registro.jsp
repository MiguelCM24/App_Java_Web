<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de productos</title>
</head>
<body>


	<b>Registro de productos </b>

	<form action="ProductoServlet" method="post">
		<table style="width: 30%; border-style: solid; border-color:silver;">

			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" value="Televisor demo"></td>
			</tr>

			<tr>
				<td>Precio:</td>
				<td><input type="text" name="txtPrecio" value="5000.00"></td>
			</tr>

			<tr>
				<td>Cantidad:</td>
				<td><input type="text" name="txtCantidad" value="5"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><button type="submit">Registrar</button> <button type="reset">Limpiar</button></td>
			</tr>

		</table>
	</form>
</body>
</html>