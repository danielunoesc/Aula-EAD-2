<%@page import="java.util.ArrayList"%>
<%@page import="Get.Carros"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes Carro</title>
</head>
<body bgcolor="Silver">

<%
		List<Carros> carros;
		if (session.getAttribute("carros") == null) {
			carros = new ArrayList<Carros>();
			session.setAttribute("carros", carros);
		} else
			carros = (ArrayList<Carros>) session.getAttribute("carros");
		
		int carId = Integer.parseInt(request.getParameter("carId"));
		
		Carros car = carros.get(carId);

	%>
	
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="CarroCad" method="GET">

		<br />
		<center>
			Codigo: <input type="text" name="Codcar" value= "<%=car.getCodcar() %>"/>	<br/> <br/>
			Nome: <input type="text" name="NameCar" value= "<%=car.getNameCar() %>"/>	<br/> <br/>
			Preco: <input type="text" name="VlCar" value= "<%=car.getVlCar() %>"/>	<br/> <br/>
			Locacao: <input type="text" name="LocCar" value= "<%=car.getLocCar() %>"/>	<br/> <br/> 
			
			<select
				id="Marca" name="MarCar">
				<option value="<%=car.getMarCar() %>">Fiat</option>
			</select> 
			
			<select id="Modelo" name="ModCar">
				<option value="<%=car.getModCar() %>">Sedan</option>
			</select> <br> <br> 
			
			<input type="hidden" name="hdcarId" value="<%= carId %>" />
			
			<input type="submit" value="Editar" /><br><br>
			<a href="Index.jsp"><h3>Voltar</h3></a>
		</center>
		
		
	</form>
	</div>

</body>
</html>