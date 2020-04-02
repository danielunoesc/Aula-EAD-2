<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="Get.Pessoas"%>
<%@page import="Get.Carros"%>
<%@page import="Get.Locacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Locação</title>
</head>
<body bgcolor="Silver">

	<br />
	<center>
		<%
			List<Pessoas> pessoas;
			pessoas = (ArrayList<Pessoas>) session.getAttribute("pessoas");
		%>
		<%
			List<Carros> carros;
			carros = (ArrayList<Carros>) session.getAttribute("carros");
		%>		
			
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="locacaoCad" method="GET">
		
				<br />
							
				<br /><br>
				Selecione o Cliente: 
				<select id="pes" name="pessoas">
				<% for (Pessoas p : pessoas){ 
					out.print("<option value=\""+p.getNamePes()+"\" >"+p.getNamePes()+"</option>");
				} %>
				</select>
				
				<br /><br>
				Selecione o Carro: 
				<select id="car" name="carros">
				<% for (Carros c : carros){ 
					out.print("<option value=\""+c.getNameCar()+"\" >"+c.getNameCar()+"</option>");
				} %>
				</select>
					<br /><br />
				
				Data Locação: <input type="date" name="dtLoc"><br /> <br />
				Data Est. Devolução: <input type="date" name="dtEst"><br /> <br />
				Valor Locação/Dia: <input type="text" name="vlloc"><br /> <br />
				
				
				<input type="submit" value="Adicionar" /><br><br>
		</form>
		</div>
		
	<p>Carros Emprestados</p>
	</center>
	<br />
		<% int j = 0; %>
    <% String var = "String"; %>
	<%
		List<Locacao> locacao;
		if (session.getAttribute("locacao") == null) {
			locacao = new ArrayList<Locacao>();
			session.setAttribute("locacao", locacao);
		} else
			locacao = (ArrayList<Locacao>) session.getAttribute("locacao");
	%>
		
		<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse; ">
 	<% if (locacao.size() > 0) {%>
		<table style="width:100%">
  			<tr>
				<th>Carro</th>
				<th>Pessoa</th>
				<th>D. Locacao</th> 
				<th>D. Estimativa</th> 
				<th>Valor Locação</th>
				<th>D. Devolução</th> 
				<th>Valor Multa</th>
				<th>Valor Pago</th>
				<th>Situação</th>
				<th>Devolver</th>
		  </tr>
			<% for (Locacao loc : locacao){
				out.print("<tr style=\"border: 1px solid black;\"> ");
				out.print("<td style=\"border: 1px solid black;\"> "+loc.getCarros()+"</td>");
				out.print("<td style=\"border: 1px solid black;\"> "+loc.getPessoas()+"</td>");
				out.print("<td style=\"border: 1px solid black;\"> "+loc.getDataLocacaoFormated()+"</td>");
				out.print("<td style=\"border: 1px solid black;\"> "+loc.getDataEstimativaFormated()+"</td>");
				out.print("<td style=\"border: 1px solid black;\"> "+loc.getVlloc()+"</td>");		
				
				if (loc.getDtDev() == null){
					out.print("<td style=\"border: 1px solid black;\"> Sem Data </td>");
				}else
					out.print("<td style=\"border: 1px solid black;\"> "+loc.getDevolucaoFormated()+"</td>");
				
				if (loc.getVlMul() == 0 && loc.getFlDev() == 0){
					out.print("<td style=\"border: 1px solid black;\">Locação Aberta</td>");
				}else if(loc.getVlMul() == 0 && loc.getFlDev() == 1){
					out.print("<td style=\"border: 1px solid black;\">Sem multa</td>");
				}
				else
					out.print("<td style=\"border: 1px solid black;\"> "+loc.getVlMul()+"</td>");
				
				if (loc.getVlPag() == 0){
					out.print("<td style=\"border: 1px solid black;\"> Locação Aberta </td>");
				}else
					out.print("<td style=\"border: 1px solid black;\"> "+loc.getVlPag()+"</td>");
				
				if (loc.getFlDev() == 0){
					out.print("<td style=\"border: 1px solid black;\"> Pendente </td>");
					out.print("<td style=\"border: 1px solid black;\">  <a href=\"Devolver.jsp?locId="+locacao.indexOf(loc)+"\"> Devolver </a></td>");
				}else
					out.print("<td style=\"border: 1px solid black;\"> Devolvido </td>");
				out.print("</tr>");
			} %>
		</table>
	<%} else { %>
		<p></p>
	<%} %>
	</div>
			</br>
			</br>
			<center><a href="Index.jsp"><h3>Voltar</h3></a></center>

</body>
</html>