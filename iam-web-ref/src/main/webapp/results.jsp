<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
<h1>Please enter a value</h1>
	<%
		List<String> results = (List<String>) session.getAttribute("results");
	%>

	<table>
		<thead>
			<tr>
				<th>result value</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (String result : results) {
			%>
			<tr>
				<td><%=result%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>


</body>
</html>