<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kyselylista</title>
</head>
<body>
	<div id="kyselyt">
		<h1>Kyselylista:</h1>
		<table>
			<tr>
				<th>KYSELYN NIMI</th>
				<th>KYSELYN KUVAUS</th>
			</tr>
			<c:forEach var="kysely" items="${kyselyt}" varStatus="status">
			<tr>
				<td><c:out value="${kysely.kyselyName}" default="-----" /></td>
				<td><c:out value="${kysely.kyselyDesc}" default="-----" /></td>
			</tr>
			<tr>
				<td><a href="lisaaKysymys?kyselyId=<c:out value='${kysely.kyselyId}'/>">Lisää kysymys</a>
				<!-- Viltsu: tuossa yläpuolella on tapa jolla lisään muuttujan menemään controlleriin ja siitä eteenpäin.
				eli luon kyselyId muuttujan jolla on arvona kyselyId tuosta kysely listasta. -->
				</td>
			</tr>
			
			</c:forEach>
		</table>
		
		
	</div>
	
	<p><a href="/Kysely/">Palaa alkuun</a></p>
	
</body>

</html>