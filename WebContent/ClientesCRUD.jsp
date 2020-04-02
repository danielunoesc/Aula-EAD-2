<%@page import="java.util.*"%>
<%@page import="Get.Pessoas"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes Cliente</title>
</head>
<body bgcolor="Silver">

<%
		List<Pessoas> pessoas;
		if (session.getAttribute("pessoas") == null) {
			pessoas = new ArrayList<Pessoas>();
			session.setAttribute("pessoas", pessoas);
		} else
			pessoas = (ArrayList<Pessoas>) session.getAttribute("pessoas");
		
		int pesId = Integer.parseInt(request.getParameter("pesId"));
		
		Pessoas pes = pessoas.get(pesId);

	%>
	
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="PessoaCad" method="GET">

		<br />
		<center>
			Nome: <input type="text" name="NamePes" value= "<%=pes.getNamePes() %>"><br /> <br />
			Sobrenome: <input type="text" name="SobrePes" value= "<%=pes.getSobrePes() %>"><br /> <br />
			Nasc: <input type="date" name="NascPes" value= "<%=pes.getDataNasDateInput() %>"><br /> <br />
			CNH - Numero - Categoria: <input type="text" name="CnhPes" value= "<%=pes.getCnhPes() %>"><br /> <br />
			Telefone - DDD: <input size ="1" width="1" type="text" name="DDDPes" value= "<%=pes.getDDDPes() %>">
			Numero: <input type="text" name="NumPes" value= "<%=pes.getNumPes() %>"><br /> <br /> 
			E-mail: <input type="text" name="EmailPes" value= "<%=pes.getEmailPes() %>"><br /> <br /> 
			Endereço: <input type="text" name="EndPes" value= "<%=pes.getEndPes() %>"><br /> <br /> 
			Cidade: <input type="text" name="CidPes" value= "<%=pes.getCidPes() %>">
			UF: <input size ="1" width="1" type="text" name="UfPes" value= "<%=pes.getUfPes() %>"><br /> <br /> 
			
			<input type="hidden" name="updatePessoa" value="<%= pesId %>" />
			
			<input type="submit" value="Editar" /><br><br>
			<a href="Index.jsp"><h3>Voltar</h3></a>
		</center>
		
		
	</form>
	</div>


</body>
</html>