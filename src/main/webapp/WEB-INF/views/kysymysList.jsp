<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="kysymykset">
		<h1>Kysymykset:</h1>
		<table>
			<tr>
				<th>Kysymys</th>
				<th>Kysymys type</th>
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