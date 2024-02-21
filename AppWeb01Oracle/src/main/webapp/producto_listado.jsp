<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.List"%>
<%@ page import="pe.edu.galaxy.training.java.web.dao.ProductoDAO"%>
<%@ page import="pe.edu.galaxy.training.java.web.dao.ProductoDAOImpl"%>
<%@ page import="pe.edu.galaxy.training.java.web.bean.Producto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de productos</title>
</head>
<body>
	<p style="width:500px; text-align: center;">
		<b>Listado de productos </b>
	<hr>
	<%
	ProductoDAO productoDAO = new ProductoDAOImpl();
	List<Producto> productos = productoDAO.listarTodos();
	%>
	<a href="producto_registro.jsp">Agregar</a>
	<table style="width: 50%; border-style: solid; border-color: lime;">
		<thead>
			<tr style="background-color: gray;; border-style: solid">
				<th style="width: 60px">Código</th>
				<th style="width: 260px">Nombre</th>
				<th style="width: 60px; align:right;">Precio</th>
				<th style="width: 60px; align:right;">Cantidad</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Producto producto : productos) {
			%>
			<tr>
				<td style="text-align:center" ><%=producto.getCodigo()%></td>
				<td><%=producto.getNombre()%></td>
				<td style="text-align:right"><%=producto.getPrecio()%></td>
				<td style="text-align:right"><%=producto.getCantidad()%></td>

			</tr>
			<%
			}
			%>
		</tbody>

	</table>
	</p>
</body>
</html>