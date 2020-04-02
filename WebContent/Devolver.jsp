<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="Get.Locacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Devolver</title>
</head>
<body bgcolor="Silver">
	
	<%
		List<Locacao> locacao;
		if (session.getAttribute("locacao") == null) {
			locacao = new ArrayList<Locacao>();
			session.setAttribute("locacao", locacao);
		} else
			locacao = (ArrayList<Locacao>) session.getAttribute("locacao");
		
		int locId = Integer.parseInt(request.getParameter("locId"));
		
		Locacao loc = locacao.get(locId);

	%>
	
<center>
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="DevolverCad" method="GET">
		<p>Confirmação da Devolução</p>
		<input type="hidden" name="updateLocacao" value="<%= locId %>" />
		<input type="submit" value="Sim" /><br><br>
		</form>
	</div>
</center>
</body>
</html>