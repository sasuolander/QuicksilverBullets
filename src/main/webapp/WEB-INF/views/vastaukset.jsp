<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista vastauksia</title>
</head>
<body>
	<div id="vastaukset">
		<h1>Vastaukset:</h1>
		<table>
			<tr>
				<th>Vastaus Id</th>
				<th>Vastaus</th>
			</tr>
			<c:forEach var="vastaus" items="${vastauksetObject}" varStatus="status">
			<tr>
				<td><c:out value="${vastaus.vastausId}" default="-----" /></td>
				<td><c:out value="${vastaus.vastaus}" default="-----" /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<p><a href="/Kysely/">Palaa alkuun</a></p>
</body>

</html>