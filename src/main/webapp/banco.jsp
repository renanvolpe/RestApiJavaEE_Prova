<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "Model.java.JavaBeans" %>
    <%@ page import = "java.util.ArrayList " %>
    <%
    
    ArrayList<JavaBeans> listaMov = (ArrayList<JavaBeans>)request.getAttribute("movimentacao");
    
   
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>provinha de banco</title>
</head>
<body>
<h1> Banco de dados</h1>

<a href="novo.html"> Realizar deposito </a>
<br>
<br>

<a  href="sacar.html"> Realizar Saque </a>

<h3> Listando todas movimentacoes </h3>
<table>
<thead>
<tr> 
<th> descricao </th>
<th> Valor </th>
<th> tipo</th>
<th> Data </th>
</tr>
</thead>
<tbody>
<%   double somaTotal = 0;
for(int i = 0; i<listaMov.size(); i++){%>
	<tr>
	<td><%=listaMov.get(i).getDescricao() %> 			</td>
	
	
	
	<td><%=listaMov.get(i).getValor() %> 			</td>
	
	
	
	<td><%=listaMov.get(i).getTipo() %> 			</td>
	
	
	<td><%=listaMov.get(i).getData() %> 			</td>
	
	<td><a href="">Editar </a>			</td>
	</tr>
<%
if(listaMov.get(i).getTipo().equals("Entrada")){
	somaTotal = somaTotal +  Double.parseDouble(listaMov.get(i).getValor());
}else{
	somaTotal = somaTotal - Double.parseDouble(listaMov.get(i).getValor());
}

}%>

Soma total: <%=somaTotal%>


</tbody>
</table>


</body>
</html>