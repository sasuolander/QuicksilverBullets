<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kysymyslista</title>
</head>
<body>
	<div id="kysymykset">
		<h1>Kysymyslista:</h1>
		<table>
			<tr>
				<th>KYSYMYS</th>
				<th>KYSYMYKSEN TYYPPI</th>
			</tr>
			<c:forEach var="kysymys" items="${kysymykset}" varStatus="status">
			<tr>
				<td><c:out value="${kysymys.kysymys}" default="-----" /></td>
				<td><c:out value="${kysymys.kysymysType}" default="-----" /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<p><a href="/Kysely/">Palaa alkuun</a></p>
</body>

</html>